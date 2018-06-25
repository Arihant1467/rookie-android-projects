package com.example.arihant.grade_calculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.*;


public class MyActivity extends ActionBarActivity {
//LinearLayout physics_layout,chemistry_layout,maths_layout;
EditText physicsText,chemistryText,mathsText;
TextView grade,percent;
Button done;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
       // physics_layout=(LinearLayout)findViewById(R.id.physics_layout);
        //chemistry_layout=(LinearLayout)findViewById(R, R.id.chemistry_layout);
        //maths_layout=(LinearLayout)findViewById(R.id.math_layout);
        physicsText=(EditText)findViewById(R.id.Physics_marks);
        chemistryText=(EditText)findViewById(R.id.Chemistry_marks);
        mathsText=(EditText)findViewById(R.id.Maths_marks);
        grade=(TextView)findViewById(R.id.grade_textview);
        percent=(TextView)findViewById(R.id.percent_textview);
        done=(Button)findViewById(R.id.done_button);

    }
    public void compile_data(View view)
    {
       float marks1=new Float(physicsText.getText().toString());
        float marks2=new Float(chemistryText.getText().toString());
        float marks3= new Float(mathsText.getText().toString());
        Float f2=(marks1+marks2+marks3)/3;
        if (f2<40.0f)
        {
            grade.setText("D");
        }
        if (f2>=40.0f&&f2<60.0f)
        {
            grade.setText("C");
        }
        if (f2>=60.0f&&f2<80.0f)
        {
            grade.setText("B");
        }
        if (f2>=80.f)
        {
            grade.setText("A");
        }
        percent.setText(f2+"");
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
