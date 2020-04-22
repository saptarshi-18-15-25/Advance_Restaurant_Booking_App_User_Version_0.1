package com.example.restro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.text.TextBlock;
import com.google.android.gms.vision.text.TextRecognizer;

import java.io.IOException;

public class ShowBookingActivity extends AppCompatActivity {

    SurfaceView cameraView;
    TextView textView;
    Button btn;
    String s;
    CameraSource cameraSource;
    final int RequestCameraPermissionID = 1001;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_booking);
        cameraView = findViewById(R.id.sView);
        textView = findViewById(R.id.tView);
        btn = findViewById(R.id.btn);

        TextRecognizer textRecognizer = new TextRecognizer.Builder(getApplicationContext()).build();


        cameraSource = new CameraSource.Builder(getApplicationContext(),textRecognizer)
                .setFacing(CameraSource.CAMERA_FACING_BACK)
                .setRequestedPreviewSize(1280,1024)
                .setRequestedFps(2.0f)
                .setAutoFocusEnabled(true)
                .build();
        cameraView.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                try{

                    // if(ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED)
                    //{

                    ActivityCompat.requestPermissions(ShowBookingActivity.this, new String[]{Manifest.permission.CAMERA},RequestCameraPermissionID);
                    // }
                    cameraSource.start(cameraView.getHolder());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {

                cameraSource.stop();
            }
        });

        textRecognizer.setProcessor(new Detector.Processor<TextBlock>() {
            @Override
            public void release() {

            }

            @Override
            public void receiveDetections(Detector.Detections<TextBlock> detections) {

                final SparseArray<TextBlock> items = detections.getDetectedItems();
                if(items.size()!=0)
                {
                    textView.post(new Runnable() {
                        @Override
                        public void run() {
                            StringBuilder stringBuilder = new StringBuilder();
                            for(int i=0; i<items.size(); i++)
                            {
                                TextBlock item = items.valueAt(i);
                                stringBuilder.append(item.getValue());
                                stringBuilder.append("\n");
                            }
                            textView.setText(stringBuilder.toString());
                            s = stringBuilder.toString();

                        }
                    });
                }

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                      Intent i = new Intent(ShowBookingActivity.this,Food_Details_Activity.class);
                      i.putExtra("f_s",s);
                      startActivity(i);
            }
        });

    }
}
