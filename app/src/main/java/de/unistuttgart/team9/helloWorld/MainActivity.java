package de.unistuttgart.team9.helloWorld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    final String TAG = MainActivity.class.getCanonicalName();

    private Button button0,button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonDot, buttonClear, buttonAdd, buttonSub, buttonMul, buttonDiv, buttonSum;

    /* Test */

    private EditText edit1;
    private Float value1, value2, valueSum, tempValue;
    private Boolean calAdd = false, calSub = false, calMul = false, calDiv = false, calOperation = false;
    private String tempString;

    /**
     * Reads the value in EditText edit. If the EditText edit is empty a zero will be returned.
     * @param edit
     * @return float value
     */
    private float readEditText(EditText edit) {
        tempString = edit.getText() + "";
        if ("" == tempString) { // if EditText is empty set it to 0
            tempValue = 0.0f;
        } else {
            tempValue = Float.parseFloat(tempString);
        }
        return tempValue;
    }

    /**
     * Calculate the temporal result if a longer calculation without using '=' will be made.
     * @param edit
     */
    private void calculateTempResult(EditText edit) {
        if (value1 != null){ // for "chain calulation"
            value2 = readEditText(edit1);

            if(calAdd) {
                value1 = value1 + value2;
                calAdd = false;
            } else if(calSub) {
                value1 = value1 - value2;
                calSub = false;
            } else if(calMul) {
                value1 = value1 * value2;
                calMul = false;
            } else if(calDiv) {
                value1 = value1 / value2;
                calDiv = false;
            }

            edit1.setText("");
        } else {
            value1 = readEditText(edit1);
            edit1.setText("");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // match Button with element in design
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        buttonDot = findViewById(R.id.buttonDot);
        buttonClear = findViewById(R.id.buttonClear);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonSub = findViewById(R.id.buttonSub);
        buttonMul = findViewById(R.id.buttonMul);
        buttonDiv = findViewById(R.id.buttonDiv);
        buttonSum = findViewById(R.id.buttonSum);
        edit1 = findViewById(R.id.edit1);


        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit1.setText(edit1.getText() + "0");
                calOperation = false;
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit1.setText(edit1.getText() + "1");
                calOperation = false;
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit1.setText(edit1.getText() + "2");
                calOperation = false;
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit1.setText(edit1.getText() + "3");
                calOperation = false;
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit1.setText(edit1.getText() + "4");
                calOperation = false;
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit1.setText(edit1.getText() + "5");
                calOperation = false;
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit1.setText(edit1.getText() + "6");
                calOperation = false;
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit1.setText(edit1.getText() + "7");
                calOperation = false;
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit1.setText(edit1.getText() + "8");
                calOperation = false;
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit1.setText(edit1.getText() + "9");
                calOperation = false;
            }
        });

        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempString = edit1.getText() + "";
                boolean dotIncluded = false;
                for(int i = 0; i < tempString.length(); i++) {
                    if (tempString.charAt(i) == '.') {
                        dotIncluded = true;
                    }
                }
                if (dotIncluded ==  false) {
                    edit1.setText(edit1.getText() + ".");
                }
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit1.setText("");
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (calOperation == false) { //proof if operation is clicked more then once to prevent a crash
                    calculateTempResult(edit1);
                    calAdd = true; // stores which operator was clicked
                }
                calOperation = true;
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (calOperation == false) { //proof if operation is clicked more then once to prevent a crash
                    calculateTempResult(edit1);
                    calSub = true; // stores which operator was clicked
                }
                calOperation = true;

            }
        });

        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (calOperation == false) { //proof if operation is clicked more then once to prevent a crash
                    calculateTempResult(edit1);
                    calMul = true; // stores which operator was clicked
                }
                calOperation = true;

            }
        });

        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (calOperation == false) { //proof if operation is clicked more then once to prevent a crash
                    calculateTempResult(edit1);
                    calDiv = true; // stores which operator was clicked
                }
                calOperation = true;

            }
        });

        buttonSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value2 = readEditText(edit1);

                // last calculation
                if(calAdd) {
                    valueSum = value1 + value2;
                    calAdd = false;
                } else if(calSub) {
                    valueSum = value1 - value2;
                    calSub = false;
                } else if(calMul) {
                    valueSum = value1 * value2;
                    calMul = false;
                } else if(calDiv) {
                    valueSum = value1 / value2;
                    calDiv = false;
                } else {
                    valueSum = value2; // if no calculation operation was clicked
                }

                edit1.setText(valueSum + "");

                // reset values
                value1 = null;
                value2 = null;
            }
        });



    }
}