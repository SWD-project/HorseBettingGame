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

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private UserManagement userManagement = UserManagement.getInstance();

    private EditText username;
    private EditText password;
    private EditText confirmPassword;
    private TextView tvAlreadyAccount;
    private Button btnSignUp;

    private final String REQUIRE = "Require";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = findViewById(R.id.txt_username);
        password = findViewById(R.id.txt_password);
        confirmPassword = findViewById(R.id.txt_confirm_password);
        tvAlreadyAccount = findViewById(R.id.tv_already_account);
        btnSignUp = findViewById(R.id.btn_sign_up);

        tvAlreadyAccount.setOnClickListener(this);
        btnSignUp.setOnClickListener(this);
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
        if (TextUtils.isEmpty(confirmPassword.getText().toString())) {
            confirmPassword.setError(REQUIRE);
            return false;
        }
        if (!TextUtils.equals(password.getText().toString(), confirmPassword.getText().toString())) {
            Toast.makeText(this, "Password are not match", Toast.LENGTH_LONG).show();
            return false;
        }

        return true;
    }

    private void signIn() {
        if (!checkInput()) {
            return;
        }
        boolean isCreated = userManagement.signup(username.getText().toString(), password.getText().toString());

        if (isCreated == false) {
            Toast.makeText(this, "User name is existed!", Toast.LENGTH_LONG).show();
        }

        Toast.makeText(this, "register success!", Toast.LENGTH_LONG).show();

    }
    private void signInForm() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_sign_up) {
            signIn();
        } else if (view.getId() == R.id.tv_already_account) {
            signInForm();
        }
    }
}