package com.example.hw8p5;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        Intent intentHome = new Intent(MainActivity.this, HomeActivity.class);
                        startActivity(intentHome);
                        break;
                    case R.id.navigation_weather:
                        Intent intentWeath = new Intent(MainActivity.this, DisplayActivity.class);
                        startActivity(intentWeath);
                        break;
                    case R.id.navigation_map:
                        Intent intentMap = new Intent(MainActivity.this, MapActivity.class);
                        startActivity(intentMap);
                        break;
                    case R.id.navigation_history:
                        Intent intentHis = new Intent(MainActivity.this, HistoryActivity.class);
                        startActivity(intentHis);
                        break;

                }
                return true;
            }
        });

    }
}