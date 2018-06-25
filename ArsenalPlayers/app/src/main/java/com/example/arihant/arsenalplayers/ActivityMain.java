package com.example.arihant.arsenalplayers;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;

import java.util.ArrayList;


public class ActivityMain extends Activity {
    GridView grid;
    ArrayList<Arsenal> arsenalArrayList=new ArrayList<Arsenal>();
    ArsenalAdapter arsenalAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        grid=(GridView)findViewById(R.id.gridView);
        Arsenal b=new Arsenal(R.drawable.bellerin);
        arsenalArrayList.add(b);
        arsenalAdapter=new ArsenalAdapter(ActivityMain.this,R.layout.item_view,arsenalArrayList);
        grid.setAdapter(arsenalAdapter);

    }



}
