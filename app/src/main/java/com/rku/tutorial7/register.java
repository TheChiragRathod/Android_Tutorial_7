package com.rku.tutorial7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class register extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    RadioGroup radioGroup;
    RadioButton radioButton;
    EditText editTextFname;
    EditText editTextLname;
    EditText editTextemail;
    EditText editTextpassword;
    EditText editTextHidden;
    Switch aSwitch;
    Spinner spyCity;
    CheckBox checkBox;


    String Gender;
    String FirstName;
    String LastName;
    String email;
    String password;
    String Branch;
    String City;
    String Status;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        this.setTitle("Registration");



        //Initialising Code Start here....................................
        editTextFname=findViewById(R.id.edttxtFname);
        editTextLname=findViewById(R.id.edttxtLname);
        editTextemail=findViewById(R.id.edttxtemail);
        editTextpassword=findViewById(R.id.edttxtpassword);
        aSwitch=findViewById(R.id.branchSwitch);
        radioGroup =findViewById(R.id.rdbGrpGender);

        spyCity=findViewById(R.id.spinnerCity);
        // //Initialising Code Finished here....................................




        //Spinner City Code Start here.................
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.city,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spyCity.setAdapter(adapter);
        spyCity.setOnItemSelectedListener(this);
        //Spinner City Code Finished here.................





    }



    public void Register(View view)
    {

        int radioId=radioGroup.getCheckedRadioButtonId();
        radioButton= findViewById(radioId);
        FirstName=editTextFname.getText().toString();
        LastName=editTextLname.getText().toString();
        email=editTextemail.getText().toString();
        password=editTextpassword.getText().toString();


        if(!Validation(FirstName,LastName,email,password,City))
            return;



        checkBox=findViewById(R.id.chkBox);
        if(checkBox.isChecked())
            Status="Active";
        else
            Status="Inactive";

        Gender=radioButton.getText().toString();

        if(aSwitch.isChecked())
            Branch="CE";
        else
            Branch="IT";






    }


    public boolean Validation(String FirstName,String LastName,String email,String password,String City)
    {
        boolean re=true;


        if(City.equals("Select City"))
        {
            ((TextView)spyCity.getSelectedView()).setError("Please Select Any City!");
            re=false;
        }
        if(password.isEmpty())
        {
            editTextpassword.requestFocus();
            editTextpassword.setError("Please Enter Password!");
            re=false;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            editTextemail.requestFocus();
            editTextemail.setError("Please Enter Valid Email!");
            re=false;
        }
        if(email.isEmpty())
        {
            editTextemail.requestFocus();
            editTextemail.setError("Please Enter Email!");
            re=false;
        }

        if(LastName.isEmpty())
        {
            editTextLname.requestFocus();
            editTextLname.setError("Please Enter Last Name!");
            re=false;
        }
        if(FirstName.isEmpty())
        {
            editTextFname.requestFocus();
            editTextFname.setError("Please Enter First Name!");
            re=false;
        }



        return re;
    }










    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        City=adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}