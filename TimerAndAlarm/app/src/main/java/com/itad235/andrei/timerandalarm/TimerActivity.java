package com.itad235.andrei.timerandalarm;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class TimerActivity extends AppCompatActivity {
    EditText seconds;
    EditText message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        seconds = (EditText) findViewById(R.id.seconds);
        message = (EditText) findViewById(R.id.message);
    }

    protected void createTimer(View view) {
        if(seconds.getText().toString().equals("")) {
            return;
        }

        Intent intent = new Intent(AlarmClock.ACTION_SET_TIMER)
                .putExtra(AlarmClock.EXTRA_MESSAGE, getMessage())
                .putExtra(AlarmClock.EXTRA_LENGTH, getSeconds())
                .putExtra(AlarmClock.EXTRA_SKIP_UI, true);
        if(intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private String getMessage() {
        return message.getText().toString();
    }

    private int getSeconds() {
        return Integer.parseInt(seconds.getText().toString());
    }

}
