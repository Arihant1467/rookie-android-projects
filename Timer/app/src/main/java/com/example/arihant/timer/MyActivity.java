package com.example.arihant.timer;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;


public class MyActivity extends ActionBarActivity {
    Dialog dlg;
    TimePicker timepicker;
    Button set,cancel,start;
    int hour=0,minute=0;
    TextView htext,mtext,stext;
    AlertDialog.Builder aldialog;
    MediaPlayer mplayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        mplayer= MediaPlayer.create(MyActivity.this,R.raw.songplay);
        htext=(TextView)findViewById(R.id.hour);
        mtext=(TextView)findViewById(R.id.minute);
        stext=(TextView)findViewById(R.id.second);
        dlg=new Dialog(this);





        mplayer.setLooping(true);
        dlg.setContentView(R.layout.time_picker_view);
        dlg.setTitle("Choose Your Time");
        set=(Button)dlg.findViewById(R.id.btnset);
        cancel=(Button)dlg.findViewById(R.id.btncancel);
        start=(Button)findViewById(R.id.btnstart);
        timepicker=(TimePicker)dlg.findViewById(R.id.timePicker);
        timepicker.setCurrentHour(0);
        timepicker.setCurrentMinute(0);
        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hour=timepicker.getCurrentHour();
                minute=timepicker.getCurrentMinute();
                dlg.dismiss();
                if (hour<=9)
                { htext.setText("0"+hour);}
                else
                { htext.setText(""+hour);}
                if (minute<=9)
                { mtext.setText("0"+minute);}
                else
                { mtext.setText("0"+minute);}

            }
        });
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(hour==0&&minute==0)
                {
                  Toast.makeText(MyActivity.this,"Please Select Time you Dumb",Toast.LENGTH_LONG).show();

                }


                else
                {
                    StartTimer starttimer = new StartTimer();
                    starttimer.execute(hour, minute);
                }

            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dlg.dismiss();
            }
        });

    }


    public  class StartTimer extends AsyncTask<Integer,Integer,String>
    {

        @Override
        protected String doInBackground(Integer... integers)
        {
            int hour=integers[0];
            int minute=integers[1];
            int time=hour*3600+minute*60-1;
            int s1=time;
            try {
                for (int i=0;i<=s1;++i)
                {
                    int h = time / 3600;
                    int inter_1 = time % 3600;
                    int m = inter_1 / 60;
                    int inter_2 = inter_1 % 60;
                    int s = inter_2;
                    publishProgress(h,m,s);
                    Thread.sleep(1000);
                    time=time-1;
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            mplayer.start();
            try
            {
                Thread.sleep(mplayer.getDuration());
                mplayer.release();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            return "done";
        }

        @Override
        protected void onProgressUpdate(Integer... values)
        {
            super.onProgressUpdate(values);
            if(values[0]<=9)
            {
            htext.setText("0"+values[0]);}
            else
            {
                htext.setText(values[0]);
            }

            if(values[1]<=9)
            {
                mtext.setText("0"+values[1]);}
            else
            {
                mtext.setText(values[1]+"");
            }

            if(values[2]<=9)
            {
                stext.setText("0"+values[2]);}
            else
            {
                stext.setText(values[2]+"");
            }




        }

        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();
            Toast.makeText(MyActivity.this,"Started",Toast.LENGTH_LONG).show();
        }

        @Override
        protected void onPostExecute(String s)
        {
            super.onPostExecute(s);


            Toast.makeText(MyActivity.this,s,Toast.LENGTH_LONG).show();
        }
    }










public void showTimePicker(View v)
{

    timepicker.setIs24HourView(true);
    dlg.show();


}



}
