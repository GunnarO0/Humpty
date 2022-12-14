package com.example.humpty;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ActivitySocial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social);

        // Initialize and assign variable
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);

        // Set Home selected
        bottomNavigationView.setSelectedItemId(R.id.social);

        // Perform item selected listener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId())
                {
                    case R.id.events:
                        startActivity(new Intent(getApplicationContext(),ActivityEvents.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.social:
                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),ActivityHome.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }
}