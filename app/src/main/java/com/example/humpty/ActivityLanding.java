package com.example.humpty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class ActivityLanding extends AppCompatActivity {

    private int miles, moneyCount, time;
    private float ratingCount;
    private TextView moneyText;
    private TextView ratingText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        moneyCount = 3;
        ratingCount = 3;
        moneyText = (TextView) findViewById(R.id.money);
        ratingText = (TextView) findViewById(R.id.rating);

        final ImageButton social = (ImageButton) findViewById(R.id.landingSocial);
        social.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),ActivitySocial.class);
                startActivity(i);

            }
        });

        final ImageButton events = (ImageButton) findViewById(R.id.landingEvents);
        events.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),ActivityEvents.class);
                startActivity(i);

            }
        });

        final ImageButton create = (ImageButton) findViewById(R.id.landingCreateEvent);
        create.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ActivityAddFriends.class);
                startActivity(i);

            }
        });


        final ImageButton moneyDecrement = (ImageButton) findViewById(R.id.moneyDecrement);
        moneyDecrement.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(moneyCount > 1){
                    moneyCount--;
                    ChangeMoney();
                }
            }
        });
        final ImageButton moneyIncrement = (ImageButton) findViewById(R.id.moneyIncrement);
        moneyIncrement.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(moneyCount < 5){
                    moneyCount++;
                    ChangeMoney();
                }
            }
        });
        final ImageButton ratingDecrement = (ImageButton) findViewById(R.id.ratingDecrement);
        ratingDecrement.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(ratingCount > 0){
                    ratingCount -= .5;
                    ratingText.setText(">= " + ratingCount);
                }
            }
        });
        final ImageButton ratingIncrement = (ImageButton) findViewById(R.id.ratingIncrement);
        ratingIncrement.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(ratingCount < 5){
                    ratingCount += .5;
                    ratingText.setText(">= " + ratingCount);
                }
            }
        });

    }

    private void ChangeMoney(){
        switch (moneyCount){
            case 1: moneyText.setText("$");
            break;
            case 2: moneyText.setText("$$");
                break;
            case 3: moneyText.setText("$$$");
                break;
            case 4: moneyText.setText("$$$$");
                break;
            case 5: moneyText.setText("$$$$$");
                break;
            default:
                break;
        }
    }

}