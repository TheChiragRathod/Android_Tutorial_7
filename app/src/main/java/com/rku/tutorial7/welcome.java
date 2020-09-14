package com.rku.tutorial7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class welcome extends AppCompatActivity {
    TextView txtLoginDetail;
    DatabaseHelper db;
    String UserEmail;
    TextView txtViewFname;
    TextView txtViewLName;
    TextView txtViewEmail;
    TextView txtViewpassword;
    TextView txtViewGender;
    TextView txtViewBranch;
    TextView txtViewCity;
    TextView txtViewStatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        this.setTitle("Your Details");





        //Initializing Variables start here...

        txtViewFname=findViewById(R.id.txtFirstName);
        txtViewLName=findViewById(R.id.txtLastName);
        txtViewEmail=findViewById(R.id.txtemail);
        txtViewpassword=findViewById(R.id.txtPassword);
        txtViewGender=findViewById(R.id.txtGender);
        txtViewBranch=findViewById(R.id.txtBranch);
        txtViewCity=findViewById(R.id.txtCity);
        txtViewStatus=findViewById(R.id.txtStatus);

        //Initializing Variables finish here...

        SharedPreferences SP = getSharedPreferences("Login_Info",MODE_PRIVATE);
        UserEmail = SP.getString("Username","");

        txtLoginDetail=findViewById(R.id.LoginDetail);
        txtLoginDetail.setText(UserEmail);


        SetData();

    }

    public void SetData()
    {
        DatabaseHelper db=new DatabaseHelper(this);


        Cursor res=db.getData(UserEmail);
        res.moveToNext();

        txtViewFname.setText("First Name : "+res.getString(1));
        txtViewLName.setText("Last Name : "+res.getString(2));
        txtViewEmail.setText("Email : "+res.getString(3));
        txtViewpassword.setText("Password : "+res.getString(4));
        txtViewGender.setText("Gender : "+res.getString(5));
        txtViewBranch.setText("Branch : "+res.getString(6));
        txtViewCity.setText("City : "+res.getString(7));
        txtViewStatus.setText("Status : "+res.getString(8));

    }




    //Logout Code In Custome menu start here.....

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.custome_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        switch(item.getItemId())
        {

            case R.id.menuLogout:
                logout();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
    //Logout Code In Custome menu finished here.....

    public void logout()
    {
        SharedPreferences SP=getSharedPreferences("Login_Info",MODE_PRIVATE);
        SharedPreferences.Editor editor = SP.edit();
        editor.remove("Username");
        editor.apply();

        Intent intent=new Intent(this, login.class);
        startActivity(intent);
        finish();
    }

}