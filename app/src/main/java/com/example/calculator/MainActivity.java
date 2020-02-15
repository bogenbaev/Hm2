package com.example.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.util.IslamicCalendar;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.*;
import android.os.Bundle;

import static java.lang.StrictMath.abs;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
            private Button buttonNumber1, buttonNumber0;
            private Button buttonNumber2, buttonNumber3, buttonNumber4, buttonNumber5, buttonNumber6, buttonNumber7, buttonNumber8, buttonNumber9;
            private Button buttonResult, buttonPlus, buttonFactorial, buttonClear, buttonDelete, buttonMinus, buttonMultiply, buttonSqrt;
            private Button buttonSin, buttonCos, buttonMod, buttonPower,buttonDivide, buttonDot;
            private double number1, number2;
            private String text;
            private TextView numberInput;
            private TextView numberScreen;
            public char operation;
            private boolean check = true,checkNumber = true,checkOperation = true,delete = true,orientationPortrait = true,orientationLandscape = false;



    @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                numberInput = findViewById(R.id.numberScreen);
                buttonNumber0 = findViewById(R.id.buttonNumber0);
                buttonNumber1 = findViewById(R.id.buttonNumber1);
                buttonNumber2 = findViewById(R.id.buttonNumber2);
                buttonNumber3 = findViewById(R.id.buttonNumber3);
                buttonNumber4 = findViewById(R.id.buttonNumber4);
                buttonNumber5 = findViewById(R.id.buttonNumber5);
                buttonNumber6 = findViewById(R.id.buttonNumber6);
                buttonNumber7 = findViewById(R.id.buttonNumber7);
                buttonNumber8 = findViewById(R.id.buttonNumber8);
                buttonNumber9 = findViewById(R.id.buttonNumber9);
                buttonDot = findViewById(R.id.buttonDot);

                numberScreen = findViewById(R.id.numberScreen);

                buttonClear = findViewById(R.id.buttonClear);
                buttonDelete = findViewById(R.id.buttonDelete);
                buttonFactorial = findViewById(R.id.buttonFactorial);
                buttonPlus = findViewById(R.id.buttonPlus);
                buttonMinus = findViewById(R.id.buttonMinus);
                buttonMultiply = findViewById(R.id.buttonMultiply);
                buttonResult = findViewById(R.id.buttonPower);
                buttonSqrt = findViewById(R.id.buttonSqrt);
                buttonDivide = findViewById(R.id.buttonDivide);
                buttonMod = findViewById(R.id.buttonMod);
                buttonSin = findViewById(R.id.buttonSin);
                buttonCos = findViewById(R.id.buttonCos);
                buttonPower = findViewById(R.id.buttonResult);
                if(savedInstanceState != null){
                    number1 = savedInstanceState.getDouble("number1");
                    number2 = savedInstanceState.getDouble("number2");
                    operation = savedInstanceState.getChar("operation");
                    checkOperation = savedInstanceState.getBoolean("checkOperation");
                    checkNumber = savedInstanceState.getBoolean("checkNumber");
                    check = savedInstanceState.getBoolean("check");
                    delete = savedInstanceState.getBoolean("delete");
                    numberInput.setText(savedInstanceState.getString("numberInput"));
                }
            }


            public void click(View view) {
                Intent intent = new Intent(this, Main2Activity.class);
                startActivity(intent);
            }

            @Override
            public void onClick(View view) {
                try {
                    if(numberInput.getText().toString().equals("Infinity") || numberInput.getText().toString().equals("Wrong operation please enter C") || numberInput.getText().toString().equals("NaN")) {
                        numberInput.setText("Wrong operation please enter C");
                        checkNumber = false;
                        delete = false;
                    }
                    switch (view.getId()) {
                        case R.id.buttonNumber0: {
                            if(checkNumber)
                                numberInput.append("0");
                            break;
                        }
                        case R.id.buttonNumber1: {
                            if (checkNumber) {
                                numberInput.append("1");
                            }
                            break;
                        }
                        case R.id.buttonNumber2: {
                            if (checkNumber) {
                                numberInput.append("2");
                            }
                            break;
                        }
                        case R.id.buttonNumber3: {
                            if (checkNumber) {
                                numberInput.append("3");
                            }
                            break;
                        }
                        case R.id.buttonNumber4: {
                            if (checkNumber) {
                                numberInput.append("4");
                            }
                            break;
                        }
                        case R.id.buttonNumber5: {
                            if (checkNumber) {
                                numberInput.append("5");
                            }
                            break;
                        }
                        case R.id.buttonNumber6: {
                            if (checkNumber) {
                                numberInput.append("6");
                            }
                            break;
                        }
                        case R.id.buttonNumber7: {
                            if (checkNumber) {
                                numberInput.append("7");
                            }
                            break;
                        }
                        case R.id.buttonNumber8: {
                            if (checkNumber) {
                                numberInput.append("8");
                            }
                            break;
                        }
                        case R.id.buttonNumber9: {
                            if (checkNumber) {
                                numberInput.append("9");
                            }
                            break;

                        }
                        case R.id.buttonDot: {
                            if (check && checkNumber) {
                                numberInput.setText(numberInput.getText() + ".");
                                check = false;
                            }
                            break;
                        }
                        case R.id.buttonPlus: {
                            check = true;
                            checkNumber = true;
                            checkOperation = true;

                            //numberScreen.setText(numberInput.getText().toString());
                            if (numberInput.getText().toString().length() != 0) {
                                number1 = Double.valueOf(numberInput.getText().toString());
                            }
                            numberInput.setText("");
                            operation = '+';
                            break;
                        }
                        case R.id.buttonMultiply: {
                            checkOperation = true;
                            check = true;
                            checkNumber = true;
                            if (numberInput.getText().toString().length() != 0) {
                                number1 = Double.valueOf(numberInput.getText().toString());
                            }
                            numberInput.setText("");
                            operation = 'x';
                            break;
                        }
                        case R.id.buttonMinus: {
                            checkOperation = true;
                            check = true;
                            checkNumber = true;
                            if (numberInput.getText().toString().length() != 0) {
                                number1 = Double.valueOf(numberInput.getText().toString());
                            }
                            numberInput.setText("");
                            operation = '-';
                            break;
                        }
                        case R.id.buttonDivide: {
                            check = true;
                            checkNumber = true;
                            if (numberInput.getText().toString().length() != 0) {
                                number1 = Double.valueOf(numberInput.getText().toString());
                            }
                            numberInput.setText("");
                            operation = '/';
                            break;
                        }
                        case R.id.buttonMod: {
                            check = true;
                            checkNumber = true;
                            if (numberInput.getText().toString().length() != 0) {
                                number1 = Double.valueOf(numberInput.getText().toString());
                            }
                            numberInput.setText("");
                            operation = '%';
                            break;
                        }
                        case R.id.buttonFactorial: {
                            try {
                                double number = Double.valueOf(numberInput.getText().toString());
                                long number1 = (long) (number);
                                if (number < 20 && number >= 0) {
                                    long s = 1;
                                    for (int i = 1; i <= number; i++) {
                                        s *= i;
                                    }
                                    numberInput.setText(String.valueOf(s));
                                }
                            } catch (Exception e) {
                                numberInput.setText("Wrong operation please enter C");
                            }
                            break;
                        }
                        case R.id.buttonDelete: {
                            if(delete) {
                                text = numberInput.getText().toString();
                                if (text.length() > 0) {
                                    text = text.substring(0, text.length() - 1);
                                    numberInput.setText(text);
                                }
                            }
                            break;
                        }
                        case R.id.buttonResult: {
                            checkNumber = false;
                            check = false;
                            try {

                            if(checkOperation){
                                number2 = Double.valueOf(numberInput.getText().toString());
                                numberInput.setText(String.valueOf(operation(number1, number2)));
                                if(numberInput.getText().toString().equals("NaN"))
                                    numberInput.setText("Wrong operation please enter C");
                                number1 = number2;
                                checkOperation = false;
                            }
                            else{
                                number2 = Double.valueOf(numberInput.getText().toString());
                                numberInput.setText(String.valueOf(operation(number2, number1)));
                                if(numberInput.getText().toString().equals("NaN"))
                                    numberInput.setText("Wrong operation please enter C");
                                }
                            }
                            catch (Exception e){

                            }
                            break;
                        }
                        case R.id.buttonPower: {
//                            checkNumber = true;
//                            check = true;
//                            if (numberInput.getText().toString().length() != 0) {
//                                number1 = Double.valueOf(numberInput.getText().toString());
//                            }
//                            numberInput.setText("");
//                            operation = 'p';
                            if(orientationLandscape == false && orientationPortrait == true){
                                orientationLandscape = true;
                                orientationPortrait = false;
                                //setRequestedOrientation(Ca.SCREEN_ORIENTATION_LANDSCAPE);
                            }
                            break;
                        }
                        case R.id.buttonSqrt: {
                            if (numberInput.getText().toString().length() != 0) {
                                number1 = Double.valueOf(numberInput.getText().toString());
                            }
                            if (number1 >= 0) {
                                numberInput.setText(String.valueOf(Math.sqrt(number1)));
                            } else {
                                numberInput.setText("Wrong operation please enter C");
                            }
                            break;
                        }
                        case R.id.buttonSin: {
                            if (numberInput.getText().toString().length() != 0) {
                                number1 = Double.valueOf(numberInput.getText().toString());
                            }
                            if (number1 == 30)
                                numberInput.setText("0.5");
                            else
                                numberInput.setText(String.valueOf(Math.sin(Math.toRadians(number1))));
                            break;
                        }
                        case R.id.buttonCos: {
                            if (numberInput.getText().toString().length() != 0) {
                                number1 = Double.valueOf(numberInput.getText().toString());
                            }
                            if (number1 == 60)
                                numberInput.setText("0.5");
                            else
                                numberInput.setText(String.valueOf(Math.cos(Math.toRadians(number1))));
                            break;
                        }
                        case R.id.buttonClear: {
                            checkNumber = true;
                            checkOperation = true;
                            check = true;
                            delete = true;
                            number1 = 0;
                            number2 = 0;
                            numberInput.setText("");
                            break;
                        }
                    }
                }
                catch(Exception e){
                    numberInput.setText("Wrong operation please enter C");
                }
            }
            public double operation(double num1, double num2){
                switch(operation){
                    case '+':
                        return num1 + num2;
                    case '-':
                        return num1 - num2;
                    case 'x':
                        return num1 * num2;
                    case '/':
                        return num1 / num2;
                    case '%':
                        return num1 % num2;
                    case 'p':
                        return Math.pow(num1, num2);
                    case 's':
                        return Math.sin(num1);
                    default:
                        return 0;
                }
            }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("numberInput", numberInput.getText().toString());
        outState.putDouble("number1", number1);
        outState.putDouble("number2", number2);
        outState.putBoolean("check" , check);
        outState.putBoolean("checkNumber" , checkNumber);
        outState.putBoolean("delete" , delete);
        outState.putBoolean("checkOperation" , checkOperation);
        outState.putChar("operation", operation);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        savedInstanceState.getString("numberInput");
        savedInstanceState.getString("number1");
        savedInstanceState.getString("number2");
        savedInstanceState.getString("checkNumber");
        savedInstanceState.getString("check");
        savedInstanceState.getString("operation");
        savedInstanceState.getString("delete");
        savedInstanceState.getString("checkOperation");

        }
    }

