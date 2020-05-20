package com.example.myproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class ShowFireBaseData extends AppCompatActivity {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    ArrayList<User> userArray = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_fire_base_data);
        final EditText  PhoneNumber=findViewById(R.id.PhoneNumber);
        SharedPreferences sp = getSharedPreferences("myProject", MODE_PRIVATE);
        final String phoneNumber = sp.getString("phone_number", null);

        db.collection(Shared_perference.nameOfCollection).document(phoneNumber).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {

            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {

                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();

                    if (document.exists()) {
                        Log.d("", "DocumentSnapshot data: " + document.getData());
User user=document.toObject(User.class);

                        loadRecyclerView(userArray);
                    } else {
                        Log.d("", "No such document");
                    }
                } else {
                    Log.d("", "get failed with ", task.getException());
                }
            }
        });
    }

    private void loadRecyclerView(ArrayList<User> arrayList) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        layoutManager.setSmoothScrollbarEnabled(true);
        RecyclerView recyclerView = findViewById(R.id.data_user);
        recyclerView.setLayoutManager(layoutManager);
         Adapter adapter = new Adapter(arrayList);
        recyclerView.setAdapter(adapter);
    }
}
