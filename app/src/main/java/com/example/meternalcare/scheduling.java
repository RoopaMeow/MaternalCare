package com.example.meternalcare;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.meternalcare.databinding.ActivityMainBinding;
import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimeFormat;

import java.util.Calendar;

public class scheduling extends AppCompatActivity {
    private ActivityMainBinding binding;
    private MaterialTimePicker timePicker;
    private Calendar[] calendars; // An array to store multiple calendars
    private AlarmManager alarmManager;
    private PendingIntent[] pendingIntents; // An array to store multiple pending intents
    TextView[] selectTimes; // An array to store multiple TextViews
    Button[] setAlarms; // An array to store multiple "Set Alarm" buttons
    Button cancelAlarm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scheduling);
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        createNotificationChannel();

        // Initialize arrays for multiple alarms
        calendars = new Calendar[3];
        pendingIntents = new PendingIntent[3];
        selectTimes = new TextView[3];
        setAlarms = new Button[3];

        // Initialize views and buttons
        for (int i = 0; i < 3; i++) {
            selectTimes[i] = findViewById(getResources().getIdentifier("selectTime" + (i + 1), "id", getPackageName()));
            setAlarms[i] = findViewById(getResources().getIdentifier("setalarm" + (i + 1), "id", getPackageName()));
        }
        cancelAlarm = findViewById(R.id.cancelalarm);

        for (int i = 0; i < 3; i++) {
            final int alarmIndex = i; // To differentiate between alarms in the click listeners

            selectTimes[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    timePicker = new MaterialTimePicker.Builder()
                            .setTimeFormat(TimeFormat.CLOCK_12H)
                            .setHour(12)
                            .setMinute(0)
                            .setTitleText("Select Time")
                            .build();

                    timePicker.addOnPositiveButtonClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Calendar calendar = Calendar.getInstance();
                            calendar.set(Calendar.HOUR_OF_DAY, timePicker.getHour());
                            calendar.set(Calendar.MINUTE, timePicker.getMinute());
                            calendar.set(Calendar.SECOND, 0);
                            calendar.set(Calendar.MILLISECOND, 0);
                            calendars[alarmIndex] = calendar; // Store the calendar in the array
                            selectTimes[alarmIndex].setText(formatTime(timePicker.getHour(), timePicker.getMinute()));
                        }
                    });

                    timePicker.show(getSupportFragmentManager(), "timePicker");
                }
            });

            setAlarms[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (calendars[alarmIndex] != null) {
                        alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                        Intent intent = new Intent(scheduling.this, AlarmReceiver.class);
                        pendingIntents[alarmIndex] = PendingIntent.getBroadcast(scheduling.this, alarmIndex, intent, 0);
                        alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendars[alarmIndex].getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntents[alarmIndex]);
                        Toast.makeText(scheduling.this, "Alarm " + (alarmIndex + 1) + " Set", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(scheduling.this, "Please select a time for Alarm " + (alarmIndex + 1) + " first", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        cancelAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < 3; i++) {
                    if (pendingIntents[i] != null) {
                        if (alarmManager == null) {
                            alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                        }
                        alarmManager.cancel(pendingIntents[i]);
                        Toast.makeText(scheduling.this, "Alarm " + (i + 1) + " Canceled", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "akchannel";
            String desc = "Channel for Alarm Manager";
            int imp = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel = new NotificationChannel("androidknowledge", name, imp);
            channel.setDescription(desc);

            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

            notificationManager.createNotificationChannel(channel);
        }
    }

    private String formatTime(int hour, int minute) {
        if (hour > 12) {
            return String.format("%02d:%02d PM", hour - 12, minute);
        } else {
            return String.format("%02d:%02d AM", hour, minute);
        }
    }
}