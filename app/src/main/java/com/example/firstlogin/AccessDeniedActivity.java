package com.example.firstlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class AccessDeniedActivity extends AppCompatActivity {

    private Button submit;
    private TextView generatedCode;
    private EditText enteredCode;
    private int randomNumber;
    private String[] arr = new String[2];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_access_denied);
        try{
            String[] temp = getIntent().getStringArrayExtra("data");
            arr[0] = temp[0];
            arr[1] = temp[1];
        } catch (Exception e) {
            e.printStackTrace();

        }
        submit = findViewById(R.id.submitButton);
        generatedCode = (TextView)findViewById(R.id.code);
        enteredCode = (EditText)findViewById(R.id.enteredCode);
        Random r = new Random();
        this.randomNumber = r.nextInt(10000);
        generatedCode.setText("" + randomNumber);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkNumber();
                randomNumber = generateNewNumber();
            }
        });
    }
    public int generateNewNumber() {
        Random r = new Random();
        randomNumber = r.nextInt(10000);
        generatedCode.setText("" + randomNumber);
        return randomNumber;
    }

    public void checkNumber() {
        if(randomNumber == Integer.parseInt(enteredCode.getText().toString()) && enteredCode.getText().toString() != null){
            Intent intent = new Intent(AccessDeniedActivity.this,LoginActivity.class);
            intent.putExtra("data",new String[]{arr[0],arr[1]});
            startActivity(intent);
        }

    }
}