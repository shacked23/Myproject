package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {
private Intent goNextActivity2,startNext;
private EditText phone;
private  EditText name;
    private SharedPreferences sp;
    public static final String EXTRA_PhoneNumber="com.example.intent_with_extra.EXTRA_PhoneNumber";
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sp = getSharedPreferences("myProject",MODE_PRIVATE);
        setContentView(R.layout.activity_first);
        Button button = findViewById(R.id.join);
        phone = findViewById(R.id.name);
        name = findViewById(R.id.userName);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (phone.length() == 10 && name.length() > 0) {

                setTheShare();
                    Intent goToNextActivity2 = new Intent(FirstActivity.this,Shared_perference.class);
                    startActivity(goToNextActivity2);
                    finish();
                } else {
                    Toast.makeText(FirstActivity.this, "phoneNumber ", Toast.LENGTH_LONG).show();
                }

            }
        });

        // Checking if details are already saves in the system.
        // If so, moving to main activity
        checkForSavedDetails();
    }

    private void checkForSavedDetails() {
        sp = getSharedPreferences("myProject",MODE_PRIVATE);
        if (sp.contains("user_name") && sp.contains("phone_number")) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
    }

    public void setTheShare(){
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("user_name",name.getText().toString()).apply();
        editor.putString("phone_number",name.getText().toString()).apply();
        editor.apply();
    }


    }







