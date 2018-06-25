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

public class SecondActivity extends Activity 
{
   TextView textName,textAge;
   Button buttonCanVote, buttonBack;
   
   @Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second);
		textName=(TextView) findViewById(R.id.textView1);
		textAge=(TextView) findViewById(R.id.textView2);
		
		buttonCanVote=(Button)findViewById(R.id.button1);
		buttonBack=(Button)findViewById(R.id.button2);
		
		//get data sent from first actvity
		Intent inFromFirst=getIntent();
		
		Bundle bn=inFromFirst.getExtras();
		
		String name=bn.getString("username");
		final int age=bn.getInt("age",0);
		
		textName.setText(name);
		textAge.setText(age +"");
		
		buttonCanVote.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
		
				boolean result=false; 
				if(age>=18)
				{
					Toast.makeText(SecondActivity.this,
							"eligible", 8).show();
					result=true;
				}
				else
				{
					Toast.makeText(SecondActivity.this,
							"try next year", 8).show();
				}
				
				//store result in intent
				Bundle bn=new Bundle();
				bn.putBoolean("canvote", result);
				Intent in=new Intent();
				in.putExtras(bn);
				
				setResult(RESULT_OK,in); //-->OS
				
				
				
				
			}
		});
		
		buttonBack.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			
				finish();
			//	System.exit(0);
				
			}
		});
	}
   
}
