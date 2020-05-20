package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;
import android.content.SharedPreferences;
import com.google.android.gms.maps.MapView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Intent goToNextActivity;
    private Intent goNextActivity3;
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton madeButton = findViewById(R.id.madaButto);
        ImageButton policeButton = findViewById(R.id.policeButton);
        ImageButton macbiButton = findViewById(R.id.mcbiButton);
        ImageButton yedidimButton = findViewById(R.id.yedidim);
        ImageButton pepoleButton = findViewById(R.id.peopleButton);
        Button logoutButton = findViewById(R.id.logoutButton);
        final Button first_aid=findViewById(R.id.first_aid);
        first_aid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,First_Aid.class));
            }
        });
        MapView map = findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToNextActivity3 = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(goToNextActivity3);
                finish();
            }
        });
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });
        yedidimButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTheCallYedidim();

            }
        });
        macbiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTheCallMacbi();


            }
        });
        policeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setThePhoneCallPolice();

            }
        });
        madeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setThePhoneCallIntent();

            }
        });
        pepoleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCallPeople();

            }
        });


        Spinner spiner = (Spinner) findViewById(R.id.madaSpinner);
        List<String> mada = new ArrayList<String>();
        mada.add("התקף לב");
        mada.add("תאונה");
        mada.add("לחץ דם");
        mada.add("שבץ מוחי");
        mada.add("דימום");
        mada.add("כויות");
        mada.add("התקף אסטמה");
        mada.add("לידה");
        mada.add("אחר");

        ArrayAdapter<String> eventAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, mada);
        eventAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spiner.setAdapter(eventAdapter);
        spiner.setSelection(0, false);
        spiner.setOnItemSelectedListener(this);

        Spinner policespinner = findViewById(R.id.policeSpinner);
        List<String> police = new ArrayList<String>();
        police.add("תאונה");
        police.add("חטיפה");
        police.add("גניבה");
        police.add("אלימות");
        police.add("אחר");
        ArrayAdapter<String> eventAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, police);
        eventAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        policespinner.setAdapter(eventAdapter2);
        policespinner.setSelection(0, false);
        policespinner.setOnItemSelectedListener(this);

        Spinner macbispinner = findViewById(R.id.mcbiSpinner);
        List<String> macbi = new ArrayList<String>();
        macbi.add("שריפה");
        macbi.add("בעל חיים תקוע");
        macbi.add("חילוץ");
        macbi.add("אחר");
        ArrayAdapter<String> eventAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, macbi);
        eventAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        macbispinner.setAdapter(eventAdapter3);
        macbispinner.setSelection(0, false);
        macbispinner.setOnItemSelectedListener(this);

        Spinner yedidimspinner = findViewById(R.id.yedidimSpinner);
        List<String> yedidim = new ArrayList<String>();
        yedidim.add("החלפת גלגל");
        yedidim.add("התנעת רכב");
        yedidim.add("חילוץ");
        yedidim.add("רכב תקוע");
        yedidim.add("אחר");
        ArrayAdapter<String> eventAdapter4 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, yedidim);
        eventAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        yedidimspinner.setAdapter(eventAdapter4);
        yedidimspinner.setSelection(0, false);
        yedidimspinner.setOnItemSelectedListener(this);

        Spinner spinner = findViewById(R.id.peopleSpinner);
        List<String> people = new ArrayList<String>();
        people.add("אמא");
        people.add("אבא");
        people.add("אח/אחות");
        people.add("אחר");
        ArrayAdapter<String> eventAdapter5 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, people);
        eventAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(eventAdapter5);
        spinner.setSelection(0, false);
        spinner.setOnItemSelectedListener(this);


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    private void setThePhoneCallIntent() {

        Intent phoneCall = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "101", null));

        try {
            startActivity(phoneCall);
        } catch (Exception e) {

        }

    }



    private void setThePhoneCallPolice() {
        Intent phoneCall = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "100", null));

        finish();
        try {
            startActivity(phoneCall);
        } catch (Exception e) {

        }

    }


    public void setTheCallMacbi() {
        Intent phoneCall = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "102", null));

        finish();

        try {
            startActivity(phoneCall);
        } catch (Exception e) {

        }

    }


    public void setTheCallYedidim() {
        Intent phoneCall = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "053-3131310", null));

        finish();
        try {
            startActivity(phoneCall);
        } catch (Exception e) {

        }

        Intent textMessage = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:053-3131310"));
        textMessage.putExtra("sms_body", "מקרה חירום ");
        try {
            startActivity(textMessage);
        } catch (Exception e) {

        }
    }



    public void setCallPeople() {

        Intent phoneCall = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "", null));


        finish();
        try {
            startActivity(phoneCall);

        } catch (Exception e) {

        }
        Intent textMessage = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:0500000000"));
        textMessage.putExtra("sms_body", "מקרה חירום ");
        try {
            startActivity(textMessage);
        } catch (Exception e) {

        }

    }
    public void logout() {
        sp = getSharedPreferences("myProject",MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        editor.apply();
        // Go back to first activity
        startActivity(new Intent(this, FirstActivity.class));
        finish();
    }


}

