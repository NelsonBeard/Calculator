package com.geekbrains.calculator;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import static com.geekbrains.calculator.Operations.provideOperation;
import static com.geekbrains.calculator.Operations.result;
import static com.geekbrains.calculator.Operations.updateTextViewResult;

public class MainActivity extends AppCompatActivity {

    public static final String OPERATION = "OPERATION";
    public static int currentTheme;
    Operations operation = new Operations();

    private final int[] numberButtonIds = new int[]{R.id.button0, R.id.button1,
            R.id.button2, R.id.button3, R.id.button4, R.id.button5,
            R.id.button6, R.id.button7, R.id.button8, R.id.button9};

    private final int[] operationButtonIds = new int[]{R.id.buttonPlus, R.id.buttonMinus,
            R.id.buttonMultiply, R.id.buttonDivision};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentTheme = getResources().getConfiguration().uiMode
                & Configuration.UI_MODE_NIGHT_MASK;

        Operations.textViewResult = findViewById(R.id.textViewResult);

        setNumberButtonListeners();
        setOperationButtonListeners();

        Button buttonEquals = findViewById(R.id.buttonEquals);
        buttonEquals.setOnClickListener(v -> Operations.provideCount());

        Button buttonClear = findViewById(R.id.buttonClear);
        buttonClear.setOnClickListener(v -> Operations.clearTextViewResult());
        buttonClear.setOnLongClickListener(v -> Operations.changeTheme());
    }

    private void setNumberButtonListeners() {
        for (int i = 0; i < numberButtonIds.length; i++) {
            Button btn = findViewById(numberButtonIds[i]);
            btn.setOnClickListener(v -> updateTextViewResult(btn));
        }
    }

    private void setOperationButtonListeners() {
        for (int i = 0; i < operationButtonIds.length; i++) {
            Button btn = findViewById(operationButtonIds[i]);
            btn.setOnClickListener(v -> provideOperation(btn));
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(OPERATION, operation);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        operation = savedInstanceState.getParcelable(OPERATION);
        Operations.textViewResult.setText(String.valueOf(result));
    }
}