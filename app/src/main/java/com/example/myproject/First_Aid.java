package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class First_Aid extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first__aid);
        Button stoke=findViewById(R.id.stroke);
        Button burn=findViewById(R.id.burn);
        Button asthma=findViewById(R.id.asthma);
        Button bleed=findViewById(R.id.bleed);
        Button hyperthermia=findViewById(R.id.hyperthrmia);
        Button resucitation=findViewById(R.id.resucitation);
        stoke.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
startActivity(new Intent(First_Aid.this,First_Aid2.class));
            }
        });
        burn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(First_Aid.this,BurnActivity.class));
            }
        });
        asthma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(First_Aid.this,AsthmaActivity.class));
            }
        });
        bleed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(First_Aid.this,BleedActivity.class));
            }
        });
        hyperthermia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(First_Aid.this,Heat_Stoke_Activity.class));
            }
        }) ;
        resucitation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(First_Aid.this,ResuscitationActivity.class));
            }
        });
    }
}
