package com.example.arihant.check_box;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;


public class MyActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
    }
public void checked(View view)
{
    boolean checked=((CheckBox)view).isChecked();//check_box is clicked
   // long id=view.getId();//get the id which is clicked
    switch(view.getId())
    {
        case R.id.ronaldo:if (checked){
            Toast.makeText(getApplicationContext(),"Cristiano Ronaldo",Toast.LENGTH_SHORT).show();}
            break;
        case R.id.messi:if (checked){
            Toast.makeText(getApplicationContext(),"Lionel Messi",Toast.LENGTH_SHORT).show();}
            break;
        case R.id.sanchez:if (checked){
            Toast.makeText(getApplicationContext(),"Alexis Sanchez",Toast.LENGTH_SHORT).show();}
            break;
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
