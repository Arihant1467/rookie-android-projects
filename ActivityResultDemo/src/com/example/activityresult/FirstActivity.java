package com.example.activityresult;


import android.R.bool;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FirstActivity extends Activity
{
     EditText editName,editAge;
     Button butonGo,buttonDouble;
     TextView textResult;
     
     @Override
    protected void onCreate(Bundle savedInstanceState) {
    	// TODO Auto-generated method stub
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.first);
    	
    	butonGo=(Button)findViewById(R.id.button1);
    	buttonDouble=(Button)findViewById(R.id.button2);
    	editName=(EditText)findViewById(R.id.editText1);
    	editAge=(EditText)findViewById(R.id.editText2);
    	textResult=(TextView)findViewById(R.id.textView1);
    	
    	
    butonGo.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
		
			String str1=editName.getText().toString();
			
			String str2=editAge.getText().toString();
			int a=Integer.parseInt(str2);
		
			//create intent
			
			//Intent in=new Intent(context,component name);
			Intent in=new Intent(FirstActivity.this,
					SecondActivity.class);
			
			Bundle bn=new Bundle();
			bn.putString("username", str1);
			bn.putInt("age", a);
			
			in.putExtras(bn);
			
			//send intent to OS
			//startActivity(in); //---> OS
			startActivityForResult(in, 102);
			
		}
	});
    	

    buttonDouble.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
		
			String str1=editName.getText().toString();
			
			String str2=editAge.getText().toString();
			int a=Integer.parseInt(str2);
		
			//create intent
			
			//Intent in=new Intent(context,component name);
			Intent in=new Intent(FirstActivity.this,
					ThirdActvity.class);
			
			Bundle bn=new Bundle();
			bn.putString("username", str1);
			bn.putInt("age", a);
			
			in.putExtras(bn);
			
			//send intent to OS
			//startActivity(in); //---> OS
			startActivityForResult(in, 103);
			
		}
	});
    	
    	
    }//eof oncreate
     
  @Override
protected void onResume() {
	// TODO Auto-generated method stub
	super.onResume();
	editName.setText("");
	editAge.setText("");
}//eof on resume
  
  @Override
protected void onActivityResult(int requestCode,
		int resultCode, Intent data) 
  {
	// TODO Auto-generated method stub
	super.onActivityResult(requestCode, resultCode, data);
	if(requestCode==102)
	{
		Bundle bn=data.getExtras();
		boolean b=bn.getBoolean("canvote");
		textResult.setText(b +"");
	}
	if(requestCode==103)
	{
		Bundle bn=data.getExtras();
		int r=bn.getInt("double");
		textResult.setText(r +"");
	}
}
  
  
}//eof actvity




