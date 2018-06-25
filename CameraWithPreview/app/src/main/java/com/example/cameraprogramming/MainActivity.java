package com.example.cameraprogramming;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends Activity {
Button btcapture,btReset;
Camera cam;
FrameLayout frame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        
        btcapture=(Button)findViewById(R.id.button1);
        btReset=(Button)findViewById(R.id.button2);
        frame=(FrameLayout)findViewById(R.id.frame1);
       
         //open the camera
        cam=Camera.open();// opens back facing
        if(cam==null)
        {
        	Toast.makeText(MainActivity.this, "No camera", 3).show();
        	finish();
        }
        else
        {
        	CameraPreview preview=new CameraPreview(MainActivity.this,
        			cam);
        	frame.addView(preview);
        }
        
        btcapture.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//cam.takePicture(shutter, raw, jpeg);
				cam.takePicture(null, null, new MyPicListener());
			}
		});
        btReset.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				cam.startPreview();
			}
		});
    }
    
    //picture listener
    class MyPicListener implements Camera.PictureCallback
    {

		@Override
		public void onPictureTaken(byte[] data, Camera camera) {
			// TODO Auto-generated method stub
						
			String filePath=getApplicationInfo().dataDir+"/mypic.jpeg";
			try {
				FileOutputStream fout=new FileOutputStream(filePath);
				fout.write(data);
				fout.flush();
				fout.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
    	
    }

}
