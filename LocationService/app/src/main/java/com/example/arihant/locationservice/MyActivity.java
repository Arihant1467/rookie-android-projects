package com.example.arihant.locationservice;

import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


public class MyActivity extends ActionBarActivity {
TextView latitude;
TextView longitude;
public LocationManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        manager=(LocationManager)getSystemService(LOCATION_SERVICE);
        manager.requestLocationUpdates(LocationManager.GPS_PROVIDER,100,0,new MyLocationListener());
        latitude=(TextView)findViewById(R.id.latitude);
        longitude=(TextView)findViewById(R.id.longitude);
    }
    public class MyLocationListener implements  LocationListener
    { private String loc=null;

        public MyLocationListener() {
            super();
        }

        @Override
        public void onProviderDisabled(String s)
        {
         Location l=manager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
          Toast.makeText(getApplicationContext(),l.toString(),Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onLocationChanged(Location location)
        {
            latitude.setText(location.getLatitude()+"");
            longitude.setText(location.getLongitude()+"");
         loc="Altitude-"+location.getAltitude()+"/Latitude-"+location.getLatitude()+"/Longitude-"+
              location.getLongitude();
            Toast.makeText(getApplicationContext(),loc,Toast.LENGTH_LONG).show();
        }
        @Override
        public void onStatusChanged(String s, int i, Bundle bundle) {

        }

        @Override
        public void onProviderEnabled(String s) {

        }
    }



}
