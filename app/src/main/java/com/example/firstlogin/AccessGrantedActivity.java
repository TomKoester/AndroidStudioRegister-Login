package com.example.firstlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AccessGrantedActivity extends AppCompatActivity {

    private TextView text;
    private EditText newPassword;
    private Button changePassword;
    private String[] arr = new String[2];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_access_granted);
        try{
            String[] temp = getIntent().getStringArrayExtra("data");
            arr[0] = temp[0];
            arr[1] = temp[1];
        } catch (Exception e) {
            e.printStackTrace();
        }
        newPassword = findViewById(R.id.etNewPassword);
        changePassword = findViewById(R.id.btnChangePassword);
        text = findViewById(R.id.etUsernameHello);
        text.setText(arr[0]);
        changePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arr[1] = newPassword.getText().toString();
                Intent intent = new Intent(AccessGrantedActivity.this,LoginActivity.class);
                intent.putExtra("data",new String[]{arr[0],arr[1]});
                startActivity(intent);
            }
        });

    }
}