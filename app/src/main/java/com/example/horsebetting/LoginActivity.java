package com.example.horsebetting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.horsebetting.entity.UserManagement;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private UserManagement userManagement = UserManagement.getInstance();

    private EditText username;
    private EditText password;
    private TextView tvNotAccountYet;
    private Button btnSignIn;


    private final String REQUIRE = "Require";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.txt_username);
        password = findViewById(R.id.txt_password);
        tvNotAccountYet = findViewById(R.id.tv_not_account_yet);
        btnSignIn = findViewById(R.id.btn_sign_in);


        tvNotAccountYet.setOnClickListener(this);
        btnSignIn.setOnClickListener(this);
    }

    private boolean checkInput() {
        if (TextUtils.isEmpty(username.getText().toString())) {
            username.setError(REQUIRE);
            return false;
        }

        if (TextUtils.isEmpty(password.getText().toString())) {
            password.setError(REQUIRE);
            return false;
        }

        return true;
    }

    private void signIn() {
        if (!checkInput()) {
            return;
        }

        if (!userManagement.login(username.getText().toString(), password.getText().toString())) {
            Toast.makeText(this, "Invalid User name or password", Toast.LENGTH_LONG).show();
            return;
        }

        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
        finish();


    }
    private void signUpForm() {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
        finish();
    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_sign_in) {
            signIn();
        } else if (view.getId() == R.id.tv_not_account_yet) {
            signUpForm();
        }
    }
}