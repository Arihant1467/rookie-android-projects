package com.example.cameraprogramming;

import java.io.IOException;

import android.content.Context;
import android.graphics.Color;
import android.hardware.Camera;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class CameraPreview extends SurfaceView implements
SurfaceHolder.Callback
{

	Camera cam;
	
	public CameraPreview(Context context,Camera cam)
	{
		super(context);	
		SurfaceHolder holder=getHolder();
		holder.addCallback(this);
		this.cam=cam;
		
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder,
			int format, int width,
			int height) {
		// TODO Auto-generated method stub
		
		Camera.Parameters param=cam.getParameters();
	   param.setPreviewSize(width, height);
	   param.setZoom(3);
	   
	   cam.setParameters(param);
	   
	   cam.startPreview();
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		//attach camera with holder
		try {
			cam.setPreviewDisplay(holder);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		cam.stopPreview();
		cam.release();
	}

}
