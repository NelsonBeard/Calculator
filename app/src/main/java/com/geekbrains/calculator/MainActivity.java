package com.geekbrains.calculator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import static com.geekbrains.calculator.Operations.provideOperation;
import static com.geekbrains.calculator.Operations.result;
import static com.geekbrains.calculator.Operations.updateTextViewResult;

public class MainActivity extends AppCompatActivity {


    public static final String OPERATION = "OPERATION";
    Operations operation = new Operations();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Operations.textViewResult = findViewById(R.id.textViewResult);

        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(v -> updateTextViewResult(button1));

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(v -> updateTextViewResult(button2));

        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(v -> updateTextViewResult(button3));

        Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(v -> updateTextViewResult(button4));

        Button button5 = findViewById(R.id.button5);
        button5.setOnClickListener(v -> updateTextViewResult(button5));

        Button button6 = findViewById(R.id.button6);
        button6.setOnClickListener(v -> updateTextViewResult(button6));

        Button button7 = findViewById(R.id.button7);
        button7.setOnClickListener(v -> updateTextViewResult(button7));

        Button button8 = findViewById(R.id.button8);
        button8.setOnClickListener(v -> updateTextViewResult(button8));

        Button button9 = findViewById(R.id.button9);
        button9.setOnClickListener(v -> updateTextViewResult(button9));

        Button button0 = findViewById(R.id.button0);
        button0.setOnClickListener(v -> updateTextViewResult(button0));

        Button buttonPlus = findViewById(R.id.buttonPlus);
        buttonPlus.setOnClickListener(v -> provideOperation(buttonPlus));

        Button buttonMinus = findViewById(R.id.buttonMinus);
        buttonMinus.setOnClickListener(v -> provideOperation(buttonMinus));

        Button buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonMultiply.setOnClickListener(v -> provideOperation(buttonMultiply));

        Button buttonDivision = findViewById(R.id.buttonDivision);
        buttonDivision.setOnClickListener(v -> provideOperation(buttonDivision));

        Button buttonEquals = findViewById(R.id.buttonEquals);
        buttonEquals.setOnClickListener(v -> Operations.provideCount());

        Button buttonClear = findViewById(R.id.buttonClear);
        buttonClear.setOnClickListener(v -> Operations.clearTextViewResult());
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(OPERATION,operation);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        operation = savedInstanceState.getParcelable(OPERATION);
        Operations.textViewResult.setText(String.valueOf(result));
    }
}