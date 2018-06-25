package com.example.arihant.notification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MyActivity extends Activity {
Button notify;
EditText text1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        text1=(EditText)findViewById(R.id.text1);
        notify=(Button)findViewById(R.id.notify);
        notify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str=text1.getText().toString();
                Intent intent=new Intent(MyActivity.this,MyActivity2Activity.class);
                intent.putExtra("name",str);
                PendingIntent pendingintent=PendingIntent.getActivity(getApplicationContext(),0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                Notification n  = new Notification.Builder(getApplicationContext())
                        .setContentTitle("hello")
                        .setContentText("Subject")
                        .setSmallIcon(R.drawable.ic_launcher)
                        .setContentIntent(pendingintent)
                        .setAutoCancel(true)
                        .addAction(R.drawable.ic_launcher, "Call", pendingintent)
                        .addAction(R.drawable.ic_launcher, "More", pendingintent)
                        .addAction(R.drawable.ic_launcher, "And more", pendingintent).build();


                NotificationManager notificationManager =
                        (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

                notificationManager.notify(0, n);


            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
