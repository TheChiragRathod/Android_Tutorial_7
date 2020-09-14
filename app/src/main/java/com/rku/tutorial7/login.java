package com.rku.tutorial7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity
{
    EditText editTextUser;
    EditText editTextPass;
    DatabaseHelper db;

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

        String Email=editTextUser.getText().toString();

        db=new DatabaseHelper(this);

        Cursor res= db.validateUser(Email);
        if(res.getCount()==1) {
            Intent intent=new Intent(login.this,welcome.class);
            intent.putExtra("Email",Email);
            startActivity(intent);
            finish();
        }
        else
            Toast.makeText(this, "No Record Found", Toast.LENGTH_SHORT).show();
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