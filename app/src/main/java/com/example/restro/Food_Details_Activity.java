package com.example.restro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

public class Food_Details_Activity extends AppCompatActivity {

    TextView tvF,imgT;
    String stF,dishEd;
    StorageReference dRef;
    DatabaseReference databaseReference;
    Button dishBtn;
    ImageView iv;
    //EditText dishEd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food__details_);


        tvF = findViewById(R.id.tviewF);
        iv = findViewById(R.id.f_iv);
        imgT = findViewById(R.id.imgTxt);
       // dishBtn =  findViewById(R.id.dishShowBtn);
        //dishEd = findViewById(R.id.dishEditText);


        Intent i1s = getIntent();
        Bundle bundle = i1s.getExtras();

        dRef = FirebaseStorage.getInstance().getReference();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Dish");

        stF = (String)bundle.get("f_s");
        tvF.setText(stF);
        dishEd=stF.toLowerCase().trim();
        Toast.makeText(Food_Details_Activity.this,dishEd.toString(),Toast.LENGTH_LONG).show();
        //currentUserId = (String)bundle.get("Pass_id");
        //tvF.setText(stF);

       // FirebaseStorage storage = FirebaseStorage.getInstance();
       // StorageReference url = storage.getReferenceFromUrl("https://firebasestorage.googleapis.com/b/bucket/o/images%20aksrhi.jpg");
        //String url = "https://firebasestorage.googleapis.com/v0/b/restro-12bcf.appspot.com/o/"+stF+"?alt=media&token=b28ad460-6c05-4d14-ba68-4722f4b6819f";

        //Glide.with(getApplicationContext()).load(url).into(iv);

        //imgT.setText(url.toString());



        //dishBtn.setOnClickListener(new View.OnClickListener() {
         //   @Override
         //   public void onClick(View v) {



               /* int l = stF.length();
                int convert=0;
                for (int i = 0; i < l; i++) {
                    convert =  (convert*10)+ stF.charAt(i);
                    //System.out.print(convert);
                }
                final String dishInt = String.valueOf(convert);*/


                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {



                        String L_id = dishEd;

                        if(dataSnapshot.child(L_id).exists())
                        {

                            imgT.setText(dataSnapshot.child(L_id).getValue(Dish.class).getDish_description());
                            String url = dataSnapshot.child(L_id).getValue(Dish.class).getDish_name();
                           // Toast.makeText(Food_Details_Activity.this,"I'm ok with it",Toast.LENGTH_LONG).show();
                            Picasso.with(Food_Details_Activity.this).load(url).into(iv);
                           // Toast.makeText(Food_Details_Activity.this,url,Toast.LENGTH_LONG).show();
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


           // }
        //});






    }
}
