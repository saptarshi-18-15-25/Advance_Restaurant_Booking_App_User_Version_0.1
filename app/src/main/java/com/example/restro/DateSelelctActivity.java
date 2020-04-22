package com.example.restro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

public class DateSelelctActivity extends AppCompatActivity {

    TextView ShowDate;
    CalendarView calendarView;
    Button nextAdate;
    String dt,currentUserId,currentUserName;
    double u_point,u_offer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_selelct);
        ShowDate = findViewById(R.id.tvDate);
        calendarView = findViewById(R.id.calender);
        nextAdate = findViewById(R.id.datenext);

        Intent i1s = getIntent();
        Bundle bundle = i1s.getExtras();

        currentUserId = (String)bundle.get("Pass_id");
        currentUserName = (String)bundle.get("Pass_name");
        u_point = (Double)bundle.get("Point");
        u_offer = (Double)bundle.get("Offer");


        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                dt = i2+"-"+(i1+1)+"-"+i;
                ShowDate.setText(dt);
            }
        });
        nextAdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DateSelelctActivity.this,TableSelelctActivity.class);
                intent.putExtra("Pass_Id",currentUserId);
                intent.putExtra("Pass_Name",currentUserName);
                intent.putExtra("Booking_Date",dt);
                intent.putExtra("Point",u_offer);
                intent.putExtra("Offer",u_offer);

                startActivity(intent);

            }
        });
    }
}
