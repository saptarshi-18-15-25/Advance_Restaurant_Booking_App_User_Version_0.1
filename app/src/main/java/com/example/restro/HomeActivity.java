package com.example.restro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HomeActivity extends AppCompatActivity {

    ImageView book,home,history;
    String currentUserId,currentUserName;
    TextView points,offers,wlcm;
    //int p=0,o=0;
    double u_point,u_offer;
    double show_point,show_offer;
    DatabaseReference userReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        book = findViewById(R.id.leftNev);
        home = findViewById(R.id.centerNev);
        history = findViewById(R.id.rightNev);

        points = findViewById(R.id.point_text);
        offers = findViewById(R.id.ofr_text);

        wlcm = findViewById(R.id.wlcmName);

        userReference = FirebaseDatabase.getInstance().getReference().child("User");

        Intent i1s = getIntent();
        Bundle bundle = i1s.getExtras();

        currentUserId = (String)bundle.get("Pass_id");
        currentUserName = (String)bundle.get("Pass_name");
        u_point = (Double)bundle.get("Point");
        u_offer = (Double)bundle.get("Offer");


        userReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

               show_point = dataSnapshot.child(currentUserId).getValue(User.class).getPoint();
               show_offer = dataSnapshot.child(currentUserId).getValue(User.class).getOffer();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        String dft = "Hi "+currentUserName +" !";
        wlcm.setText(dft);

        String p = Double.toString(u_point);
        String o = Double.toString(u_offer);

        Toast.makeText(HomeActivity.this,u_point+" ,"+u_offer,Toast.LENGTH_LONG).show();

        String point_dft =  p+" Point";
        points.setText(point_dft);


        String ofr_dft = o+"% off";
        offers.setText(ofr_dft);

        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(HomeActivity.this,DateSelelctActivity.class);
                i1.putExtra("Pass_id",currentUserId);
                i1.putExtra("Pass_name",currentUserName);
                i1.putExtra("Point",u_offer);
                i1.putExtra("Offer",u_offer);
                startActivity(i1);

            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(HomeActivity.this,HomeActivity.class);
                startActivity(i2);
            }
        });

        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3 = new Intent(HomeActivity.this,ShowBookingActivity.class);
                startActivity(i3);
            }
        });
    }
}
