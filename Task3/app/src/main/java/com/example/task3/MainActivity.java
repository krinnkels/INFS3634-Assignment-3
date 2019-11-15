package com.example.task3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bot_nav);


        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.container_cat_results, new HomeFragment()).commit();
        }
    }
    }

