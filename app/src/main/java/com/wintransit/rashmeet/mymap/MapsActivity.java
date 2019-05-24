package com.wintransit.nirmalpurohit.mymap;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMyLocationButtonClickListener,
        GoogleMap.OnMyLocationClickListener, LocationListener {

    private GoogleMap mMap;
    final int MY_LOCATION_REQUEST_CODE = 0;
    Marker marker, marker1;
    private Map<String, Marker> markerMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        assert mapFragment != null;
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

        if (ContextCompat.checkSelfPermission(MapsActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)
        {
            mMap.setMyLocationEnabled(true);
            mMap.setOnMyLocationButtonClickListener(this);
            mMap.setOnMyLocationClickListener(this);
            LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
            boolean GPSStatus = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
            if (!GPSStatus){
                Intent intent = new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivityForResult(intent, 0);
            }
        }
        else
        {
            ActivityCompat.requestPermissions(MapsActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_LOCATION_REQUEST_CODE);
        }

    }

    @Override
    public void onMyLocationClick(@NonNull Location location) {
    }

    @Override
    public boolean onMyLocationButtonClick() {
        return false;
    }

    @SuppressLint("MissingPermission")
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    {
        if (requestCode == MY_LOCATION_REQUEST_CODE) {
            if (grantResults.length >= 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show();
                mMap.setMyLocationEnabled(true);
                mMap.setOnMyLocationButtonClickListener(this);
                mMap.setOnMyLocationClickListener(this);
                LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0,  this);
                boolean GPSStatus = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
                if (!GPSStatus){
                    Intent intent = new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                    startActivityForResult(intent, 0);
                }
            }
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReferenceFromUrl("https://busgps-81c34.firebaseio.com/");
        final ArrayList<DataRead> dataRead = new ArrayList<>();
        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Iterable<DataSnapshot> allBuses = dataSnapshot.getChildren();
                int i = 0;
                for (DataSnapshot buses : allBuses) {
                    dataRead.add(buses.getValue(DataRead.class));
                    LatLng location = new LatLng(dataRead.get(i).Latitude, dataRead.get(i).Longitude);
                    Marker marker = markerMap.get(buses.getKey());


                    if (marker == null) {
                        if (dataRead.get(i).Availability)
                            marker1 = mMap.addMarker(new MarkerOptions().position(location).icon(BitmapDescriptorFactory.fromResource(R.drawable.green)).title(buses.getKey()));
                        else
                            marker1 = mMap.addMarker(new MarkerOptions().position(location).icon(BitmapDescriptorFactory.fromResource(R.drawable.red)).title(buses.getKey()));
                        markerMap.put(buses.getKey(), marker1);
                    }
                    else
                    {
                        if (dataRead.get(i).Availability)
                            marker.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.green));
                        else
                            marker.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.red));
                        marker.setPosition(location);
                    }
                    //drawMarker(buses.getKey(), location, dataRead.get(i).Availability);

                    i++;

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        ref.addValueEventListener(valueEventListener);
    }

    @Override
    public void onProviderDisabled(String provider) {
        Log.d("Latitude","disable");
    }

    @Override
    public void onProviderEnabled(String provider) {
        Log.d("Latitude","enable");
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        Log.d("Latitude","status");
    }

    public void drawMarker(String busName, LatLng location, boolean Availability){
        if (busName.equals("bus5")) {
            if (marker == null) {
                if (Availability)
                    marker = mMap.addMarker(new MarkerOptions().position(location).icon(BitmapDescriptorFactory.fromResource(R.drawable.green)).title("Crosstown 2"));
                else
                    marker = mMap.addMarker(new MarkerOptions().position(location).icon(BitmapDescriptorFactory.fromResource(R.drawable.red)).title("Crosstown 2"));
            } else {
                if (Availability)
                    marker.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.green));
                else
                    marker.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.red));
                marker.setPosition(location);
            }
        }
        else{
            if (marker1 == null) {
                if (Availability)
                    marker1 = mMap.addMarker(new MarkerOptions().position(location).icon(BitmapDescriptorFactory.fromResource(R.drawable.green)).title("other"));
                else
                    marker1 = mMap.addMarker(new MarkerOptions().position(location).icon(BitmapDescriptorFactory.fromResource(R.drawable.red)).title("other"));
            } else {
                if (Availability)
                    marker1.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.green));
                else
                    marker1.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.red));
                marker1.setPosition(location);
            }
        }
        }
}
