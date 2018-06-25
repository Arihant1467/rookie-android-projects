package com.example.arihant.countrystatescity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


import java.util.ArrayList;


public class MyActivity extends Activity {
Button submit;
EditText name;
Spinner country;
ArrayAdapter datainspinnercountry;

    ArrayList<String> countryname=new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        submit=(Button)findViewById(R.id.submit);
        name=(EditText)findViewById(R.id.name);
        country=(Spinner)findViewById(R.id.country);
        countryname.add("India");
        countryname.add("USA");
        countryname.add("England");

        datainspinnercountry=new ArrayAdapter(MyActivity.this,R.layout.support_simple_spinner_dropdown_item,countryname);
        country.setAdapter(datainspinnercountry);

    }
public  void answer(View v)
{
    Intent in=new Intent(MyActivity.this,MyActivity2.class);
    Bundle bn=new Bundle();
    bn.putString("nameentered",name.getText().toString());
    bn.putString("countryselected",country.getSelectedItem().toString());
    bn.putInt("countryindex",country.getSelectedItemPosition());
    in.putExtras(bn);
    startActivityForResult(in,102);
}


}
