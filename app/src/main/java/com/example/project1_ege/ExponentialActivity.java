package com.example.project1_ege;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ExponentialActivity extends Activity {

    private EditText numberInput;
    private EditText exponent;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exponential_activity);

        numberInput = findViewById(R.id.numberInput);
        exponent = findViewById(R.id.exponentInput);
        resultText = findViewById(R.id.resultText);
        findViewById(R.id.calculateButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateExponent();
            }
        });
    }

    @SuppressLint("DefaultLocale")
    private void calculateExponent() {
        String input = numberInput.getText().toString();
        String input2 = exponent.getText().toString();
        if (!input.isEmpty() && !input2.isEmpty()) {
            double number = Double.parseDouble(input);
            double exponent = Double.parseDouble(input2);
            double result = Math.pow(number,exponent);
            resultText.setText(String.format("Result: %.3f", result));
        }
    }
}
