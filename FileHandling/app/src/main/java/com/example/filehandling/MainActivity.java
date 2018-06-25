package com.example.filehandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {

	EditText editName;
	Button buttonSave, buttonRead;
	EditText editAllData;
	
	String filePath;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        editName=(EditText)findViewById(R.id.editText1);
        editAllData=(EditText)findViewById(R.id.editText2);
        buttonRead=(Button)findViewById(R.id.button2);
        buttonSave=(Button)findViewById(R.id.button1);
        
        //creating path for file
        ApplicationInfo appInfo=getApplicationInfo();
        String appPath=appInfo.dataDir;
        
        filePath=appPath+"/mydata.txt";
        
        buttonSave.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			
				String str=editName.getText().toString();
				
				try{
					
					FileWriter writer=new FileWriter(filePath,true);
					writer.write(str +"\n");
					writer.flush();
					writer.close();
					
					editName.setText("");
					
					
				}catch(Exception ex)
				{
					Log.e("my error", ex.toString() );
				}
				
			}
		});
        
        
        buttonRead.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			try{
			
			       FileReader reader=new FileReader(filePath);
			       BufferedReader bufReader=new BufferedReader(reader);
			       
			       String data="";
			       while(true)
			       {
			    	   String s=bufReader.readLine();
			    	   if(s==null) 
			    		   break;
			    	   
			    	   data=data+s +"\n";
			       }
			       
			       editAllData.setText(data);
			       bufReader.close();
			       
			}catch(Exception ex)
			 {
				Log.e("my error", ex.toString() );
			 }
			
			}
		});
    }

}
