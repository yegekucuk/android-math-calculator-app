package com.example.project1_ege;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class FactorialActivity extends Activity {

    private EditText numberInput;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.factorial_activity);

        numberInput = findViewById(R.id.numberInput);
        resultText = findViewById(R.id.resultText);
        findViewById(R.id.calculateButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateFactorial();
            }
        });
    }

    private int factorial(String input) {
        try {
            int number = Integer.parseInt(input);
            int fact = 1;
            for (int i = 1; i <= number; i++) {
                fact *= i;
            }
            return fact;
        }
        catch (NumberFormatException e) {
            return -1;
        }
    }

    @SuppressLint("DefaultLocale")
    private void calculateFactorial() {
        String input = numberInput.getText().toString();
        if (!input.isEmpty()) {
            int result = factorial(input);
            if (result != -1)
                resultText.setText(String.format("Result: %d", result));
            else
                resultText.setText(String.format("Result: No result"));
        }
    }
}
