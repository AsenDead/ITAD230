package com.itad235.andrei.timerandalarm;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.view.View;

public class AlarmActivity extends AppCompatActivity {
    private static final String MESSAGE = "An alarm is going off";
    private EditText hoursView;
    private EditText minutesView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        hoursView = (EditText) findViewById(R.id.hours);
        minutesView = (EditText) findViewById(R.id.minutes);
    }

    protected void createAlarm(View view) {

        int hours = getHours();
        int minutes = getMinutes();

        if(hours >= 23 || minutes >= 60) {
            return;
        }

        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, MESSAGE)
                .putExtra(AlarmClock.EXTRA_HOUR, hours)
                .putExtra(AlarmClock.EXTRA_MINUTES, minutes)
                .putExtra(AlarmClock.EXTRA_SKIP_UI, true);
        if(intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private int getHours() {
        return Integer.parseInt(hoursView.getText().toString());
    }

    private int getMinutes() {
        return Integer.parseInt(minutesView.getText().toString());
    }


}
