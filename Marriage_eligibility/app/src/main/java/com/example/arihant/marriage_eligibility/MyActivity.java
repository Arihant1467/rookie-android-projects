package com.example.arihant.marriage_eligibility;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

public class MyActivity extends ActionBarActivity {
Button check;
RadioButton rd1,rd2;
EditText ed1,ed2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        ed1=(EditText)findViewById(R.id.name);
        ed2=(EditText)findViewById(R.id.age);
        rd1=(RadioButton)findViewById(R.id.radio_male);
        rd2=(RadioButton)findViewById(R.id.radio_female);
    }
public void result (View v)
{
    if ((ed2.getText().toString()).equals(null))
{
    Toast.makeText(getApplicationContext(),"Enter Age",Toast.LENGTH_LONG);

}
    else {

    float age = Float.parseFloat(ed2.getText().toString());

    if (rd1.isChecked()) {
        if (age >= 18.0f) {
            Toast.makeText(this, "Eligible for marriage", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Not Eligible for marriage", Toast.LENGTH_LONG).show();
        }
    }
    if (rd2.isChecked()) {
        if (age >= 16.0f) {
            Toast.makeText(this, "Eligible for marriage", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Not Eligible for marriage", Toast.LENGTH_LONG).show();
        }
    }
}
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
