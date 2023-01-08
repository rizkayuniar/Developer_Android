package id.ac.poliban.mi.vb.e020320055.standup3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private NotificationManager mNotificationManager;
    private static final int NOTIFICATION_ID = 0;
    private static final String PRIMARY_CHANNEL_ID =
            "primary_notification_channel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Rizka - Stand Up 3!");

        ToggleButton alarmToggle = findViewById(R.id.alarmToggle);

        mNotificationManager = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);

        Intent notifyIntent = new Intent(this, AlarmReceiver.class);
        PendingIntent notifyPendingIntent = PendingIntent.getBroadcast
                (this, NOTIFICATION_ID, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        boolean alarmUp = (PendingIntent.getBroadcast(this, NOTIFICATION_ID, notifyIntent,
                PendingIntent.FLAG_NO_CREATE) != null);
        alarmToggle.setChecked(alarmUp);

        alarmToggle.setOnCheckedChangeListener(
                (compoundButton, isChecked) -> {
                    String toastMessage;
                    if (isChecked) {
                        long repeatInterval = AlarmManager.INTERVAL_FIFTEEN_MINUTES;
                        long triggerTime = SystemClock.elapsedRealtime()
                                + repeatInterval;

                        if (alarmManager != null) {
                            alarmManager.setInexactRepeating
                                    (AlarmManager.ELAPSED_REALTIME_WAKEUP,
                                            triggerTime, repeatInterval, notifyPendingIntent);
                        }
                        toastMessage = getString(R.string.alarm_on_toast);
                    } else {
                        mNotificationManager.cancelAll();

                        if (alarmManager != null) {
                            alarmManager.cancel(notifyPendingIntent);
                        }
                        toastMessage = getString(R.string.alarm_off_toast);

                    }

                    Toast.makeText(MainActivity.this, toastMessage, Toast.LENGTH_SHORT).show();
                });

        createNotificationChannel();
    }

    public void createNotificationChannel() {
        mNotificationManager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        if (android.os.Build.VERSION.SDK_INT >=
                android.os.Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel
                    (PRIMARY_CHANNEL_ID,
                            "Stand up notification",
                            NotificationManager.IMPORTANCE_HIGH);

            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.enableVibration(true);
            notificationChannel.setDescription
                    ("Notifies every 15 minutes to stand up and walk");
            mNotificationManager.createNotificationChannel(notificationChannel);
        }
    }
}