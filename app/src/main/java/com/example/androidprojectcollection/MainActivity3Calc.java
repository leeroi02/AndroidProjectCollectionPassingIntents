package com.example.androidprojectcollection;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity3Calc extends AppCompatActivity {
    ArrayList<Button> numButtons = new ArrayList<>();
    ArrayList<Button> opButtons = new ArrayList<>();
    Calculator calculator = new Calculator();
    boolean isDecimal = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        calculator();
    }

    public void calculator() {

        Button ACbtn = (Button) findViewById(R.id.btnAC);
        Button Eqbtn = (Button) findViewById(R.id.btnEquals);
        Button Decbtn = (Button) findViewById(R.id.btnDec);
        TextView stringRes = (TextView) findViewById(R.id.Result);
        TextView stringRev = (TextView) findViewById(R.id.Rev);
        numButtons.add((Button) findViewById(R.id.btnnum0));
        numButtons.add((Button) findViewById(R.id.btnnum1));
        numButtons.add((Button) findViewById(R.id.btnnum2));
        numButtons.add((Button) findViewById(R.id.btnnum3));
        numButtons.add((Button) findViewById(R.id.btnnum4));
        numButtons.add((Button) findViewById(R.id.btnnum5));
        numButtons.add((Button) findViewById(R.id.btnnum6));
        numButtons.add((Button) findViewById(R.id.btnnum7));
        numButtons.add((Button) findViewById(R.id.btnnum8));
        numButtons.add((Button) findViewById(R.id.btnnum9));
        opButtons.add((Button) findViewById(R.id.btnAdd));
        opButtons.add((Button) findViewById(R.id.btnSub));
        opButtons.add((Button) findViewById(R.id.btnMult));
        opButtons.add((Button) findViewById(R.id.btnDiv));


        for (Button button : numButtons) {
            button.setOnClickListener(v -> {
                String buttonText = button.getText().toString();
                stringRev.append(buttonText);
                updateResult( false);
            });
        }

        for (Button button : opButtons) {
            button.setOnClickListener(v -> {
                isDecimal = false;
                String buttonText = button.getText().toString();
                String expression = stringRev.getText().toString();

                if (!expression.isEmpty() && isOperator(expression.charAt(expression.length() - 1))) {
                    stringRev.setText(expression.substring(0, expression.length() - 1) + buttonText);
                } else {
                    stringRev.append(buttonText);
                }
            });
        }
        Eqbtn.setOnClickListener(v -> {
            updateResult(true);
            String expression = stringRev.getText().toString();
            isDecimal = false;

            try {
                float result = calculator.calculate(expression, true);
                stringRes.setText(formatResult(result));
            } catch (Exception e) {
                stringRes.setText(e.getMessage());
            }
        });

        ACbtn.setOnClickListener(v -> {
            isDecimal = false;
            updateResult(false);
            stringRev.setText("");
            stringRes.setText("0");
        });

        Decbtn.setOnClickListener(v -> {
            updateResult(false);
            String expression = stringRev.getText().toString();
            if (!expression.isEmpty() && expression.charAt(expression.length() - 1) == '.') {
                stringRev.setText(expression.substring(0, expression.length() - 1));
                isDecimal = false;
            } else if (!isDecimal) {
                stringRev.append(".");
                isDecimal = true;
            }
        });
    }

    private void updateResult(boolean performCalculation) {
        TextView stringRes = findViewById(R.id.Result);
        TextView stringRev = findViewById(R.id.Rev);
        boolean pemdas = false;

        if (performCalculation) {
            pemdas = true;
        }

        try {
            float result = calculator.calculate(stringRev.getText().toString(), pemdas);
            stringRes.setText(formatResult(result));
        } catch (Exception e) {
            stringRes.setText(e.getMessage());
        }
    }






    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '%';
    }

    private String formatResult(float result) {
        return result == (int) result ? String.valueOf((int) result) : String.valueOf(result);
    }
}