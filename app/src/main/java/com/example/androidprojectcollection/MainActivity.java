package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button buTT1, buTTLay, buTTCalc;
    @SuppressLint("MissingInflatedId")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buTTLay = (Button) findViewById(R.id.buttonL);
        buTTLay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this, LayoutExercise.class);
                startActivity(intent1);

            }
        });

        buTT1 = (Button) findViewById(R.id.button2);
        buTT1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent1);

            }
        });

        buTTCalc = (Button) findViewById(R.id.button3);
        buTTCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this, MainActivity3Calc.class);
                startActivity(intent1);

            }
        });


    }

}