package com.example.myproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

public class Shared_perference extends AppCompatActivity {
    public static String nameOfCollection = "user";
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);

        Button button = findViewById(R.id.sent);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Shared_perference.this, ShowFireBaseData.class));

                EditText id = findViewById(R.id.id);
                EditText name = findViewById(R.id.Name);
                EditText firstName = findViewById(R.id.FirstName);
                EditText helath = findViewById(R.id.Health);
                EditText gender = findViewById(R.id.Gander);
                EditText data = findViewById(R.id.data);
                EditText phoneNumber = findViewById(R.id.PhoneNumber);
                User user = new User(id.getText().toString(), name.getText().toString(), firstName.getText().toString(), helath.getText().toString(), gender.getText().toString(), data.getText().toString(), phoneNumber.getText().toString());

                db.collection(nameOfCollection).document(phoneNumber.getText().toString()).set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(Shared_perference.this,"עודכן בהצלחה",Toast.LENGTH_SHORT).show();

                    }

                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("", "error writing document", e);
                    }
                });
            }
        });
    }
}
