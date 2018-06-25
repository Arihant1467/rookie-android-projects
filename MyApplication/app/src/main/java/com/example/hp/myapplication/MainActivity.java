package com.example.hp.myapplication;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.accessibility.AccessibilityManager;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    SeekBar seek_red,seek_blue,seek_green;
    TextView rgb_show;
    int red,green,blue;
    LinearLayout l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        l=(LinearLayout)findViewById(R.id.linear_layout_1);
        seek_red=(SeekBar)findViewById(R.id.seekBar_red);
        seek_green=(SeekBar)findViewById(R.id.seekBar_green);
        seek_blue=(SeekBar)findViewById(R.id.seekBar_blue);
        rgb_show=(TextView)findViewById(R.id.rgb_value);
        red=green=blue=0;

        seek_red.setMax(255);
        seek_green.setMax(255);
        seek_blue.setMax(255);
        l.setBackgroundColor(Color.rgb(red,green,blue));
        seek_red.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                red=seek_red.getProgress();

                rgb_show.setText("rgb("+red+","+green+","+blue+")");
                l.setBackgroundColor(Color.rgb(red,green,blue));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {

            }
        });

        //**************************************************************************************
        seek_green.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                //red=seek_red.getProgress()/10;
               // blue=seek_blue.getProgress()/10;
                green=seek_green.getProgress();
                l.setBackgroundColor(Color.rgb(red,green,blue));
                rgb_show.setText("rgb("+red+","+green+","+blue+")");

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {

            }
        });
        //***************************************************************************************
        seek_blue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {

                blue=seek_blue.getProgress();
                l.setBackgroundColor(Color.rgb(red,green,blue));
                rgb_show.setText("rgb("+red+","+green+","+blue+")");

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {

            }
        });
    }





}
