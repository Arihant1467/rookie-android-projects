package com.example.arihant.circle;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import android.view.View.OnClickListener;



public class MyActivity extends ActionBarActivity {
Button ok;
EditText radius;
TextView area,perimeter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        ok=(Button)findViewById(R.id.OK);
        radius=(EditText)findViewById(R.id.radius);
        area=(TextView)findViewById(R.id.area_circle);
        perimeter=(TextView)findViewById(R.id.perimeter_circle);
        class MyListener implements OnClickListener
        {
            @Override
            public void onClick(View view) {

                float r=Float.parseFloat(radius.getText().toString());
                double ar=3.14*r*r;
                double per=2*r*3.14;

                area.setText(ar+"");
                perimeter.setText(per+"");

            }
        }
        MyListener lis=new MyListener();
        ok.setOnClickListener(lis);
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
