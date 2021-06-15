package com.example.closeactivitieswheninaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class AuthorizationActivity extends BaseActivity implements View.OnClickListener {

    private EditText loginEditText, passwordEditText;
    private Button loginButton;
    static final String LOGIN = "admin";
    static final String PASSWORD = "admin";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization);

        loginEditText = findViewById(R.id.loginEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(this);

    }

    private void startMainActivity(){
        Intent intent = new Intent(new Intent(this, MainActivity.class));
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        if (loginEditText.getText().toString().equals(LOGIN)
                && passwordEditText.getText().toString().equals(PASSWORD)) {
            startMainActivity();
        }
    }
}
