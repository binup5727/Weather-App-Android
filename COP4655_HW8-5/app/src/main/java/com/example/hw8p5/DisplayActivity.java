package com.example.hw8p5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Locale;

public class DisplayActivity extends AppCompatActivity {

    TextView city;
    TextView temp;
    TextView min;
    TextView max;
    TextView feels;
    TextToSpeech t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        WeatherData w = HomeActivity.getWeatherInstance();
        city = findViewById(R.id.cityView);
        temp = findViewById(R.id.tempView);
        min =  findViewById(R.id.minView);
        feels = findViewById(R.id.feelsView);
        max = findViewById(R.id.maxView);

        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        Intent intentHome = new Intent(DisplayActivity.this, HomeActivity.class);
                        startActivity(intentHome);
                        break;
                    case R.id.navigation_map:
                        Intent intentMap = new Intent(DisplayActivity.this, MapActivity.class);
                        startActivity(intentMap);
                        break;
                    case R.id.navigation_history:
                        Intent intentHis = new Intent(DisplayActivity.this, HistoryActivity.class);
                        startActivity(intentHis);
                        break;


                }
                return true;
            }
        });

        city.setText("Weather for " + w.getCityName());
        temp.setText("Temperature : " + String.valueOf(Math.floor(KtoF(Double.parseDouble(w.getTemp())))) + "F");
        min.setText("Low : " + String.valueOf(Math.floor(KtoF(Double.parseDouble(w.getTempMin()))))+ "F");
        max.setText("Maximum : " + String.valueOf(Math.floor(KtoF(Double.parseDouble(w.getTempMax())))) + "F");
        feels.setText("Feels like : " + String.valueOf(Math.floor(KtoF(Double.parseDouble(w.getFeelsLike()))))+ "F");



        t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.US);
                }
            }
        });





    }

    public static double KtoF(Double k){
        return ((k - 273.15) * 9/5 + 32);
    }

    public void onPresscity(View v){
        String word = city.getText().toString();
        System.out.println(word);

        t1.speak(word, TextToSpeech.QUEUE_FLUSH, null);

    }

    public void onPresstemp(View v){
        String word = temp.getText().toString();
        System.out.println(word);

        t1.speak(word, TextToSpeech.QUEUE_FLUSH, null);

    }

    public void onPressmin(View v){
        String word = min.getText().toString();
        System.out.println(word);

        t1.speak(word, TextToSpeech.QUEUE_FLUSH, null);

    }

    public void onPressmax(View v){
        String word = max.getText().toString();
        System.out.println(word);

        t1.speak(word, TextToSpeech.QUEUE_FLUSH, null);

    }
    public void onPressfeels(View v){
        String word = feels.getText().toString();
        System.out.println(word);

        t1.speak(word, TextToSpeech.QUEUE_FLUSH, null);

    }

    public void onPause(){
        if(t1 !=null){
            t1.stop();
            t1.shutdown();
        }
        super.onPause();
    }


}