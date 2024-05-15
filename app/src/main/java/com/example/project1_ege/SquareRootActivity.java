package com.example.project1_ege;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SquareRootActivity extends AppCompatActivity {

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
                calculateLogarithm();
            }
        });
    }

    @SuppressLint("DefaultLocale")
    private void calculateLogarithm() {
        // Calculate and print the logarithm on screen
        String input = numberInput.getText().toString();
        if (!input.isEmpty()) {
            double number = Double.parseDouble(input);
            double result = Math.sqrt(number);
            resultText.setText(String.format("Result: %.3f", result));
        }
    }
}
