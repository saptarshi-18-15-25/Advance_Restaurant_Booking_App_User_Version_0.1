package com.example.restro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegistrationActivity extends AppCompatActivity {

    EditText uName,uPh,uPswd;
    Button uReg;
    DatabaseReference databaseReference;
    double point=0.0,offer=0.0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        uName = findViewById(R.id.name);
        uPh = findViewById(R.id.ph);
        uPswd = findViewById(R.id.pswd);
        uReg = findViewById(R.id.reg);

        databaseReference = FirebaseDatabase.getInstance().getReference("User");

        uReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = uName.getText().toString().trim();
                String userPhone = uPh.getText().toString().trim();
                String userPswd = uPswd.getText().toString().trim();

                User user = new User(userName,userPhone,userPswd,point,offer);
                databaseReference.child(userPhone).setValue(user);
                Toast.makeText(RegistrationActivity.this, "Registration Successful", Toast.LENGTH_LONG).show();
                Intent i = new Intent(RegistrationActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });


    }
}
