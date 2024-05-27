package com.example.project1_ege;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class HyperbolicActivity extends Activity {

    private EditText numberInput;
    private TextView resultText;
    private Spinner functionSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hyperbolic_activity);

        numberInput = findViewById(R.id.numberInput);
        resultText = findViewById(R.id.resultText);
        functionSpinner = findViewById(R.id.functionSpinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.hyperbolic_functions, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        functionSpinner.setAdapter(adapter);

        findViewById(R.id.calculateButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateHyperbolicFunction();
            }
        });
    }

    @SuppressLint("DefaultLocale")
    private void calculateHyperbolicFunction() {
        String input = numberInput.getText().toString();
        if (!input.isEmpty()) {
            double number = Double.parseDouble(input);
            double result = 0;

            String selectedFunction = functionSpinner.getSelectedItem().toString();

            if (selectedFunction != null) {
                switch (selectedFunction) {
                    case "sinh":
                        result = Math.sinh(number);
                        break;
                    case "cosh":
                        result = Math.cosh(number);
                        break;
                    case "tanh":
                        result = Math.tanh(number);
                        break;
                }

                resultText.setText(String.format("Result: %.3f", result));
            }
        }
    }
}
