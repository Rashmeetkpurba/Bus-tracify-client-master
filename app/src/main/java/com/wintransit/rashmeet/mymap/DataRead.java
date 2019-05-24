package com.wintransit.nirmalpurohit.mymap;


public class DataRead {
    protected Double Latitude, Longitude;
    protected boolean Availability;

    public DataRead(Double Latitude, Double Longitude, boolean Availability){
        this.Latitude = Latitude;
        this.Longitude = Longitude;
        this.Availability = Availability;
    }

    public DataRead(){
    }

}
