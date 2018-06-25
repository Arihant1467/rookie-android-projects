package com.example.servicedemo;

import java.io.File;
import java.io.FileWriter;

import android.app.Service;
import android.content.Intent;
import android.os.Environment;
import android.os.IBinder;
import android.widget.Toast;

public class FileService extends Service 
{

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	
	String filePath;
	
	
	public void onCreate() 
	{
		super.onCreate();
		File sdcard=Environment.getExternalStorageDirectory();
		filePath=sdcard.getAbsolutePath()+"/mydata.txt";
	   
		Toast.makeText(FileService.this,
				"On create..", 6).show();
	}
	
	
	public int onStartCommand(Intent intent, 
			int flags, int startId) 
	{
		Toast.makeText(FileService.this,
				"started.."+startId, 6).show();
		
		String str=intent.getStringExtra("data");
		try{
			FileWriter writer=
				new FileWriter(filePath, true);
			writer.write(str+"\n");
			writer.flush();
			writer.close();
			
			
		}catch(Exception e)
		{
			
		}
		
		return super.onStartCommand(intent, flags, startId);
	}
	

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
	   super.onDestroy();
		Toast.makeText(FileService.this,
				"On destroy..", 6).show();

	}
}
