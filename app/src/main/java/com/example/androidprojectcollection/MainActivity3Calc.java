package com.example.androidprojectcollection;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;
import java.util.Stack;

public class MainActivity3Calc extends AppCompatActivity {

    Button btn1,
            btn2,
            btn3,
            btn4,
            btn5,
            btn6,
            btn7,
            btn8,
            btn9,
            btn0,
            AC,
            btnEq,
            btnAd,
            btnSub,
            btnDiv,
            btnMult,
            btnPoi,
            btnPerc,
            btnNeg;
    TextView display,
            eqView;
    Boolean Nums = false;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Calculator c = new Calculator();
        btn0 = (Button) findViewById(R.id.btnnum0);
        btn1 = (Button) findViewById(R.id.btnnum1);
        btn2 = (Button) findViewById(R.id.btnnum2);
        btn3 = (Button) findViewById(R.id.btnnum3);
        btn4 = (Button) findViewById(R.id.btnnum4);
        btn5 = (Button) findViewById(R.id.btnnum5);
        btn6 = (Button) findViewById(R.id.btnnum6);
        btn7 = (Button) findViewById(R.id.btnnum7);
        btn8 = (Button) findViewById(R.id.btnnum8);
        btn9 = (Button) findViewById(R.id.btnnum9);

        btnPoi = (Button) findViewById(R.id.button86);
        AC = (Button) findViewById(R.id.button93);
        btnAd = (Button) findViewById(R.id.button83);
        btnSub = (Button) findViewById(R.id.button80);
        btnMult = (Button) findViewById(R.id.button92);
        btnDiv = (Button) findViewById(R.id.button77);
        btnEq = (Button) findViewById(R.id.button87);

        eqView = (TextView) findViewById(R.id.equationview);
        display= (TextView) findViewById(R.id.textView);

        MainActivity3Calc m = this;

        /*Buttons */
        btn0.setOnClickListener(new View.OnClickListener()   {
            @Override
            public void onClick(View view) {
                if (!display.getText().toString().equals("0")) {
                    display.append("0");
                }
                Nums = true;
                c.updateResult(m);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eqView.append("1");

                Nums = true;
                c.updateResult(m);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.append("2");

                Nums = true;
                c.updateResult(m);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.append("3");

                Nums = true;
                c.updateResult(m);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.append("4");

                Nums = true;
                c.updateResult(m);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.append("5");

                Nums = true;
                c.updateResult(m);
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.append("6");

                Nums = true;
                c.updateResult(m);
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.append("7");

                Nums = true;
                c.updateResult(m);
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.append("8");

                Nums = true;
                c.updateResult(m);
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.append("9");

                Nums = true;
                c.updateResult(m);
            }
        });

        /* Operations*/

        AC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.setText("");
            }
        });

        btnAd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder tmp = new StringBuilder();
                tmp.append(eqView.getText().toString());
                int ctr = tmp.length() - 1;
                if (ctr >= 0 && (tmp.charAt(ctr) == '-' || tmp.charAt(ctr) == 'x' || tmp.charAt(ctr) == '/')) {
                    eqView.setText(tmp.substring(0, ctr) + "+");
                } else if (!Nums) {
                    eqView.append("+");

                    Nums = true;
                }


            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder tmp = new StringBuilder();
                tmp.append(eqView.getText().toString());
                int ctr = tmp.length() - 1;
                if (tmp.charAt(ctr) == '+' || tmp.charAt(ctr) == 'x' || tmp.charAt(ctr) == '/') {
                    eqView.setText(tmp.substring(0, ctr) + "-");
                } else if (Nums) {
                    eqView.append("-");

                    Nums = false;
                }


            }
        });

        btnMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder tmp = new StringBuilder();
                tmp.append(eqView.getText().toString());
                if (tmp.charAt(tmp.length() - 1) == '+' || tmp.charAt(tmp.length() - 1) == '-' || tmp.charAt(tmp.length() - 1) == '/') {
                    eqView.setText(tmp.substring(0, (tmp.length() - 1)) + "x");
                } else if (Nums) {
                    eqView.append("x");

                    Nums = false;
                }


            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder tmp = new StringBuilder();
                tmp.append(eqView.getText().toString());
                if (tmp.charAt(tmp.length() - 1) == '+' || tmp.charAt(tmp.length() - 1) == '-' || tmp.charAt(tmp.length() - 1) == 'x') {
                    eqView.setText(tmp.substring(0, (tmp.length() - 1)) + "/");
                } else if (Nums) {
                    eqView.append("/");

                    Nums = false;
                }


            }
        });


        btnPoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder tmp = new StringBuilder(eqView.getText().toString());
                if (Nums && tmp.charAt(tmp.length() - 1) != '.') {
                    eqView.append(".");
                } else if (!Nums) {
                    eqView.append("0.");
                    Nums = true;
                }

            }
        });


        btnEq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String expression = eqView.getText().toString();
                try {
                    double result = c.ActualResult(expression);
                    String formattedResult = c.formatResult(result);
                    System.out.println(formattedResult);
                    display.setText("");
                    display.setText(formattedResult);

                } catch (Exception e) {
                    display.setText("Error");
                }
            }
        });
    }
}






