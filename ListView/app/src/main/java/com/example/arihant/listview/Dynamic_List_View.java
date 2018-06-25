package com.example.arihant.listview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * Created by Arihant on 31/01/2015.
 */
public class Dynamic_List_View extends Activity{
    ListView lis;
    Button add;
    EditText name;
    public String str="";
    ArrayList<String> arrayList;
    ArrayAdapter arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dynamic_list_view);
        lis=(ListView)findViewById(R.id.list_view);
        add=(Button)findViewById(R.id.add);
        name=(EditText)findViewById(R.id.name);
        //arrayAdapter=new ArrayAdapter();
        arrayList=new ArrayList<String>();
      lis.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          @Override
          public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
              str=String.valueOf(adapterView.getItemAtPosition(pos));
              Toast.makeText(getApplicationContext(),str,Toast.LENGTH_LONG).show();
          }
      });
    }
    public void adding(View v)
    { String additional_name=name.getText().toString();
        arrayList.add(additional_name);
        arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList);
        lis.setAdapter(arrayAdapter);
    }

}
