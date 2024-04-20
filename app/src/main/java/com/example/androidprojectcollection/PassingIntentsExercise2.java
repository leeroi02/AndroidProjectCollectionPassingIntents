package com.example.androidprojectcollection;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class PassingIntentsExercise2 extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.passing_intents_exercise2);

        Intent intent = getIntent();
        LinearLayout mainContainer = findViewById(R.id.studform);
        Button returnBtn = findViewById(R.id.btnReturn);

        ArrayList<String> values = intent.getStringArrayListExtra("Values");
        assert values != null;

        for (int i = 0, j = 1; j < 12; j++) {
            if (j == 3) {
                ((TextView) ((LinearLayout) mainContainer.getChildAt(j)).getChildAt(1))
                        .setText(intent.getStringExtra("Gender"));
                continue;
            }
            ((TextView) ((LinearLayout) mainContainer.getChildAt(j)).getChildAt(1))
                    .setText(values.get(i++));
        }

        returnBtn.setOnClickListener(view -> startActivity(
                new Intent(this, PassingIntentsExercise.class)));
    }

    }

