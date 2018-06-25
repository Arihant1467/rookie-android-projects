package com.example.arihant.button_operation;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MyActivity extends ActionBarActivity {
Button b=(Button)findViewById(R.id.button_enter);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
b.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        EditText e=(EditText)findViewById(R.id.edit_text1);
        e.setText("Via dynamically");
    }
});
    }


   /* public void sayHello(View v)
    {
        EditText e=(EditText)findViewById(R.id.edit_text1);
        //Button b=(Button)findViewById(R.id.button_enter);
        e.setText("Hello method via XML");
    }
*/
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
