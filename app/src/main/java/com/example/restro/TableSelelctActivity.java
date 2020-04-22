package com.example.restro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class TableSelelctActivity extends AppCompatActivity {

    ImageView ts01,ts02,ts03,ts04,ss01,ss02,ss03,ss04,es01;
    Button nextAtable;
    String table,currentUserId,currentUserName,date;
    double u_point,u_offer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_selelct);
        ts01 = findViewById(R.id.ts1);
        ts02 = findViewById(R.id.ts2);
        ts03 = findViewById(R.id.ts3);
        ts04 = findViewById(R.id.ts4);

        ss01 = findViewById(R.id.ss1);
        ss02 = findViewById(R.id.ss2);
        ss03 = findViewById(R.id.ss3);
        ss04 = findViewById(R.id.ss4);

        es01 = findViewById(R.id.es1);

        nextAtable = findViewById(R.id.tablenext);


        Intent tableintent = getIntent();
        Bundle tablebundle = tableintent.getExtras();

        currentUserId = (String) tablebundle.get("Pass_Id");
        currentUserName = (String)tablebundle.get("Pass_Name");
        date = (String)tablebundle.get("Booking_Date");
        u_point = (Double)tablebundle.get("Point");
        u_offer = (Double)tablebundle.get("Offer");




        //-------------------------------------------------------------------------------------------
        ts01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                table ="ts01";
                Toast.makeText(TableSelelctActivity.this,currentUserName+",your table no.is: "+table,Toast.LENGTH_LONG).show();
            }
        });
        ts02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                table ="ts02";
                Toast.makeText(TableSelelctActivity.this,currentUserName+",your table no.is: "+table,Toast.LENGTH_LONG).show();
            }
        });
        ts03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                table ="ts03";
                Toast.makeText(TableSelelctActivity.this,currentUserName+",your table no.is: "+table,Toast.LENGTH_LONG).show();
            }
        });
        ts04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                table ="ts04";
                Toast.makeText(TableSelelctActivity.this,currentUserName+",your table no.is: "+table,Toast.LENGTH_LONG).show();
            }
        });
        //----------------------------------------------------------------------------------------

        ss01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                table ="ss01";
                Toast.makeText(TableSelelctActivity.this,currentUserName+",your table no.is: "+table,Toast.LENGTH_LONG).show();
            }
        });
        ss02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                table ="ss02";
                Toast.makeText(TableSelelctActivity.this,currentUserName+",your table no.is: "+table,Toast.LENGTH_LONG).show();
            }
        });
        ss03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                table ="ss03";
                Toast.makeText(TableSelelctActivity.this,currentUserName+",your table no.is: "+table,Toast.LENGTH_LONG).show();
            }
        });
        ss04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                table ="ss04";
                Toast.makeText(TableSelelctActivity.this,currentUserName+",your table no.is: "+table,Toast.LENGTH_LONG).show();
            }
        });
        //---------------------------------------------------------------------------------------
        es01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                table ="es01";
                Toast.makeText(TableSelelctActivity.this,currentUserName+",your table no.is: "+table,Toast.LENGTH_LONG).show();
            }
        });
        //---------------------------------------------------------------------------------------

        nextAtable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tablenextintent = new Intent(TableSelelctActivity.this,TimeSelectActivity.class);
                tablenextintent.putExtra("Next_id",currentUserId);
                tablenextintent.putExtra("Next_name",currentUserName);
                tablenextintent.putExtra("Booking_Date",date);
                tablenextintent.putExtra("Booking_Table",table);
                tablenextintent.putExtra("Point",u_offer);
                tablenextintent.putExtra("Offer",u_offer);
                startActivity(tablenextintent);

            }
        });






    }
}
