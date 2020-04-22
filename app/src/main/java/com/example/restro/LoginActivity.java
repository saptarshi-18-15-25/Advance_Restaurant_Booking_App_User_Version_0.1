package com.example.restro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {

    EditText Logid,LogPswd;
    Button Logbtn;
    DatabaseReference databaseReference;
    TextView newUser;
    double u_point,u_offer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Logid = findViewById(R.id.lgph);
        LogPswd = findViewById(R.id.lgpswd);
        Logbtn = findViewById(R.id.btnlog);
        newUser = findViewById(R.id.newU);

        databaseReference = FirebaseDatabase.getInstance().getReference("User");


        Logbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        String L_id = Logid.getText().toString().trim();
                        String L_Pswd = LogPswd.getText().toString().trim();


                        if(dataSnapshot.child(L_id).exists())
                        {
                            if(dataSnapshot.child(L_id).getValue(User.class).getPassword().equals(L_Pswd))
                            {
                                String L_name = dataSnapshot.child(L_id).getValue(User.class).getName();
                                u_point = dataSnapshot.child(L_id).getValue(User.class).getPoint();
                                u_offer = dataSnapshot.child(L_id).getValue(User.class).getOffer();

                                Toast.makeText(LoginActivity.this,"Login successful !",Toast.LENGTH_LONG).show();
                                Intent i1 = new Intent(LoginActivity.this,HomeActivity.class);
                                i1.putExtra("Pass_id",L_id);
                                i1.putExtra("Pass_name",L_name);
                                i1.putExtra("Point",u_offer);
                                i1.putExtra("Offer",u_offer);
                                startActivity(i1);
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

        newUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this,RegistrationActivity.class);
                startActivity(i);
            }
        });

    }
}
