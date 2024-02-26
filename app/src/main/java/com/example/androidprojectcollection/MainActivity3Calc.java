package com.example.androidprojectcollection;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3Calc extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Button btn1, btn2, btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0;
        Button AC, btnEq, btnAd, btnSub, btnDiv,btnMult, btnPoi, btnPerc, btnNeg;
        TextView display;

        display = (TextView) findViewById(R.id.textView);
        btnAd = (Button) findViewById(R.id.button83);
        btnAd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


            }
        });

        btnSub = (Button) findViewById(R.id.button80);
        btnSub.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


            }
        });


        btnMult = (Button) findViewById(R.id.button92);
        btnMult.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


            }
        });


        btnDiv = (Button) findViewById(R.id.button77);
        btnDiv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


            }
        });

        btn1 = (Button) findViewById(R.id.button89);
        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                display.setText("1");
            }
        });

    }
}
