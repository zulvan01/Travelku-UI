package com.dicoding.assosiate.travelku;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

public class LoadingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        findViewById(R.id.buttonNotif).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showwarningDialog();
                showNotificationWithImage();

            }
        });
    }
    private void showwarningDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(LoadingActivity.this, R.style.AlertDialogTheme);
        View view = LayoutInflater.from(LoadingActivity.this).inflate(
                R.layout.layout_warning_dialog,
                (ConstraintLayout) findViewById(R.id.layoutDialogContainer)
        );
        builder.setView(view);
        ((TextView) view.findViewById(R.id.textTitle2)).setText(getResources().getString(R.string.nyalakan_notifikasi));
        ((TextView) view.findViewById(R.id.textMessage)).setText(getResources().getString(R.string.dummy_text));
        ((Button) view.findViewById(R.id.buttonaction)).setText(getResources().getString(R.string.button_oke));
        ((Button) view.findViewById(R.id.buttonaction2)).setText(getResources().getString(R.string.no));
        ((ImageView) view.findViewById(R.id.imagewarning)).setImageResource(R.drawable.ic_info_outline);

        final AlertDialog alertDialog = builder.create();

        view.findViewById(R.id.buttonaction).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
                Intent intent = new Intent(LoadingActivity.this, DashboardActivity.class);
                startActivity(intent);
                Toast.makeText(LoadingActivity.this, "Yes", Toast.LENGTH_SHORT).show();
            }
        });

        view.findViewById(R.id.buttonaction2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
                Toast.makeText(LoadingActivity.this, "No", Toast.LENGTH_SHORT).show();
            }
        });
        if (alertDialog.getWindow() != null) {
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        alertDialog.show();
    }

    @SuppressLint("StaticFieldLeak")
    private void showNotificationWithImage(){
        new AsyncTask<String, Void, Bitmap>(){
            @Override
            protected Bitmap doInBackground(String... strings) {
                InputStream inputStream;
                try {
                    URL url = new URL(strings[0]);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setDoInput(true);
                    connection.connect();
                    inputStream = connection.getInputStream();
                    return BitmapFactory.decodeStream(inputStream);

                } catch (Exception ignored) {

                }
                return null;
            }

            @Override
            protected void onPostExecute(Bitmap bitmap) {
                ShowNotification(bitmap);
            }
        }.execute("https://img-o.okeinfo.net/content/2020/03/06/320/2179342/maskapai-penerbangan-ini-bangkrut-karena-virus-korona-6MvyOkG80g.jpg"); // URL Image.
    }

    private void ShowNotification(Bitmap bitmap) {
        int notificationId = new Random().nextInt(100);
        String channelId = "notification_channel_2";

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        Intent intent = new Intent(getApplicationContext(), NotifikasiActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        PendingIntent pendingIntent = PendingIntent.getActivity(
                getApplicationContext(),
                0,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT
        );

        NotificationCompat.Builder builder = new NotificationCompat.Builder(
                getApplicationContext(), channelId
        );

        builder.setSmallIcon(R.drawable.ic_notifications);
        builder.setDefaults(NotificationCompat.DEFAULT_ALL);
        builder.setContentTitle("What Is Lorem Ipsum");
        builder.setContentText("Notification Activated");

        //builder.setStyle(new NotificationCompat.BigTextStyle().bigText("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."));
        builder.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmap));

        builder.setContentIntent(pendingIntent);
        builder.setAutoCancel(true);
        builder.setPriority(NotificationCompat.PRIORITY_MAX);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            if (notificationManager != null && notificationManager.getNotificationChannel(channelId) == null) {
                NotificationChannel notificationChannel = new NotificationChannel(
                        channelId,
                        "Notification Channel 1",
                        NotificationManager.IMPORTANCE_HIGH
                );
                notificationChannel.setDescription("This notification channel is used to notify user");
                notificationChannel.enableVibration(true);
                notificationChannel.enableLights(true);
                notificationManager.createNotificationChannel(notificationChannel);
            }
        }
        Notification notification = builder.build();
        if (notificationManager != null) {
            notificationManager.notify(notificationId, notification);
        }

    }
}
