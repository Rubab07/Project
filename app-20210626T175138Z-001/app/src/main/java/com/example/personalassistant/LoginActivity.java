package com.example.personalassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.personalassistant.model.LoginBody;
import com.example.personalassistant.model.LoginResponse;

import java.lang.reflect.Member;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    public EditText email, password;
    Button loginbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        password = (EditText) findViewById(R.id.password);
        email = (EditText) findViewById(R.id.email);
        loginbtn = (Button) findViewById(R.id.loginbtn);




        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email = email.getText().toString().trim();
                String Password = password.getText().toString().trim();
                if (TextUtils.isEmpty(Email)) {
                    Toast.makeText(LoginActivity.this, "Please Enter Email", Toast.LENGTH_SHORT).show();
                }
                if (TextUtils.isEmpty(Password)) {
                    Toast.makeText(LoginActivity.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                }
                addlogin();

                //  startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

    }


    public void addlogin() {

        LoginBody login = new LoginBody();
        login.setUserId(email.getText().toString());
        login.setUserPassword(password.getText().toString());

        final Call<LoginResponse> apiforlogin = RestClient.getInstance().getApiServices()
                .userLogin(login);
        apiforlogin.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(LoginActivity.this, " successfully login all post Success", Toast.LENGTH_SHORT).show();

                    Log.e("responsecheck", response.body().getUserId());
                    Log.e("responsecheck", response.body().getUserName());
                    Log.e("responsecheck", response.body().getUserPassword());
                    Log.e("responsecheck", response.body().getUserMobile());

                    Singleton.userID = response.body().getUserId();



                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);

                } else {
                    Toast.makeText(LoginActivity.this, "Response Not Succesful", Toast.LENGTH_SHORT).show();
                    Log.e("responseerror", response.message());
                }

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Failed!", Toast.LENGTH_SHORT).show();
            }

        });
    }

    }

