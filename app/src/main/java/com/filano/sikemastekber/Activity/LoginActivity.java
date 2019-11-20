package com.filano.sikemastekber.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.filano.sikemastekber.NotificationHelper;
import com.filano.sikemastekber.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etNoIdentitas, etPassword;
    private Button btnLogin;
    private NotificationHelper notificationHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etNoIdentitas = findViewById(R.id.etNRP);
        etPassword = findViewById(R.id.etPass);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(this);
    }

    public void login(String nrp, String password){
        String username = "5116100122";
        String pass = "122";
        if(nrp.equals(username)&&password.equals(pass)){
            Toast.makeText(LoginActivity.this,"Login Success", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(LoginActivity.this, MainActivity.class));

            notificationHelper = new NotificationHelper(this);
            notificationHelper.createNotification("Rekayasa Kebutuhan E", "dimulai dalam 30 menit");

        }else Toast.makeText(LoginActivity.this,"Username & Password Not Match", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogin:
                String nrp = etNoIdentitas.getText().toString();
                String password = etPassword.getText().toString();

                if (!nrp.isEmpty() && !password.isEmpty()) {
                    login(nrp, password);
                }

                break;
        }
    }
}
