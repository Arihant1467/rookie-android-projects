package com.example.telephonyservicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.telephony.PhoneStateListener;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class MyService extends Service 
{
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	
	TelephonyManager manager;
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		manager=(TelephonyManager)
				getSystemService(TELEPHONY_SERVICE);
		
		String provider=manager.getNetworkOperator();
		String imei=manager.getDeviceId();
		
		int dataState=manager.getDataState();
		
		Toast.makeText(MyService.this, 
				provider+","+imei+","+dataState, 5).show();
		
		//set listener for state change
		//manager.listen(listener, events);
		manager.listen(new MyListener(), 
				PhoneStateListener.LISTEN_CALL_STATE |
				PhoneStateListener.LISTEN_DATA_CONNECTION_STATE);
		
	}//eof oncreate
	
	class MyListener extends PhoneStateListener
	{
		@Override
		public void onCallStateChanged(int state, String incomingNumber)
		{
			// TODO Auto-generated method stub
			super.onCallStateChanged(state, incomingNumber);
			
			Toast.makeText(MyService.this, 
					state+","+incomingNumber, 5).show();
			
			//if state is ringing
			//wait for 20 seconds and if
			// still riniging the send msg to caller
			WaitingThread t=new WaitingThread(incomingNumber);
			t.start();
			
		}
		
		@Override
		public void onDataConnectionStateChanged(int state, int networkType)
		{
			// TODO Auto-generated method stub
			super.onDataConnectionStateChanged(state, networkType);
			
			Toast.makeText(MyService.this, 
					state+","+networkType, 5).show();

		}
	}
	
	class WaitingThread extends Thread
	{
		String number;
		public WaitingThread(String number) 
		{
			this.number=number;
		} 
		
		
		public void run() 
		{
				try {
					Thread.sleep(20000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if( manager.getCallState()==
						TelephonyManager.CALL_STATE_RINGING)
				{
					SmsManager smsMgr=SmsManager.getDefault();
					//smsMgr.sendTextMessage(destinationAddress, scAddress,
					  //text, sentIntent, deliveryIntent);
					
					smsMgr.sendTextMessage(number, null, "Call U back", null, null);
					
				}
		}
	}
	

}
