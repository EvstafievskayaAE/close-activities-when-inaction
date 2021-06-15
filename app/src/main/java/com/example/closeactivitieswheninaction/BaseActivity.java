package com.example.closeactivitieswheninaction;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {
    public static final long DISCONNECT_TIMEOUT = 10000;//время бездействия пользователя
    private Handler handler; //обработчик потока
    private Runnable runnable; // объект, запускающий переход на страницу авторизации

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeHandler();
    }

    protected void initializeHandler(){
        handler = new Handler();
        runnable = () -> {
            Intent intent = new Intent(getApplicationContext(), AuthorizationActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        };
        startHandler();
    }

    //запуск страницы авторизации через указанное время бездействия
    public void startHandler() {
        handler.postDelayed(runnable, DISCONNECT_TIMEOUT);
    }

    //прекращение отсчета времени бездействия
    public void stopHandler() {
        handler.removeCallbacks(runnable);
    }

    //отслеживание действий пользователя
    @Override
    public void onUserInteraction() {
        super.onUserInteraction();
        stopHandler();
        startHandler();
    }

    @Override
    protected void onResume() {
        super.onResume();
        startHandler();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopHandler();
    }
}
