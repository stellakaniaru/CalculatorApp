package com.example.android.calculatorapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {


    TextView text1;
    TextView text2;
    String disp = "";
    String answ = "";
    String currentOp = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1 = (TextView) findViewById(R.id.text1);
        text2 = (TextView) findViewById(R.id.text2);
        text1.setText(disp);
        text2.setText(answ);
    }

    public void UpdateScreen(){
        text1.setText(disp);
        text2.setText(answ);
    }
    public void ButtonClick(View v){
        Button a = (Button) v;
        disp += a.getText();
        UpdateScreen();
    }
    public void BtnOperatorClick(View v){
        Button a = (Button) v;
        disp += a.getText();
        currentOp = a.getText().toString();
        UpdateScreen();
    }
    public void Clear(View v){
        disp = "";
        currentOp = "";
        answ = "";
        UpdateScreen();
    }
    public void Delete(View v){
        String text = text1.getText().toString();
        disp = text.substring(0, text.length() - 1);
        UpdateScreen();
    }
    public float doOperations(String n1, String n2, String op){
        switch (op){
            case "+":
                return Float.valueOf(n1) + Float.valueOf(n2);
            case "-":
                return Float.valueOf(n1) - Float.valueOf(n2);
            case "*":
                return Float.valueOf(n1) * Float.valueOf(n2);
            case "/":
                try{
                    return Float.valueOf(n1) / Float.valueOf(n2);
                }
                catch (Exception e){
                    Log.d("Calc", e.getMessage());
                }

            default:
                return 0;
        }
    }
    public void Equals(View v){
        String [] ops = disp.split(Pattern.quote(currentOp));
        if (ops.length < 2){
            return;
        }
        Float results = doOperations(ops[0], ops[1], currentOp);
        text2.setText(answ + String.valueOf(results));
    }



}
