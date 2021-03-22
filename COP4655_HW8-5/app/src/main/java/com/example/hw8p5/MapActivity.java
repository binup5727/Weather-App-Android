package com.example.hw8p5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        Intent intentHome = new Intent(MapActivity.this, HomeActivity.class);
                        startActivity(intentHome);
                        break;
                    case R.id.navigation_weather:
                        Intent intentWeath = new Intent(MapActivity.this, DisplayActivity.class);
                        startActivity(intentWeath);
                        break;
                    case R.id.navigation_history:
                        Intent intentHis = new Intent(MapActivity.this, HistoryActivity.class);
                        startActivity(intentHis);
                        break;

                }
                return true;
            }
        });


    }
}