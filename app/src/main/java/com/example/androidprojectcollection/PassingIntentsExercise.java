package com.example.androidprojectcollection;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class PassingIntentsExercise extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.passing_intents_exercise);

        Button submitBtn = findViewById(R.id.btnRegSubmit);
        Button clearBtn = findViewById(R.id.btnClear);
        RadioGroup genders = findViewById(R.id.rgGender);
        LinearLayout mainContainer = findViewById(R.id.regForm);

        ArrayList<EditText> fields = new ArrayList<>(Arrays.asList(
                findViewById(R.id.tvFirst),
                findViewById(R.id.tvLast),
                findViewById(R.id.tvbday),
                findViewById(R.id.tvemail),
                findViewById(R.id.tvphone),
                findViewById(R.id.tvReligion),
                findViewById(R.id.tvNationality),
                findViewById(R.id.tvGuradian),
                findViewById(R.id.tvGnum),
                findViewById(R.id.tvRel)
        ));

        clearBtn.setOnClickListener(view -> {
            genders.clearCheck();
            for (EditText e : fields)
                e.setText("");
        });

        submitBtn.setOnClickListener(view -> {
            Intent intent = new Intent(this, PassingIntentsExercise2.class);
            int checkedId = genders.getCheckedRadioButtonId();
            String gender;
            if (checkedId == R.id.rMale) {
                gender = "Male";
            } else if (checkedId == R.id.rFemale) {
                gender = "Female";
            } else if (checkedId == R.id.rOthers) {
                gender = "Others";
            } else {
                gender = "N/A";
            }
            intent.putExtra("Gender", gender);

            ArrayList<String> values = new ArrayList<>();
            for (EditText e : fields) {
                String text = String.valueOf(e.getText());
                if (text.isEmpty()) {
                    values.add("N/A");
                } else {
                    values.add(text);
                }
            }
            intent.putExtra("Values", values);
            startActivity(intent);
        });
    }
}
