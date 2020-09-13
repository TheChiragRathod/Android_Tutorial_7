package com.rku.tutorial7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class login extends AppCompatActivity
{
    EditText editTextUser;
    EditText editTextPass;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        this.setTitle("Login");
        editTextUser=findViewById(R.id.edtUsername);
        editTextPass=findViewById(R.id.edtPassword);

    }


    public void LoginHere(View view)
    {
        if(!LoginValidation())
            return;
    }

    public boolean LoginValidation()
    {
        boolean result=true;

        if(editTextPass.getText().toString().isEmpty()) {
            result = false;
            editTextPass.requestFocus();
            editTextPass.setError("Please Enter Password");
        }
        if(editTextUser.getText().toString().isEmpty())
        {
            result=false;
            editTextUser.requestFocus();
            editTextUser.setError("Please Enter Username");
        }

        return result;

    }




    public void openRegister(View view)
    {
        Intent intent =new Intent(login.this,register.class);
        startActivity(intent);
        finish();
    }
}