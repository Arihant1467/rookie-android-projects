package com.example.servicedemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	EditText editNAme;
	Button buttonStart, buttonStop;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
		editNAme = (EditText) findViewById(R.id.editText1);
		buttonStart = (Button) findViewById(R.id.button1);
		buttonStop = (Button) findViewById(R.id.button2);

		buttonStart.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String name = editNAme.getText().toString();
				Intent in = new Intent(MainActivity.this, 
						FileService.class);
				
				in.putExtra("data", name);
				startService(in);

			}
		});
		
		buttonStop.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent in = new Intent(MainActivity.this, 
						FileService.class);
				stopService(in);
				
			}
		});

	}

}
