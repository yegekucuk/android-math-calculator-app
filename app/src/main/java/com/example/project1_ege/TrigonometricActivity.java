package com.example.project1_ege;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TrigonometricActivity extends Activity {

    private EditText angleInput;
    private TextView resultText;
    private Spinner functionSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trigonometric_activity);

        angleInput = findViewById(R.id.angleInput);
        resultText = findViewById(R.id.resultText);
        functionSpinner = findViewById(R.id.functionSpinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.trigonometric_functions, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        functionSpinner.setAdapter(adapter);

        findViewById(R.id.calculateButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateTrigonometricFunction();
            }
        });
    }

    @SuppressLint("DefaultLocale")
    private void calculateTrigonometricFunction() {
        String input = angleInput.getText().toString();
        if (!input.isEmpty()) {
            double angle = Math.toRadians(Double.parseDouble(input));
            double result = 0;
            String function = functionSpinner.getSelectedItem().toString();

            switch (function) {
                case "sin":
                    result = Math.sin(angle);
                    break;
                case "cos":
                    result = Math.cos(angle);
                    break;
                case "tan":
                    result = Math.tan(angle);
                    break;
                case "cot":
                    result = 1.0 / Math.tan(angle);
                    break;
            }

            resultText.setText(String.format("Result: %.3f", result));
        }
    }
}
