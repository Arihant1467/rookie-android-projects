package com.example.activityresult;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ThirdActvity extends Activity 
{
   TextView textName,textAge;
   Button  buttonBack;
   
   @Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.third);
		textName=(TextView) findViewById(R.id.textView1);
		textAge=(TextView) findViewById(R.id.textView2);
		
		
		buttonBack=(Button)findViewById(R.id.button2);
		
		//get data sent from first actvity
		Intent inFromFirst=getIntent();
		
		Bundle bn=inFromFirst.getExtras();
		
		String name=bn.getString("username");
		final int age=bn.getInt("age",0);
		
		textName.setText(name);
		textAge.setText(2*age +"");
		
		//store result in intent and send to first actvity
		int result=age*2;
		Bundle bnNew=new Bundle();
		bnNew.putInt("double", result);
		Intent in=new Intent();
		in.putExtras(bnNew);		
		setResult(RESULT_OK,in); //-->OS
		
		
		
		
		buttonBack.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			
			finish();
				
			}
		});
	}
   
}
