package com.rku.tutorial7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class welcome extends AppCompatActivity {
    TextView txtLoginDetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        this.setTitle("Your Details");
        Intent intent=getIntent();
        String UserEmail=intent.getStringExtra("Email");

        txtLoginDetail=findViewById(R.id.LoginDetail);
        txtLoginDetail.setText(UserEmail);


    }
}