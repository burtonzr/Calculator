package com.example.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String KEY_INDEX = "index";
    TextView calculatorScreen;
    // first number before operator
    private double firstNumber = 0;
    // index value
    private int numberAfterOperatorIndex = 0;
    private boolean isButtonPressed = false;
    private char currentOperator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculatorScreen = findViewById(R.id.calculatorScreen);
        final Button b0 = findViewById(R.id.b0);
        final Button b1 = findViewById(R.id.b1);
        final Button b2 = findViewById(R.id.b2);
        final Button b3 = findViewById(R.id.b3);
        final Button b4 = findViewById(R.id.b4);
        final Button b5 = findViewById(R.id.b5);
        final Button b6 = findViewById(R.id.b6);
        final Button b7 = findViewById(R.id.b7);
        final Button b8 = findViewById(R.id.b8);
        final Button b9 = findViewById(R.id.b9);
        final Button bC = findViewById(R.id.bC);
        final Button addition    = findViewById(R.id.addition);
        final Button subtraction = findViewById(R.id.subtraction);
        final Button multiply    = findViewById(R.id.multiply);
        final Button division    = findViewById(R.id.division);
        final Button period      = findViewById(R.id.period);
        final Button clear       = findViewById(R.id.clear);
        final Button equal       = findViewById(R.id.equal);
        final View.OnClickListener calculatorListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //count++;
                // v.getId() returns the android:id value for each button and text view.
                String numbers = calculatorScreen.getText().toString();
                int length = numbers.length();
                String screenContent = calculatorScreen.getText().toString();
                switch(v.getId()) {
                    case R.id.b0:
                        if(calculatorScreen.getText().toString().startsWith("_")) {
                            calculatorScreen.setText("");
                            calculatorScreen.append("0");
                        } else {
                            calculatorScreen.append("0");
                        }
                        break;
                    case R.id.b1:
                        if(calculatorScreen.getText().toString().startsWith("_")) {
                            calculatorScreen.setText("");
                            calculatorScreen.append("1");
                        } else {
                            calculatorScreen.append("1");
                        }
                        break;
                    case R.id.b2:
                        if(calculatorScreen.getText().toString().startsWith("_")) {
                            calculatorScreen.setText("");
                            calculatorScreen.append("2");
                        } else {
                            calculatorScreen.append("2");
                        }
                        break;
                    case R.id.b3:
                        if(calculatorScreen.getText().toString().startsWith("_")) {
                            calculatorScreen.setText("");
                            calculatorScreen.append("3");
                        } else {
                            calculatorScreen.append("3");
                        }
                        break;
                    case R.id.b4:
                        if(calculatorScreen.getText().toString().startsWith("_")) {
                            calculatorScreen.setText("");
                            calculatorScreen.append("4");
                        } else {
                            calculatorScreen.append("4");
                        }
                        break;
                    case R.id.b5:
                        if(calculatorScreen.getText().toString().startsWith("_")) {
                            calculatorScreen.setText("");
                            calculatorScreen.append("5");
                        } else {
                            calculatorScreen.append("5");
                        }
                        break;
                    case R.id.b6:
                        if(calculatorScreen.getText().toString().startsWith("_")) {
                            calculatorScreen.setText("");
                            calculatorScreen.append("6");
                        } else {
                            calculatorScreen.append("6");
                        }
                        break;
                    case R.id.b7:
                        if(calculatorScreen.getText().toString().startsWith("_")) {
                            calculatorScreen.setText("");
                            calculatorScreen.append("7");
                        } else {
                            calculatorScreen.append("7");
                        }
                        break;
                    case R.id.b8:
                        if(calculatorScreen.getText().toString().startsWith("_")) {
                            calculatorScreen.setText("");
                            calculatorScreen.append("8");
                        } else {
                            calculatorScreen.append("8");
                        }
                        break;
                    case R.id.b9:
                        if(calculatorScreen.getText().toString().startsWith("_")) {
                            calculatorScreen.setText("");
                            calculatorScreen.append("9");
                        } else {
                            calculatorScreen.append("9");
                        }
                        break;
                    case R.id.period:
                        try {
                            if(calculatorScreen.getText().toString().startsWith("_")) {
                                calculatorScreen.setText("");
                                calculatorScreen.setText(calculatorScreen.getText().toString() + ".");
                                isButtonPressed = true;
                                currentOperator = '.';
                            } else {
                                calculatorScreen.setText(calculatorScreen.getText().toString() + ".");
                                isButtonPressed = true;
                                currentOperator = '.';
                            }
                        } catch (NumberFormatException e) {
                            calculatorScreen.setText("There was an error. ");
                        }
                        break;
                    case R.id.addition:
                        try {
                            if(isButtonPressed){
                                if(calculatorScreen.getText().toString().contains("+")) {
                                    String tokens[] = calculatorScreen.getText().toString().split("\\+");
                                    double firstNum = Double.parseDouble(tokens[0]);
                                    double secondNum = Double.parseDouble(tokens[1]);
                                    double output = firstNum+secondNum;
                                    calculatorScreen.setText(Double.toString(output));
                                    calculatorScreen.setText(calculatorScreen.getText().toString() + "+");
                                    break;
                                }
                                if(calculatorScreen.getText().toString().contains("-")) {
                                    String tokens[] = calculatorScreen.getText().toString().split("-");
                                    double firstNum = Double.parseDouble(tokens[0]);
                                    double secondNum = Double.parseDouble(tokens[1]);
                                    double output = firstNum-secondNum;
                                    calculatorScreen.setText(Double.toString(output));
                                    calculatorScreen.setText(calculatorScreen.getText().toString() + "+");
                                    break;
                                }
                                if(calculatorScreen.getText().toString().contains("X")) {
                                    String tokens[] = calculatorScreen.getText().toString().split("X");
                                    double firstNum = Double.parseDouble(tokens[0]);
                                    double secondNum = Double.parseDouble(tokens[1]);
                                    double output = firstNum*secondNum;
                                    calculatorScreen.setText(Double.toString(output));
                                    calculatorScreen.setText(calculatorScreen.getText().toString() + "+");
                                    break;
                                }
                                if(calculatorScreen.getText().toString().contains("/")) {
                                    String[] parts = calculatorScreen.getText().toString().split("\\/");
                                    double finalAnswer = Double.parseDouble(parts[0]) / Double.parseDouble(parts[1]);
                                    if(parts[1].startsWith("0")) {
                                        calculatorScreen.setText("ERR");
                                        break;
                                    } else if(parts[1].startsWith("0.00")) {
                                        calculatorScreen.setText("ERR");
                                        break;
                                    } else if(parts[1].startsWith(".0")) {
                                        calculatorScreen.setText("ERR");
                                        break;
                                    } else {
                                        calculatorScreen.setText(Double.toString(finalAnswer));
                                        calculatorScreen.setText(calculatorScreen.getText().toString() + "+");
                                    }
                                    break;
                                }
                            }
                            numberAfterOperatorIndex = screenContent.length() + 1;
                            // parseDouble() converts a string to a double.
                            firstNumber = Double.parseDouble(screenContent);
                            calculatorScreen.setText(calculatorScreen.getText().toString() + "+");
                            isButtonPressed = true;
                            currentOperator = '+';
                        } catch (NumberFormatException e) {
                            calculatorScreen.setText("ERR");
                        } catch (ArrayIndexOutOfBoundsException e) {
                            calculatorScreen.setText("ERR");
                        }
                        break;
                    case R.id.subtraction:
                        try {
                            if(isButtonPressed == true){
                                if(calculatorScreen.getText().toString().contains("+")) {
                                    String tokens[] = calculatorScreen.getText().toString().split("\\+");
                                    double firstNum = Double.parseDouble(tokens[0]);
                                    double secondNum = Double.parseDouble(tokens[1]);
                                    double output = firstNum+secondNum;
                                    calculatorScreen.setText(Double.toString(output));
                                    calculatorScreen.setText(calculatorScreen.getText().toString() + "-");
                                    break;
                                }
                                if(calculatorScreen.getText().toString().contains("-")) {
                                    String tokens[] = calculatorScreen.getText().toString().split("-");
                                    double firstNum = Double.parseDouble(tokens[0]);
                                    double secondNum = Double.parseDouble(tokens[1]);
                                    double output = firstNum - secondNum;
                                    calculatorScreen.setText(Double.toString(output));
                                    calculatorScreen.setText(calculatorScreen.getText().toString() + "-");
                                    break;
                                }
                                if(calculatorScreen.getText().toString().contains("X")) {
                                    String tokens[] = calculatorScreen.getText().toString().split("X");
                                    double firstNum = Double.parseDouble(tokens[0]);
                                    double secondNum = Double.parseDouble(tokens[1]);
                                    double output = firstNum * secondNum;
                                    calculatorScreen.setText(Double.toString(output));
                                    calculatorScreen.setText(calculatorScreen.getText().toString() + "-");
                                    break;
                                }
                                if(calculatorScreen.getText().toString().contains("/")) {
                                    String[] parts = calculatorScreen.getText().toString().split("\\/");
                                    double finalAnswer = Double.parseDouble(parts[0]) / Double.parseDouble(parts[1]);
                                    if(parts[1].startsWith("0")) {
                                        calculatorScreen.setText("ERR");
                                        break;
                                    } else if(parts[1].startsWith("0.00")) {
                                        calculatorScreen.setText("ERR");
                                        break;
                                    } else if(parts[1].startsWith(".0")) {
                                        calculatorScreen.setText("ERR");
                                        break;
                                    } else {
                                        calculatorScreen.setText(Double.toString(finalAnswer));
                                        calculatorScreen.setText(calculatorScreen.getText().toString() + "-");
                                    }
                                    break;
                                }
                            }
                            numberAfterOperatorIndex = screenContent.length() + 1;
                            firstNumber = Double.parseDouble(screenContent);
                            calculatorScreen.setText(calculatorScreen.getText().toString() + "-");
                            isButtonPressed = true;
                            currentOperator = '-';
                        } catch (NumberFormatException e) {
                            calculatorScreen.setText("ERR");
                        } catch (ArrayIndexOutOfBoundsException e) {
                            calculatorScreen.setText("ERR");
                        }
                        break;
                    case R.id.multiply:
                        try {
                            if(isButtonPressed == true) {
                                if(calculatorScreen.getText().toString().contains("+")) {
                                    String tokens[] = calculatorScreen.getText().toString().split("\\+");
                                    double firstNumber = Double.parseDouble(tokens[0]);
                                    double secondNumber = Double.parseDouble(tokens[1]);
                                    double result = firstNumber + secondNumber;
                                    calculatorScreen.setText(String.valueOf(result));
                                    calculatorScreen.setText(calculatorScreen.getText().toString() + "X");
                                    break;
                                }
                                if(calculatorScreen.getText().toString().contains("-")) {
                                    String tokens[] = calculatorScreen.getText().toString().split("-");
                                    double firstNum = Double.parseDouble(tokens[0]);
                                    double secondNum = Double.parseDouble(tokens[1]);
                                    double output = firstNum - secondNum;
                                    calculatorScreen.setText(Double.toString(output));
                                    calculatorScreen.setText(calculatorScreen.getText().toString() + "X");
                                    break;
                                }
                                if(calculatorScreen.getText().toString().contains("X")) {
                                    String tokens[] = calculatorScreen.getText().toString().split("X");
                                    double firstNum = Double.parseDouble(tokens[0]);
                                    double secondNum = Double.parseDouble(tokens[1]);
                                    double output = firstNum * secondNum;
                                    calculatorScreen.setText(Double.toString(output));
                                    calculatorScreen.setText(calculatorScreen.getText().toString() + "X");
                                    break;
                                }
                                if(calculatorScreen.getText().toString().contains("/")) {
                                    String tokens[] = calculatorScreen.getText().toString().split("\\/");
                                    double firstNumber = Double.parseDouble(tokens[0]);
                                    double secondNumber = Double.parseDouble(tokens[1]);
                                    double result = firstNumber / secondNumber;
                                    if(tokens[1].startsWith("0")) {
                                        calculatorScreen.setText("ERR");
                                        break;
                                    } else if(tokens[1].startsWith("0.00")) {
                                        calculatorScreen.setText("ERR");
                                        break;
                                    } else if(tokens[1].startsWith(".0")) {
                                        calculatorScreen.setText("ERR");
                                        break;
                                    } else {
                                        calculatorScreen.setText(String.valueOf(result));
                                        calculatorScreen.setText(calculatorScreen.getText().toString() + "X");
                                    }
                                    break;
                                }
                            }
                            numberAfterOperatorIndex = screenContent.length() + 1;
                            firstNumber = Double.parseDouble(screenContent);
                            calculatorScreen.setText(calculatorScreen.getText().toString() + "X");
                            isButtonPressed = true;
                            currentOperator = 'X';
                        } catch (NumberFormatException e) {
                            calculatorScreen.setText("ERR");
                        } catch (ArrayIndexOutOfBoundsException e) {
                            calculatorScreen.setText("ERR");
                        }
                        break;
                    case R.id.division:
                        try {
                            if(isButtonPressed) {
                                if(calculatorScreen.getText().toString().contains("+")) {
                                    String tokens[] = calculatorScreen.getText().toString().split("\\+");
                                    double firstNumber = Double.parseDouble(tokens[0]);
                                    double secondNumber = Double.parseDouble(tokens[1]);
                                    double result = firstNumber + secondNumber;
                                    calculatorScreen.setText(String.valueOf(result));
                                    calculatorScreen.setText(calculatorScreen.getText().toString() + "/");
                                    break;
                                } else if(calculatorScreen.getText().toString().contains("-")) {
                                    String tokens[] = calculatorScreen.getText().toString().split("-");
                                    double firstNumber = Double.parseDouble(tokens[0]);
                                    double secondNumber = Double.parseDouble(tokens[1]);
                                    double result = firstNumber - secondNumber;
                                    calculatorScreen.setText(String.valueOf(result));
                                    calculatorScreen.setText(calculatorScreen.getText().toString() + "/");
                                    break;
                                } else if(calculatorScreen.getText().toString().contains("X")) {
                                    String tokens[] = calculatorScreen.getText().toString().split("X");
                                    double firstNumber = Double.parseDouble(tokens[0]);
                                    double secondNumber = Double.parseDouble(tokens[1]);
                                    double result = firstNumber * secondNumber;
                                    calculatorScreen.setText(String.valueOf(result));
                                    calculatorScreen.setText(calculatorScreen.getText().toString() + "/");
                                    break;
                                } else if(calculatorScreen.getText().toString().contains("/")) {
                                    String tokens[] = calculatorScreen.getText().toString().split("\\/");
                                    double firstNumber = Double.parseDouble(tokens[0]);
                                    double secondNumber = Double.parseDouble(tokens[1]);
                                    double result = firstNumber / secondNumber;
                                    if(tokens[1].startsWith("0")) {
                                        calculatorScreen.setText("ERR");
                                        break;
                                    } else if(tokens[1].startsWith("0.00")) {
                                        calculatorScreen.setText("ERR");
                                        break;
                                    } else if(tokens[1].startsWith(".0")) {
                                        calculatorScreen.setText("ERR");
                                        break;
                                    } else {
                                        calculatorScreen.setText(String.valueOf(result));
                                        calculatorScreen.setText(calculatorScreen.getText().toString() + "/");
                                    }
                                    break;
                                }
                            }
                            numberAfterOperatorIndex = screenContent.length() + 1;
                            firstNumber = Double.parseDouble(screenContent);
                            calculatorScreen.setText(calculatorScreen.getText().toString() + "/");
                            isButtonPressed = true;
                            currentOperator = '/';
                        } catch (NumberFormatException e) {
                            calculatorScreen.setText("ERR");
                        } catch (ArrayIndexOutOfBoundsException e) {
                            calculatorScreen.setText("ERR");
                        }
                        break;
                    case R.id.bC:
                        if(length > 0) {
                            // delete the first number
                            numbers = numbers.substring(0, length - 1);
                            // update the screen
                            calculatorScreen.setText(numbers);
                            if(length == 1) {
                                calculatorScreen.setText("_");
                            }
                        }
                        break;
                    case R.id.clear:
                        calculatorScreen.setText("_");
                        break;
                    case R.id.equal:
                        if(isButtonPressed) {
                            if(calculatorScreen.getText().toString().contains("+")) {
                                try {
                                    String tokens[] = calculatorScreen.getText().toString().split("\\+");
                                    double firstNum = Double.parseDouble(tokens[0]);
                                    double secondNum = Double.parseDouble(tokens[1]);
                                    double output = firstNum + secondNum;
                                    if(tokens[0].startsWith("0") && !tokens[0].contains(".")) {
                                        if(tokens[0].equals("0")) {
                                            calculatorScreen.setText(String.valueOf(output));
                                            break;
                                        } else {
                                            calculatorScreen.setText("ERR");
                                            break;
                                        }
                                    } else if(tokens[1].startsWith("0") && !tokens[1].contains(".")) {
                                        if(tokens[1].equals("0")) {
                                            calculatorScreen.setText(String.valueOf(output));
                                            break;
                                        } else {
                                            calculatorScreen.setText("ERR");
                                            break;
                                        }
                                    }
                                    calculatorScreen.setText(String.valueOf(output));
                                } catch (NumberFormatException e) {
                                    calculatorScreen.setText("ERR");
                                } catch (ArrayIndexOutOfBoundsException e) {
                                    calculatorScreen.setText("ERR");
                                }
                                break;
                            } else if(calculatorScreen.getText().toString().contains("-")) {
                                try {
                                    String[] tokens = calculatorScreen.getText().toString().split("-");
                                    double result = Double.parseDouble(tokens[0]) - Double.parseDouble(tokens[1]);
                                    if(tokens[0].startsWith("0") && !tokens[0].contains(".")) {
                                        if(tokens[0].equals("0")) {
                                            calculatorScreen.setText(Double.toString(result));
                                            break;
                                        } else {
                                            calculatorScreen.setText("ERR");
                                            break;
                                        }
                                    } else if(tokens[1].startsWith("0") && !tokens[1].contains(".")) {
                                        if(tokens[1].equals("0")) {
                                            calculatorScreen.setText(Double.toString(result));
                                            break;
                                        } else {
                                            calculatorScreen.setText("ERR");
                                            break;
                                        }
                                    }
                                    calculatorScreen.setText(Double.toString(result));
                                } catch (NumberFormatException e) {
                                    calculatorScreen.setText("ERR");
                                } catch (ArrayIndexOutOfBoundsException e) {
                                    calculatorScreen.setText("ERR");
                                }
                                break;
                            } else if(calculatorScreen.getText().toString().contains("X")) {
                                try {
                                    String[] tokens = calculatorScreen.getText().toString().split("X");
                                    double result = Double.parseDouble(tokens[0]) * Double.parseDouble(tokens[1]);
                                    if(tokens[0].startsWith("0") && !tokens[0].contains(".")) {
                                        if(tokens[0].equals("0")) {
                                            calculatorScreen.setText(Double.toString(result));
                                            break;
                                        } else {
                                            calculatorScreen.setText("ERR");
                                            break;
                                        }
                                    } else if(tokens[1].startsWith("0") && !tokens[1].contains(".")) {
                                        if(tokens[1].equals("0")) {
                                            calculatorScreen.setText(Double.toString(result));
                                            break;
                                        } else {
                                            calculatorScreen.setText("ERR");
                                            break;
                                        }
                                    }
                                    calculatorScreen.setText(Double.toString(result));
                                } catch (NumberFormatException e) {
                                    calculatorScreen.setText("ERR");
                                } catch (ArrayIndexOutOfBoundsException e) {
                                    calculatorScreen.setText("ERR");
                                }
                                break;
                            } else if(calculatorScreen.getText().toString().contains("/")) {
                                try {
                                    String[] parts = calculatorScreen.getText().toString().split("\\/");
                                    double finalAnswer = Double.parseDouble(parts[0]) / Double.parseDouble(parts[1]);
                                    if(parts[0].startsWith("0") && !parts[0].contains(".")) {
                                        if(parts[0].equals("0")) {
                                            calculatorScreen.setText(Double.toString(finalAnswer));
                                            break;
                                        } else {
                                            calculatorScreen.setText("ERR");
                                            break;
                                        }
                                    } else if(parts[1].startsWith("0")) {
                                        calculatorScreen.setText("ERR");
                                        break;
                                    } else if(parts[1].startsWith(".0")) {
                                        calculatorScreen.setText("ERR");
                                        break;
                                    }
                                    calculatorScreen.setText(Double.toString(finalAnswer));
                                } catch (NumberFormatException e) {
                                    calculatorScreen.setText("ERR");
                                } catch (ArrayIndexOutOfBoundsException e) {
                                    calculatorScreen.setText("ERR");
                                }
                                break;
                            }
                        } else {
                            calculatorScreen.setText("ERR");
                        }
                        break;
                }
            }
        };
        b0.setOnClickListener(calculatorListener);
        b1.setOnClickListener(calculatorListener);
        b2.setOnClickListener(calculatorListener);
        b3.setOnClickListener(calculatorListener);
        b4.setOnClickListener(calculatorListener);
        b5.setOnClickListener(calculatorListener);
        b6.setOnClickListener(calculatorListener);
        b7.setOnClickListener(calculatorListener);
        b8.setOnClickListener(calculatorListener);
        b9.setOnClickListener(calculatorListener);
        bC.setOnClickListener(calculatorListener);
        addition.setOnClickListener(calculatorListener);
        subtraction.setOnClickListener(calculatorListener);
        multiply.setOnClickListener(calculatorListener);
        division.setOnClickListener(calculatorListener);
        equal.setOnClickListener(calculatorListener);
        period.setOnClickListener(calculatorListener);
        clear.setOnClickListener(calculatorListener);

        if(savedInstanceState != null) {
            String screenText = savedInstanceState.getString(KEY_INDEX);
            calculatorScreen.setText(screenText);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString(KEY_INDEX, calculatorScreen.getText().toString());
        super.onSaveInstanceState(savedInstanceState);
    }
}