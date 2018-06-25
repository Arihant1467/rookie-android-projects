package com.example.arihant.cameracapture;

import android.content.Context;
import android.hardware.Camera;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.IOException;

public class CameraPreview extends SurfaceView implements SurfaceHolder.Callback
{
    SurfaceHolder holder;
    Camera cam;
    public  CameraPreview(Context context,Camera cam)
    {
        super(context);
        this.cam=cam;
        holder=getHolder();
        holder.addCallback(this);

    }
    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder)
    {
        try {
            cam.setPreviewDisplay(holder);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int format, int width, int height)
    {
        Camera.Parameters param=cam.getParameters();
        param.setPreviewSize(width, height);
        param.setZoom(1);
       param.setRotation(180);

        cam.setParameters(param);

        cam.startPreview();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder)
    {
        cam.stopPreview();
        cam.release();
    }
}
