package com.example.humpty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ActivityLanding extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        final ImageButton homeSocial = (ImageButton) findViewById(R.id.landingSocial);
        //final ImageButton homeEvents = (ImageButton) findViewById(R.id.landingEvents);
        final ImageButton create = (ImageButton) findViewById(R.id.landingCreateEvent);
        
        homeSocial.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),ActivitySocial.class);
                startActivity(i);

            }
        });
        
//        homeEvents.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(getApplicationContext(),ActivityEvents.class);
//                startActivity(i);
//
//            }
//        });

        create.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),AddFriends.class);
                startActivity(i);

            }
        });

    }
}