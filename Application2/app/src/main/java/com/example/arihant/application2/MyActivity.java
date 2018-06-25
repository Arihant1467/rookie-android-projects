package com.example.arihant.application2;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MyActivity extends ActionBarActivity {
    public  static String EXTRA_MESSAGE = "com.example.Application2.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        Button myButton = (Button) findViewById(R.id.send_button);
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.my, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.sync:
                startActivity(new Intent(Settings.ACTION_SYNC_SETTINGS));

                return true;
            case R.id.action_settings:
                Intent intent=new Intent(Settings.ACTION_SETTINGS);
                intent.addCategory(Intent.CATEGORY_LAUNCHER);
                startActivity(intent);
                return true;
            default:
        return super.onOptionsItemSelected(item);}
    }
    public void send_message(View view)
    {
       Intent intent=new Intent(this,DisplaySendMessage.class);
        EditText editText=(EditText)findViewById(R.id.edit_text);
        String message=editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE,message);
        startActivity(intent);
    }
}
