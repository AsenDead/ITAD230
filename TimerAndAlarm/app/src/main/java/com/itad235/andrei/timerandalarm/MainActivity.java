package com.itad235.andrei.timerandalarm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected void onTimerSendButtonClick(View view) {
        Intent intent = new Intent(this, TimerActivity.class);
        startActivity(intent);
    }

    protected void onAlarmSendButtonClick(View view) {
        Intent intent = new Intent(this, AlarmActivity.class);
        startActivity(intent);
    }

    protected void onSearchSendButtonClick(View view) {
        Intent intent = new Intent(this, SearchActivity.class);
        startActivity(intent);
    }
}
