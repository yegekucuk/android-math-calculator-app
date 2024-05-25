package com.example.project1_ege;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LogarithmActivity extends Activity {

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

    private double naturalLog(double x) {
        if (x <= 0) {
            return -1;
        }

        // Change of variables to improve convergence
        double y = (x - 1) / (x + 1);
        double result = 0.0;
        double term = y;
        int n = 1;

        // Taylor series expansion for ln(1 + z)
        // ln(x) = 2 * (y + y^3/3 + y^5/5 + ...)
        while (Math.abs(term) > 1e-10) {
            result += term / n;
            n += 2;
            term *= y * y;
        }

        return 2 * result;
    }

    private double logarithm(double number, double base) {
        if (base <= 0 || base == 1 || number <= 0) {
            return -1;
        }

        return naturalLog(number) / naturalLog(base);
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
            if (result != -1)
                resultText.setText(String.format("Result: %.3f", result));
            else
                resultText.setText(String.format("Result: No result", result));
        }
    }
}
