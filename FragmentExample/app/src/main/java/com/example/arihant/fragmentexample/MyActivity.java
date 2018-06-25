package com.example.arihant.fragmentexample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;


public class MyActivity extends Activity {
    Intent in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
    }

public  void fragmentaction(View v)
{
switch (v.getId())
{
    case R.id.btnfragment1: in=new Intent(getApplicationContext(),Fragment_1.class);
                            startActivity(in);
}
}

}
