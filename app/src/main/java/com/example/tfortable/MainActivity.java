package com.example.tfortable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText numberInput;
    private TableLayout multiplicationTable;
    private Button generateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberInput = findViewById(R.id.number_input);
        multiplicationTable = findViewById(R.id.multiplication_table);
        generateButton = findViewById(R.id.generate_button);

        generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateTable();
            }
        });
    }

    private void updateTable() {
        multiplicationTable.removeAllViews();

        int number = 0;

        // Get the number from the input, if possible
        try {
            number = Integer.parseInt(numberInput.getText().toString());
        } catch (NumberFormatException e) {
            // Ignore invalid input
        }

        // Populate the table with the multiplication table for the input number
        for (int i = 1; i <= 10; i++) {
            TableRow row = new TableRow(this);
            TextView leftCell = new TextView(this);
            TextView rightCell = new TextView(this);

            leftCell.setText(String.format("%d x %d  =  ", number, i));
            rightCell.setText(String.valueOf(number * i));

            row.addView(leftCell);
            row.addView(rightCell);

            multiplicationTable.addView(row);
        }
    }
}

