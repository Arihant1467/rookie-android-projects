package com.example.arihant.relativelayout;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Button;


public class MyActivity extends Activity {
    Button submit;
    EditText nameEditText,AgeEditText,SalaryEditText,result;
    RadioButton male,female;
    RadioGroup rg1;
    public String str="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        submit=(Button)findViewById(R.id.submit);
        nameEditText=(EditText)findViewById(R.id.nameedittext);
        AgeEditText=(EditText)findViewById(R.id.ageEdittext);
        SalaryEditText=(EditText)findViewById(R.id.salaryEditText);
        result=(EditText)findViewById(R.id.resultEditText);
        male=(RadioButton)findViewById(R.id.malerb);
        female=(RadioButton)findViewById(R.id.femalerb);
        rg1=(RadioGroup)findViewById(R.id.genderRadioGroup);
    }
public void showresult(View view)
{
    str=str.concat(nameEditText.getText().toString());
    str=str.concat("-");
    if (male.isChecked())
    {
        str=str.concat("male - ");
    }
    if (female.isChecked())
    {
        str=str.concat("Female - ");
    }
    str=str.concat(AgeEditText.getText().toString()+"-");
    str=str.concat(SalaryEditText.getText().toString());
    str=str.concat("\n");
    result.setText(str);
    rg1.clearCheck();
    AgeEditText.setText(null);
    SalaryEditText.setText(null);
    nameEditText.setText(null);
}


}
