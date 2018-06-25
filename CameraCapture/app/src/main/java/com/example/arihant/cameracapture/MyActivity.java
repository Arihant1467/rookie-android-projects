package com.example.arihant.cameracapture;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.hardware.Camera;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;


public class MyActivity extends Activity {
Camera cam;
    FrameLayout frame;
    Button capture;
    Button reset;
    CameraPreview preview;
    File mydir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        frame=(FrameLayout)findViewById(R.id.frame1);
        capture=(Button)findViewById(R.id.btncapture);
        reset=(Button)findViewById(R.id.btnreset);
        cam=Camera.open();
         mydir = new File(Environment.getExternalStorageDirectory() + "/CameraPreview/");
        if(!mydir.exists())
            mydir.mkdirs();

        // opens back facing camera;if uou pass any
        // argument ie any integer opens back facing camera
        if(cam==null)
        {
            AlertDialog.Builder alert=new AlertDialog.Builder(this);
            alert.setTitle("Error");
            alert.setMessage("Your mobile doesn't support the correspondin application");
            alert.setPositiveButton("OK",new DialogInterface.OnClickListener() {
                @Override //i is The button that was clicked (e.g. BUTTON1) or the position of the item clicked
                public void onClick(DialogInterface dialogInterface, int i) {
               finish();
                }
            });
        }
        else
        {
             preview=new CameraPreview(MyActivity.this,cam);
            frame.addView(preview);
        }
    }
    class MyPicListener implements Camera.PictureCallback
    { Random r=new Random();
      int i=r.nextInt();

        @Override
        public void onPictureTaken(byte[] data, Camera camera) {
            // TODO Auto-generated method stub

          //  String filePath=getApplicationInfo().dataDir+"/mypic.jpeg";
           // File root= Environment.getExternalStorageDirectory();
            String filePath=mydir.getAbsolutePath()+"/"+i+".jpeg";
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
    @Override
    public void onBackPressed() {
       cam.stopPreview();
        cam.release();
    }

    public void myaction(View v)
    {
       switch (v.getId())
       {
           case R.id.btncapture :
                                 cam.takePicture(null, null, new MyPicListener());
                                // cam.startPreview();
                                 break;
           case R.id.btnreset:
                                cam.startPreview();
                                break;
       }
    }

}
