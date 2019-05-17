package com.filano.sikemastekber.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.filano.sikemastekber.R;
import com.filano.sikemastekber.Response.LoginResponse;
import com.filano.sikemastekber.Retrofit.ApiClient;
import com.filano.sikemastekber.Retrofit.ApiInterface;
import com.filano.sikemastekber.SessionManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private SessionManager sessionManager;
    private ApiInterface api;
    private EditText etNoIdentitas, etPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sessionManager = new SessionManager(this);
        api = ApiClient.getInstance().create(ApiInterface.class);

        if (sessionManager.isLogin()) {
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        }

        etNoIdentitas = findViewById(R.id.etNoIdentitas);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(this);
    }

    public void login(String no_identitas, String password) {
        api.login(no_identitas, password).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                String status = response.body().getStatus();
                if (status.equals("success")) {
                    String token_type = response.body().getData().getToken_type();
                    String token = response.body().getData().getToken();
                    String no_identitas = response.body().getData().getUser().getNo_identitas();
                    String name = response.body().getData().getUser().getName();
                    String type = response.body().getData().getUser().getType();

                    sessionManager.login(no_identitas, name, type, token, token_type);
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finish();
                } else if (status.equals("error")) {
                    Toast.makeText(LoginActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Failed: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogin:
                String no_identitas = etNoIdentitas.getText().toString();
                String password = etPassword.getText().toString();

                if (!no_identitas.isEmpty() && !password.isEmpty()) {
                    login(no_identitas, password);
                }

                break;
        }
    }
}
