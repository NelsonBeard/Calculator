package com.geekbrains.calculator;

import android.content.res.Configuration;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatDelegate;

import java.io.Serializable;

public class Operations implements Serializable {

    static TextView textViewResult;
    static Double firstOperand;
    static Double secondOperand;
    static Double result;
    static String operation;

    static void updateTextViewResult(Button button) {
        textViewResult.append(button.getText().toString());
    }

    static void provideOperation(Button button) {
        operation = String.valueOf(button.getText());
        if ((textViewResult.getText().toString().length() > 0) && (textViewResult.getText().toString() != null)) {
            firstOperand = Double.valueOf(textViewResult.getText().toString());
            textViewResult.setText(null);
        }
    }


    static void provideCount() {
        if ((textViewResult.getText().toString().length() > 0) && (textViewResult.getText().toString() != null)&&(firstOperand!=null)) {
            secondOperand = Double.valueOf(textViewResult.getText().toString());

            switch (operation) {
                case "+":
                    result = firstOperand + secondOperand;
                    break;
                case "-":
                    result = firstOperand - secondOperand;
                    break;
                case "*":
                    result = firstOperand * secondOperand;
                    break;
                case "/":
                    if (secondOperand != 0) {
                        result = firstOperand / secondOperand;
                    } else {
                        result = null;
                    }
                    break;
            }
            textViewResult.setText(String.valueOf(result));
        }
    }

    static void clearTextViewResult() {
        textViewResult.setText(null);
        firstOperand = null;
        secondOperand = null;
        result = null;

    }

    static boolean changeTheme() {
        switch (MainActivity.currentTheme) {
            case Configuration.UI_MODE_NIGHT_NO:
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                break;
            case Configuration.UI_MODE_NIGHT_YES:
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                break;
        }
        return true;
    }

}

