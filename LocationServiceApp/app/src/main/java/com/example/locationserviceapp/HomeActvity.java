package com.example.locationserviceapp;

import android.app.Activity;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class HomeActvity extends Activity
{

	TextView textLoc;
	Button buttonMap;
	LocationManager manager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
		
		textLoc=(TextView)findViewById(R.id.textView1);
		buttonMap=(Button)findViewById(R.id.button1);
		
		manager=(LocationManager)
				getSystemService(LOCATION_SERVICE);
		
		
		//manager.requestLocationUpdates(provider, 
		//    minTime, minDistance, listener);
		
    manager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
	                10000,100, new MyListener() );
		
		buttonMap.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			
				Location currentLoc=
						manager.getLastKnownLocation(
								LocationManager.GPS_PROVIDER);
				
				double lat=currentLoc.getLatitude();
				double lon=currentLoc.getLongitude();
				
				///https://www.google.co.in/maps/@22.7179296,75.8741083,15z?hl=en
				String mapUrl="https://www.google.co.in/maps/@"+
								lat+","+lon+",15z?hl=en";
				
				//launch browser using intent
				Intent in=new Intent();
				in.setAction(Intent.ACTION_VIEW);
				
				Uri u=Uri.parse(mapUrl);
				in.setData(u);
				startActivity(in);
				
				
			}
		});
	}//eof oncreat
	
	class MyListener implements LocationListener
	{

		@Override
		public void onLocationChanged(Location location)
		{
			// TODO Auto-generated method stub
			double lat=location.getLatitude();
			double lon=location.getLongitude();
			long time=location.getTime();
			
			double alt=location.getAltitude();			
			
			textLoc.setText(lat+","+lon +","+time);
			
		}

		@Override
		public void onProviderDisabled(String provider) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onProviderEnabled(String provider) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
