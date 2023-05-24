package com.tejas.crackscreenprank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;


public class CrackScreenActivity extends AppCompatActivity implements SensorEventListener {
    LinearLayout secondaryLL, mainLL;
    TextView textInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crack_screen);

        // Finding ids
        secondaryLL = findViewById(R.id.secondaryLL);
        mainLL = findViewById(R.id.mainLL);
        textInfo = findViewById(R.id.textInfo);
        mainLL.setLongClickable(true);

        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        if (sensorManager!=null) {
            Sensor accSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            if (accSensor!=null){
                sensorManager.registerListener(this, accSensor, SensorManager.SENSOR_DELAY_NORMAL);

            }
        }

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType()==Sensor.TYPE_ACCELEROMETER){
            float valuesX = sensorEvent.values[0];
            float valuesY = sensorEvent.values[1];
            float valuesZ = sensorEvent.values[2];

            double rootSquare = Math.sqrt(Math.pow(valuesX,2)+Math.pow(valuesY,2)+Math.pow(valuesZ,2));

            if(rootSquare<2.0){
                Intent intent = getIntent();
                int crack_screen_id = intent.getIntExtra("crack_screen_id", 1);

                MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.breaking_glass_sound);
                mediaPlayer.start();

                secondaryLL.setVisibility(View.GONE);

                if (crack_screen_id==1){
                    mainLL.setBackgroundResource(R.drawable.crack_screen1);
                } else if (crack_screen_id==2){
                    mainLL.setBackgroundResource(R.drawable.crack_screen2);
                } else if (crack_screen_id==3){
                    mainLL.setBackgroundResource(R.drawable.crack_screen3);
                } else{
                    mainLL.setBackgroundResource(R.drawable.crack_screen4);
                }

                getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
                getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE, WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);

            }

        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
    }
}