package com.example.myproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends  RecyclerView.Adapter<Adapter.ViewHolder>{


    private ArrayList<User> user= new ArrayList<>();


    public Adapter(ArrayList<User> users){
        this.user=users;
    }





    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user,parent,false);

        return new Adapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.id.setText(user.get(position).getId());
        holder.name.setText(user.get(position).getName());
        holder.firstName.setText(user.get(position).getFirstName());
        holder.data.setText(user.get(position).getData());
        holder.helath.setText(user.get(position).getHelath());
        holder.gander.setText(user.get(position).getGender());
        holder.phoneNumber.setText(user.get(position).getPhoneNumber());
    }

    @Override
    public int getItemCount() {
        return user.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView id;
        public TextView name;
        public TextView firstName;
        public TextView data;
        public TextView helath;
        public TextView gander;
        public TextView phoneNumber;
        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            id=itemView.findViewById(R.id.user_id);
            name=itemView.findViewById(R.id.user_name);
            firstName=itemView.findViewById(R.id.user_first);
            data=itemView.findViewById(R.id.user_data);
            helath=itemView.findViewById(R.id.user_health);
            gander=itemView.findViewById(R.id.user_gander);
            phoneNumber=itemView.findViewById(R.id.user_phone);
        }
    }
}
