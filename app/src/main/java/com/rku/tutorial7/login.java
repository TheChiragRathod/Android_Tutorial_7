package com.rku.tutorial7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class login extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        this.setTitle("Login");
    }




    public void openRegister(View view)
    {
        Intent intent =new Intent(login.this,register.class);
        startActivity(intent);
        finish();
    }
}