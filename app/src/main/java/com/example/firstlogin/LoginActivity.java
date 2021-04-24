package com.example.firstlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    private String[] arr = new String[2];
    private EditText benutzername;
    private EditText password;
    private Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        try{
            String[] temp = getIntent().getStringArrayExtra("data");
            arr[0] = temp[0];
            arr[1] = temp[1];
        } catch (Exception e) {
            e.printStackTrace();

        }
        benutzername = (EditText)findViewById((R.id.etLoginName));
        password = (EditText)findViewById(R.id.etPasswordLogin);
        login = findViewById((R.id.btnLogin1));
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(benutzername.getText().toString(),password.getText().toString());
            }
        });
    }
    public void check(String username, String password) {
        if(username.equals(arr[0]) && password.equals(arr[1])) {
            Intent intent = new Intent(LoginActivity.this, AccessGrantedActivity.class);
            intent.putExtra("data",new String[]{arr[0],arr[1]});
            startActivity(intent);

        }
        else {
            Intent intent1 = new Intent(LoginActivity.this, AccessDeniedActivity.class);
            intent1.putExtra("data",new String[]{arr[0],arr[1]});
            startActivity(intent1);
        }
    }
}