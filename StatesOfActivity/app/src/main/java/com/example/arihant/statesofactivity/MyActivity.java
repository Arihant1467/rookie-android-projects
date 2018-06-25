package com.example.arihant.statesofactivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.Switch;
import android.widget.ImageView;


public class MyActivity extends Activity {
ImageView image;
Switch s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imagechange);
       image=(ImageView)findViewById(R.id.image);
       s=(Switch)findViewById(R.id.s);
        image.setImageResource(R.drawable.ic_mesutozil1);
        s.setChecked(false);

    }

    @Override
    protected void onResume() {
        super.onResume();
        s.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
              if (b)
              {
                  image.setImageResource(R.drawable.ic_mesutozil2);
              }
                else
              {
                  image.setImageResource(R.drawable.ic_mesutozil1);
              }
            }
        });



    }

    @Override
    protected void onStart() {
        super.onStart();
        image.setImageResource(R.drawable.ic_mesutozil1);
        s.setChecked(false);

    }
}
