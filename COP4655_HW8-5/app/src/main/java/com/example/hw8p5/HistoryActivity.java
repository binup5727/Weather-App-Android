package com.example.hw8p5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {

    WeatherData data = HomeActivity.getWeatherInstance();
    ArrayList<WeatherData> his = new ArrayList<WeatherData>(5);
    int Time [] = {0, 0, 0, 0, 0};
    private RequestQueue queue;
    String url[] = {"","","","",""};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        queue = Volley.newRequestQueue(this);

        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        Intent intentHome = new Intent(HistoryActivity.this, HomeActivity.class);
                        startActivity(intentHome);
                        break;
                    case R.id.navigation_weather:
                        Intent intentWeath = new Intent(HistoryActivity.this, DisplayActivity.class);
                        startActivity(intentWeath);
                        break;
                    case R.id.navigation_map:
                        Intent intentMap = new Intent(HistoryActivity.this, MapActivity.class);
                        startActivity(intentMap);
                        break;

                }
                return true;
            }
        });

        getHistory();
        ArrayList<WeatherData> arrayofWeath = his;
        ListView simpleList;
        simpleList = (ListView) findViewById(R.id.simplelistView);
        CustomAdapter customAdapter = new CustomAdapter(this, his);
        simpleList.setAdapter(customAdapter);






    }

    public void getHistory(){
        final boolean[] move = {false};
        int t = (Integer.parseInt(data.getTime()));
        for(int i = 0; i < 5; i++){

            Time[i] = t;
            t = t - 86400;
            his.add(new WeatherData());


        }




        for(int i = 0; i < 5; i++) {

            url[i] = getString(R.string.HISTORY_API_URL) + "lat=" + data.getLat() + "&lon=" + data.getLon() +
                    "&dt=" + Time[i] + getString(R.string.WEATHER_API_KEY);


            System.out.println(url[i]);
        }

        request(0);











    }
    public void request(int count){

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url[count], null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        JSONObject main;
                        try {

                            main = response.getJSONObject("current");


                            his.get(count).setTemp(main.getString("temp"));

                            his.get(count).setFeelsLike(main.getString("feels_like"));

                            his.get(count).setCityName(data.getCityName());

                            his.get(count).setWind(main.getString("wind_speed"));

                            his.get(count).setHumid(main.getString("humidity"));

                            his.get(count).setTimeLong(main.getLong("dt"));
                            System.out.println("time " );

                            if(count < 4){
                                request(count + 1);
                            }else{
                                return;
                            }

                            //TODO : Bundle the weather object and send to next activity
                            //Current implementation is just using static member


                        } catch (JSONException e) {
                            System.out.println("JSON EXPLOSION");
                        }


                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println("ERROR WITH VOLLEY REQUEST");

                    }
                });
        queue.add(jsonObjectRequest);





    }


}