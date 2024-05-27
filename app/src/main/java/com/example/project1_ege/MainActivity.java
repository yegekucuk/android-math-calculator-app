package com.example.project1_ege;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.view.View;
import android.widget.AdapterView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Week 12
    // Add 3 more functionalities
    // Add example
    // First show image and example, then show calculator

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);

        String[] values = new String[] { "Logarithm", "Exponential", "Square Root", "Factorial", "Trigonometric"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(MainActivity.this, LogarithmActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(MainActivity.this, ExponentialActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(MainActivity.this, SquareRootActivity.class));
                        break;
                    case 3:
                        startActivity(new Intent(MainActivity.this, FactorialActivity.class));
                        break;
                    case 4:
                        startActivity(new Intent(MainActivity.this, TrigonometricActivity.class));
                        break;
                }
            }
        });
    }
}
