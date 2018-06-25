package com.example.arihant.countrystatescity;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;


public class MyActivity2 extends ActionBarActivity {
Spinner state,city;
ArrayAdapter adapterstate,adaptercity;
ArrayList alstate,alcity;
public String data=null;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_activity2);
        back=(Button)findViewById(R.id.backbutton);
        Intent intent=getIntent();
        Bundle bn=intent.getExtras();
        String name=bn.getString("nameentered");
      final   int pos=bn.getInt("countryindex");
        state=(Spinner)findViewById(R.id.sate);
        city=(Spinner)findViewById(R.id.city);
        alstate=new ArrayList();
        alcity=new ArrayList();
        adapterstate=new ArrayAdapter(MyActivity2.this,android.R.layout.simple_spinner_dropdown_item,alstate);
        adaptercity=new ArrayAdapter(MyActivity2.this,android.R.layout.simple_spinner_dropdown_item,alcity);
        city.setAdapter(adaptercity);
        switch (pos)
        {
            case 0:
                alstate.add("Madhya Pradesh");
                alstate.add("Maharashtra");
                alstate.add("Gujarat");
                state.setAdapter(adapterstate);
                adapterstate.notifyDataSetChanged();
                break;
            case 1:alstate.add("North");
                alstate.add("South");
                alstate.add("East");
                state.setAdapter(adapterstate);
                adapterstate.notifyDataSetChanged();
                break;
            case 2:alstate.add("Wales");
                alstate.add("London");
                alstate.add("Merseyside");
                state.setAdapter(adapterstate);
                adapterstate.notifyDataSetChanged();
                break;
        }

        state.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (pos)
                {
                    case 0:switch(i)
                    {
                        case 0:alcity.removeAll(alcity);
                               alcity.add("Indore");
                               alcity.add("Bhopal");
                               alcity.add("Ujjain");
                               adaptercity.notifyDataSetChanged();
                               break;
                        case 1:alcity.removeAll(alcity);
                            alcity.add("Mumbai");
                            alcity.add("Pune");
                            alcity.add("Nagpur");
                            adaptercity.notifyDataSetChanged();
                            break;
                        case 2:alcity.removeAll(alcity);
                            alcity.add("Ahemdabad");
                            alcity.add("Surat");
                            alcity.add("Gandhinagar");
                            adaptercity.notifyDataSetChanged();
                            break;
                    }

                        break;
                    case 2:switch(i)
                    {
                        case 0:alcity.removeAll(alcity);
                            alcity.add("Swans");
                            alcity.add("wales-2");
                           // alcity.add("Ujjain");
                            adaptercity.notifyDataSetChanged();
                            break;
                        case 1:alcity.removeAll(alcity);
                            alcity.add("Arsenal");
                            alcity.add("Chelsea");
                            alcity.add("Tottenham");
                            adaptercity.notifyDataSetChanged();
                            break;
                        case 2:alcity.removeAll(alcity);
                            alcity.add("Liverpool");
                            alcity.add("Everton");
                            //alcity.add("Gandhinagar");
                            adaptercity.notifyDataSetChanged();
                            break;
                    }
                      break;
                    case 1:switch(i)
                    {
                        case 0:alcity.removeAll(alcity);
                            alcity.add("New York");
                            alcity.add("Dallas");
                            //alcity.add("Ujjain");
                            adaptercity.notifyDataSetChanged();
                            break;
                        case 1:alcity.removeAll(alcity);
                            alcity.add("Okhlama");
                            alcity.add("Los Angeles");
                            //alcity.add("Nagpur");
                            adaptercity.notifyDataSetChanged();
                            break;
                        case 2:alcity.removeAll(alcity);
                            alcity.add("Boston");
                            alcity.add("Washington");
                            //alcity.add("Gandhinagar");
                            adaptercity.notifyDataSetChanged();
                            break;
                    }

                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        city.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                 data=city.getItemAtPosition(i).toString();
                Toast.makeText(MyActivity2.this,data,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
public void piche(View view)
{
    Bundle bn=new Bundle();
    bn.putString("citygotselected",data);
    Intent in2=new Intent();
    in2.putExtras(bn);
    setResult(RESULT_OK,in);

    finish();
}


}
