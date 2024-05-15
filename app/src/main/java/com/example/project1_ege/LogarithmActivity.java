package com.example.project1_ege;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LogarithmActivity extends AppCompatActivity {

    private EditText numberInput;
    private EditText baseInput;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logarithm_activity);

        numberInput = findViewById(R.id.numberInput);
        baseInput = findViewById(R.id.baseInput);
        resultText = findViewById(R.id.resultText);
        findViewById(R.id.calculateButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateLogarithm();
            }
        });
    }

    private double logarithm(double number, double base) {
        return Math.log(number) / Math.log(base);
    }

    @SuppressLint("DefaultLocale")
    private void calculateLogarithm() {
        // Calculate and print the logarithm on screen
        String input = numberInput.getText().toString();
        String input2 = baseInput.getText().toString();
        if (!input.isEmpty() && !input2.isEmpty()) {
            double number = Double.parseDouble(input);
            double base = Double.parseDouble(input2);
            double result = logarithm(number,base);
            resultText.setText(String.format("Result: %.3f", result));
        }
    }
}
