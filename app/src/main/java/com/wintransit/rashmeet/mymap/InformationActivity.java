package com.wintransit.nirmalpurohit.mymap;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class InformationActivity extends AppCompatActivity {

    private String busName;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        final TextView textView = findViewById(R.id.detailsOfBus);
        Bundle inputName = getIntent().getExtras();
        busName = inputName.getString("Bus_name");
        switch (busName){
            case "1C":
                RequestQueue queue = Volley.newRequestQueue(this);
                //String url ="https://maps.googleapis.com/maps/api/directions/json?origin=College+Ave+at+community+centre&destination=Tecumseh+Mall+rear+entrance&mode=transit&key=AIzaSyD0bd_ljdd6VIy_3mHcFcAUwztBrEW5wJc";
                String url = "college at south\n" +
                        "college at pince\n" +
                        "prince at barrymore\n" +
                        "prince at mulford\n" +
                        "prince at vaughan\n" +
                        "prince at glenfield\n" +
                        "prince at whitney\n" +
                        "felix at tecumseh\n" +
                        "felix at manchester\n" +
                        "felix at giradot\n" +
                        "felix at millen\n" +
                        "felix at college\n" +
                        "felix at linwood\n" +
                        "mill at donnely\n" +
                        "mill at sandwich\n" +
                        "sandwich at detroit\n" +
                        "sandwich at chewitt\n" +
                        "university at huron church\n" +
                        "university at patricia\n" +
                        "university at california\n" +
                        "university at randolph\n" +
                        "university at partington\n" +
                        " university at campbell\n" +
                        " university at curry\n" +
                        "university at cameron\n" +
                        "university at wellington\n" +
                        "university at crawford\n" +
                        "university at caron\n" +
                        "university at bruce\n" +
                        "university at church\n" +
                        "victoria at university\n" +
                        "windsor transit terminal\n" +
                        "ouelette at chatham\n" +
                        "ouelette at park\n" +
                        "ouelette at wyandotte\n" +
                        "ouelette at elliott\n" +
                        " ouelette at erie\n" +
                        "ouelette at pine\n" +
                        "ouelette at giles\n" +
                        "ouelette at montrose\n" +
                        "ouelette at ellis\n" +
                        "ouelette at shepherd\n" +
                        "ouelette at hanna\n" +
                        "tecumseh E at ouellette\n" +
                        "tecumseh E at mcdougall\n" +
                        "tecumseh at howard\n" +
                        "tecumseh at marentette\n" +
                        "tecumseh at parent\n" +
                        "tecumseh at forest \n" +
                        "tecumseh at parkwood\n" +
                        "tecumseh at moy\n" +
                        "tecumseh at lincoln\n" +
                        "tecumseh at kildare\n" +
                        "tecumseh at byng\n" +
                        "tecumseh at walker\n" +
                        "tecumseh at cadllic\n" +
                        "tecumseh at chandler\n" +
                        "tecumseh at meldrum\n" +
                        "tecumseh at central\n" +
                        "tecumseh at aubin\n" +
                        "tecumseh at george\n" +
                        "tecumseh at rossini\n" +
                        "tecumseh at francois\n" +
                        "tecumseh at pillete\n" +
                        "tecumseh at norman\n" +
                        "tecumseh at westminster\n" +
                        "tecumseh at ford\n" +
                        "rivard at tecumseh\n" +
                        "rivard at adstoll\n" +
                        "rivard at rose\n" +
                        "rose at jos st. louis\n" +
                        "rose atlloyd george\n" +
                        "roseville at thronberry\n" +
                        "roseville at charlie brooks\n" +
                        "roseville at tecumseh\n" +
                        "tecumseh rd at eastpark plaza\n" +
                        "tecumseh mall near entrance\n" +
                        "tecumseh at lauzon parkway\n" +
                        "tecumseh at annie\n" +
                        "tecumseh at lauzon \n" +
                        "tecumseh at canadaian trie\n" +
                        "tecumseh at rafih\n" +
                        "tecumseh at penang\n" +
                        "tecumseh at metro plaza\n" +
                        "forest grade at tecumseh\n" +
                        "forest grade at esplamade\n" +
                        "forest grade at ridge\n" +
                        "forest grade at wildwood\n" +
                        "forest grade at mulberry\n" +
                        "forest grade at elmwood\n" +
                        "wildwood at rosebriar\n" +
                        "wildwood at hemlock\n" +
                        "wildwood at midfield\n" +
                        "wildwood at forest glade\n" +
                        "forest glade at ridge\n" +
                        "forest glade at eastcourt\n" +
                        "forest glade at tecumseh\n" +
                        "tecumseh at forest glade\n" +
                        "tecumseh at penang\n";


// Request a string response from the provided URL.
               /* StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                // Display the first 500 characters of the response string.
                                textView.setText("Response is: "+ response);
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        textView.setText("That didn't work!");
                    }
                });

// Add the request to the RequestQueue.
                queue.add(stringRequest);*/
                textView.setText(url);
                break;

            case "1A": textView.setText("One A"); break;

            case "2": textView.setText("Crosstown 2"); break;

            case "3": textView.setText("Central 3"); break;

            case "4": textView.setText("4"); break;

            case "5":
                String str = "Windsor International Transit terminaltransit terminal\n" +
                        "Riverside at Caron\n" +
                        "Riverside at Oak\n" +
                        "Riverside at ,cKay\n" +
                        "Campbell at riverside\n" +
                        "Campbell at University\n" +
                        "Campbell at Martindale\n" +
                        "Campbell at Wyandotte\n" +
                        "Campbell at Rooney\n" +
                        "Campbell at college\n" +
                        "Campbell at Adanac\n" +
                        "Campbell at Grooveat Grove\n" +
                        "Campbell at Taylor\n" +
                        "Campbell at Taylor\n" +
                        "Campbell at Pelletier\n" +
                        "Campbell at Tecumesh\n" +
                        "Campbell at Everts\n" +
                        "Campbell at Curry\n" +
                        "Dominion at Totten\n" +
                        "Dominion at Arcadia\n" +
                        "Dominion at McKay\n" +
                        "Dominion at Ojibway\n" +
                        "Dominion at Holy Names\n" +
                        "Dominion at Northwood\n" +
                        "Dominion at E.C Row\n" +
                        "Dominion at Labelle\n" +
                        "Dominion at Grand Maris\n" +
                        "Dominion at Noerkfolk at Norkfolk\n" +
                        "Dominion at Richardie\n" +
                        "Dominion at Beels\n" +
                        "Dominion at Roselawn\n" +
                        "Dominion at Canbanaat Cabana\n" +
                        "Mount Royal at Cabana\n" +
                        "Mount Royal at Villa Maria South\n" +
                        "Mount Royal at Villa Maria North\n" +
                        "Mount Royal at Mitchell\n" +
                        "Cousineau at Highway 3\n" +
                        "St. college Front entrance\n" +
                        "Geraedts at St.Clair Residence\n" +
                        "Glenwood at Canbana  at cabana\n" +
                        "Glenwood at St.Gariel\n" +
                        "Beals at Roxborough\n" +
                        "Beals at Rankin\n" +
                        "Rankin at liberty\n" +
                        "Norfolk at Rankin\n" +
                        "Norfolk at California\n";
                textView.setText(str); break;

            case "6": textView.setText("6"); break;

            case "14": textView.setText("14"); break;
        }
    }
}
