package com.example.dell.demoandroidnotification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private NotificationCompat.Builder notBuilder;
    private static final int MY_NOTIFICATION_ID = 12345;
    private static final int MY_REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.notBuilder = new NotificationCompat.Builder(this);

        this.notBuilder.setAutoCancel(true);
    }

    public void notButtonClicked(View view) {

        this.notBuilder.setSmallIcon(R.mipmap.ic_launcher);
        this.notBuilder.setTicker("Ticker");

        this.notBuilder.setWhen(System.currentTimeMillis() + 10*1000);
        this.notBuilder.setContentTitle("Thông báo mới!!");
        this.notBuilder.setContentText("Demo Notification");

        Intent intent = new Intent(this, MainActivity.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, MY_REQUEST_CODE, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        this.notBuilder.setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager)this.getSystemService(Context.NOTIFICATION_SERVICE);
        Notification notification = notBuilder.build();
        notificationManager.notify(MY_NOTIFICATION_ID,notification);


    }
}
