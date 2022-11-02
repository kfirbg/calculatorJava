package com.example.myfirstprogrem;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView result;
    char op;
    int num1,num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = findViewById(R.id.textViewResult);
    }

    public void buttonFuncNumber(View view) {
        if(!(view instanceof Button))
            return;
        Button b = (Button) view;
        String str =b.getText().toString();
        result.append(str);
    }

    public void buttonFuncOperator(View view) {
        if(!(view instanceof Button))
            return;
        Button b = (Button) view;
        op =b.getText().toString().charAt(0);
        num1=Integer.parseInt(result.getText().toString());
        result.setText("");
    }

    @SuppressLint("SetTextI18n")
    public void buttonFuncEqual(View view) {
        double res = 0;
        if(!(view instanceof Button))
            return;
        num2=Integer.parseInt(result.getText().toString());
        switch (op){
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num1 - num2;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                if(num2 == 0)
                    result.setText("Division by zero is not allowed!");
                res = num1 / num2;
                break;
        }
        result.setText(String.valueOf(res));
    }

    public void buttonFunClear(View view) {
        result.setText("");
    }
}