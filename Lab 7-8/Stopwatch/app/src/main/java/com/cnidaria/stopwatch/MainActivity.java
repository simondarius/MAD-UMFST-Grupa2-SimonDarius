package com.cnidaria.stopwatch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import java.text.DecimalFormat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private TextView timeTV;
    private Button startStopButton;
    private Button resetButton;
    private boolean timerStarted = false;
    private Intent serviceIntent;
    private double time = 0.0;
    private final BroadcastReceiver updateTime = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            System.out.println("In update time main activity!");
            time = intent.getDoubleExtra(TimerService.TIME_EXTRA, 0.0);
            timeTV.setText(getTimeStringFromDouble(time));
            System.out.println("Finished updating time!");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timeTV = findViewById(R.id.timeTV);
        startStopButton = findViewById(R.id.startStopButton);
        resetButton = findViewById(R.id.resetButton);

        startStopButton.setOnClickListener(v -> startStopTimer());
        resetButton.setOnClickListener(v -> resetTimer());
        try {
            serviceIntent = new Intent(getApplicationContext(), TimerService.class);
            LocalBroadcastManager.getInstance(this).registerReceiver(updateTime, new IntentFilter(TimerService.TIMER_UPDATED));
        }catch (Exception e){
            System.out.println(e.toString());
        }
        }

    private void resetTimer() {
        stopTimer();
        time = 0.0;
        timeTV.setText(getTimeStringFromDouble(time));
    }

    private void startStopTimer() {
        if (timerStarted)
            stopTimer();
        else
            startTimer();
    }

    private void startTimer() {
        serviceIntent.putExtra(TimerService.TIME_EXTRA, time);
        startService(serviceIntent);
        startStopButton.setText("Stop");

        timerStarted = true;
    }

    private void stopTimer() {
        stopService(serviceIntent);
        startStopButton.setText("Start");

        timerStarted = false;
    }

    private String getTimeStringFromDouble(double time) {
        DecimalFormat formatter = new DecimalFormat("00");
        int resultInt = (int) Math.round(time);
        int hours = resultInt % 86400 / 3600;
        int minutes = resultInt % 86400 % 3600 / 60;
        int seconds = resultInt % 86400 % 3600 % 60;
        return makeTimeString(formatter.format(hours), formatter.format(minutes), formatter.format(seconds));
    }

    private String makeTimeString(String hour, String min, String sec) {
        return hour + ":" + min + ":" + sec;
    }
}
