package com.cnidaria.stopwatch;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Binder;
import java.util.Timer;
import java.util.TimerTask;

public class TimerService extends Service {
    private final IBinder binder = new LocalBinder();
    private Timer timer;

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        System.out.println("Service start command issued!");
        if (intent != null) {
            System.out.println("Null intent");
            double time = intent.getDoubleExtra(TIME_EXTRA, 0.0);
            startTimer(time);

        }
        System.out.println("Finishing on start command!");
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        stopTimer();
        super.onDestroy();
    }

    private void startTimer(double time) {
        System.out.println("Starting timer!");
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimeTask(time), 0, 1000);
    }

    private void stopTimer() {
        System.out.println("Stopping timer!");
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }

    private class TimeTask extends TimerTask {
        private double time;

        public TimeTask(double time) {
            this.time = time;
        }

        @Override
        public void run() {
            Intent intent = new Intent(TIMER_UPDATED);
            time++;
            intent.putExtra(TIME_EXTRA, time);
            System.out.println("Sending broadcast!!!");
            sendBroadcast(intent);
            System.out.println("Finished sending!");
        }
    }

    public class LocalBinder extends Binder {
        TimerService getService() {
            return TimerService.this;
        }
    }

    public static final String TIMER_UPDATED = "timerUpdated";
    public static final String TIME_EXTRA = "timeExtra";
}
