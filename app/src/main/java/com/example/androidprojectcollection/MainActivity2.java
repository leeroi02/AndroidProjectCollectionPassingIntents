package com.example.androidprojectcollection;

import static android.graphics.Color.BLACK;
import static android.graphics.Color.WHITE;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
Button buTT12 , buTTTo, buTTLay, buTTCol, buTTBG;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ConstraintLayout BG = findViewById(R.id.background2);

        buTT12 = (Button) findViewById(R.id.returnID);
        buTT12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent1);

            }
        });


        buTTTo = (Button) findViewById(R.id.buttonToast);
        buTTTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity2.this, "Ang nagbasa buotan", Toast.LENGTH_SHORT).show();

            }
        });

        buTTLay = (Button) findViewById(R.id.buttonLayout);
        buTTLay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buTTLay.setVisibility(View.INVISIBLE);
            }
        });

        buTTCol = (Button) findViewById(R.id.buttonColor);
        buTTCol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buTTCol.setBackgroundColor(Color.BLUE);
                buTTCol.setTextColor(WHITE);
            }
        });


        buTTBG = (Button) findViewById(R.id.buttonCol);
        buTTBG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               BG.setBackgroundResource(R.color.pink);

            }
        });

    }
}