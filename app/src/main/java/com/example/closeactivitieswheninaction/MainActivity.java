package com.example.closeactivitieswheninaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private Button firstScreenButton, secondScreenButton, thirdScreenButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstScreenButton = findViewById(R.id.firstScreenButton);
        secondScreenButton = findViewById(R.id.secondScreenButton);
        thirdScreenButton = findViewById(R.id.thirdScreenButton);

        firstScreenButton.setOnClickListener(this);
        secondScreenButton.setOnClickListener(this);
        thirdScreenButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.firstScreenButton:
                startActivity(new Intent(this, FirstScreenActivity.class));
                break;
            case R.id.secondScreenButton:
                startActivity(new Intent(this, SecondScreenActivity.class));
                break;
            case R.id.thirdScreenButton:
                startActivity(new Intent(this, ThirdScreenActivity.class));
                break;

        }
    }
}