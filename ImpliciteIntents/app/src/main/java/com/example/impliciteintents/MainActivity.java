package com.example.impliciteintents;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends ActionBarActivity {

	Button buttonGo,buttonCam;
	ImageView imageCam;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonGo =(Button)findViewById(R.id.button1);
        buttonCam =(Button)findViewById(R.id.button2);
        imageCam=(ImageView)findViewById(R.id.imageView1);
        
        buttonGo.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			
				/*String action=Intent.ACTION_VIEW;//"android.intent.action.VIEW";
				//"com.example.menudesigndemo.next";
				String url="http://www.universalinformatics.com";
				Uri u=Uri.parse(url);
				
				Intent in=new Intent();				
				in.setAction(action);
				in.setData(u);
				
				
				startActivity(in); //--OS
				*/
				
				String action=Intent.ACTION_CALL;
				
				String number="tel:9826032315";
				Uri u=Uri.parse(number);
				
				Intent in=new Intent();				
				in.setAction(action);
				in.setData(u);
				
				
				startActivity(in); //--OS
				
				
			}
		});
        
        buttonCam.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			
				String camAction=MediaStore.ACTION_IMAGE_CAPTURE;
				
				Intent inCam=new Intent(camAction);
				
				startActivityForResult(inCam, 1001);
				
			}
		});
    }//eof oncreate
    
    @Override
    protected void onActivityResult(int arg0, int arg1, Intent arg2) 
    {
    	// TODO Auto-generated method stub
    	super.onActivityResult(arg0, arg1, arg2);
    	if(arg0==1001)
    	{
    		Bundle bn=arg2.getExtras();
    		
    		Bitmap bmp=(Bitmap) bn.get("data");
    		
    		imageCam.setImageBitmap(bmp);
    		
    	}
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
