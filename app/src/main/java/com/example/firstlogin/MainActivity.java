package com.example.firstlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText benutzername;
    private EditText password;
    private Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        benutzername = (EditText)findViewById((R.id.etName));
        password = (EditText)findViewById(R.id.etPassword1);
        register = (Button)findViewById((R.id.btnRegister));
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register(benutzername.getText().toString(), password.getText().toString());
            }
        });
    }
    private void register(String userName, String userPassword) {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        intent.putExtra("data",new String[]{userName,userPassword});
        startActivity(intent);
    }

    public EditText getBenutzername() {
        return benutzername;
    }

    public EditText getPassword() {
        return password;
    }

}