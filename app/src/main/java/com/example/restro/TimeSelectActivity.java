package com.example.restro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class TimeSelectActivity extends AppCompatActivity {

    ImageView book,home,history;
    Button b,sl1,sl2,sl3,sl4,sl5;
    int cnf=0;
    String id,date,time,table,currentUserId,currentUserName;
    DatabaseReference databaseReference,userReference;
    double u_point,u_offer;

    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_select);
        try {
            sl1 = findViewById(R.id.slot35);
            sl2 = findViewById(R.id.slot57);
            sl3 = findViewById(R.id.slot79);
            sl4 = findViewById(R.id.slot911);
            sl5 = findViewById(R.id.slot111);
            t1 =findViewById(R.id.bktv);
            b = findViewById(R.id.btn);
            book = findViewById(R.id.leftNev);
            home = findViewById(R.id.centerNev);
            history = findViewById(R.id.rightNev);



            Intent i1s = getIntent();
            Bundle bundle = i1s.getExtras();

            currentUserId = (String)bundle.get("Next_id");
            currentUserName = (String)bundle.get("Next_name");
            date = (String)bundle.get("Booking_Date");
            table = (String)bundle.get("Booking_Table");
            u_point = (Double)bundle.get("Point");
            u_offer = (Double)bundle.get("Offer");

            t1.setText("Welcome "+currentUserName);


            databaseReference = FirebaseDatabase.getInstance().getReference("Booking");
            userReference = FirebaseDatabase.getInstance().getReference("User");



            sl1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    time = "3to5";
                }
            });
            sl2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    time = "5to7";
                }
            });
            sl3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    time = "7to9";
                }
            });
            sl4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    time = "9to11";
                }
            });
            sl5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    time = "11to1";
                }
            });

            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //date = e1.getText().toString().trim();
                    id = (date + time + table);


                    databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if (dataSnapshot.hasChild(id)) {
                                Toast.makeText(TimeSelectActivity.this, "Choose another table, This is already occupied..! "
                                        , Toast.LENGTH_LONG).show();
                                cnf=0;
                            } else {
                                Booking booking = new Booking(date,time,table,currentUserId,currentUserName);

                                databaseReference.child(id).setValue(booking);
                                Toast.makeText(TimeSelectActivity.this, "Your booking is confirmed :)",Toast.LENGTH_LONG).show();

                                u_point = u_point + 1.0;
                                u_offer = u_offer + 1.1;
                                userReference.child(currentUserId).child("point").setValue(u_point);
                                userReference.child(currentUserId).child("offer").setValue(u_offer);

                                String deatils = (currentUserName+" " +
                                        " your booking details :"+"\n"+"Date : "+date+"\n"+"Table : "+table+"\n"+"Time : "+time);
                                t1.setText(deatils);
                                cnf=1;
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });

                    //if(cnf==1) {

                   // }

                }
            });

        }catch (Exception e)
        {
            Toast.makeText(this,"error",Toast.LENGTH_LONG).show();
        }


        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(TimeSelectActivity.this,HomeActivity.class);
                startActivity(i2);
            }
        });

        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3 = new Intent(TimeSelectActivity.this,ShowBookingActivity.class);
                startActivity(i3);
            }
        });
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(TimeSelectActivity.this,DateSelelctActivity.class);
                startActivity(i1);
            }
        });
    }
}
