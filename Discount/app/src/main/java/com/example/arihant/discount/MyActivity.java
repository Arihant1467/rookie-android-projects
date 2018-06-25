package com.example.arihant.discount;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;


public class MyActivity extends ActionBarActivity {
EditText ed1,ed2;
ToggleButton tb;
Button b;
TextView discount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        ed1=(EditText)findViewById(R.id.item);
        ed2=(EditText)findViewById(R.id.price);
        tb=(ToggleButton)findViewById(R.id.toggle);
        b=(Button)findViewById(R.id.discount);
        discount=(TextView)findViewById(R.id.discount_display);
        tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (tb.isChecked())
                {
                    discount.setText("Discount-10%");
                }
                else
                {
                    discount.setText("Discount-20%");
                }
            }
        });
    }
    public void result(View v)
    { float price=0.0f,discountedPrice=0.0f,d=0.0f;
         price=Float.parseFloat(ed2.getText().toString());
        if (tb.isChecked())
        {
            d=price/10;
            discountedPrice=price-d;
         }
        else
        {
            d=price/5;
            discountedPrice=price-d;
        }
        String str="The final price after discount is- "+discountedPrice;
        Toast.makeText(getApplicationContext(),str,Toast.LENGTH_LONG).show();
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
