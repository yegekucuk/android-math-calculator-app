package com.example.project1_ege;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SquareRootActivity extends Activity {

    private EditText numberInput;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.squareroot_activity);

        numberInput = findViewById(R.id.numberInput);
        resultText = findViewById(R.id.resultText);
        findViewById(R.id.calculateButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateSqrt();
            }
        });
    }

    @SuppressLint("DefaultLocale")
    private void calculateSqrt() {
        String input = numberInput.getText().toString();
        if (!input.isEmpty()) {
            double number = Double.parseDouble(input);
            double result = Math.sqrt(number);
            resultText.setText(String.format("Result: %.3f", result));
        }
    }
}
