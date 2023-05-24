package com.tejas.crackscreenprank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView crack_screen1, crack_screen2, crack_screen3, crack_screen4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Finding ids
        crack_screen1 = findViewById(R.id.crack_screen1);
        crack_screen2 = findViewById(R.id.crack_screen2);
        crack_screen3 = findViewById(R.id.crack_screen3);
        crack_screen4 = findViewById(R.id.crack_screen4);

        // Click Listeners
        crack_screen1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crack_screen(1);
            }
        });

        crack_screen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crack_screen(2);
            }
        });

        crack_screen3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crack_screen(3);
            }
        });

        crack_screen4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crack_screen(4);
            }
        });

    }

    public void crack_screen(int crack_screen_id){
        Intent intent = new Intent(MainActivity.this, CrackScreenActivity.class);
        intent.putExtra("crack_screen_id", crack_screen_id);
        startActivity(intent);
    }

}