package com.example.arihant.state_of_app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import android.widget.ToggleButton;


public class MyActivity extends ActionBarActivity {
public static final String TAG="Arihant_message";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        Log.i(TAG,"Oncreate");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"OnPause");
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"OnResume");
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"OnStart");
        }


    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"OnStop");
        }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG,"OnRestart");
        }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    public void sayHello(View v)
    {
        ToggleButton tb=(ToggleButton)findViewById(R.id.toggle_button);
        String s=tb.getText().toString();
        Toast.makeText(this,s,Toast.LENGTH_LONG).show();
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
