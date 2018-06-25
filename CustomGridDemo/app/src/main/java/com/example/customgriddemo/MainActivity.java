package com.example.customgriddemo;

import java.util.ArrayList;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

	GridView grid;
	ArrayList<Photo> listPhotos=new ArrayList<Photo>();
	PhotoAdapter adapter;
    
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        grid=(GridView)findViewById(R.id.gridView1);
        
        Photo p1=new Photo(R.drawable.jerry, "Jerry");        
        Photo p2=new Photo(R.drawable.kitty, "Kitty");
        listPhotos.add(p1);
        listPhotos.add(p2);
        listPhotos.add(new Photo(R.drawable.donald, "Donald"));
        listPhotos.add(new Photo(R.drawable.goofie, "Goofie"));
        listPhotos.add(new Photo(R.drawable.ic_launcher, "Android"));
        
        adapter=new PhotoAdapter(MainActivity.this,
        		R.layout.item_view, listPhotos);
        
        grid.setAdapter(adapter);

        
        
        grid.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				
				Photo ph=adapter.getItem(arg2);
				Toast.makeText(MainActivity.this, ph.getTitle(),
						8).show();
				
				Dialog dlg=new Dialog(MainActivity.this);
				dlg.setTitle(ph.getTitle());
				dlg.setContentView(R.layout.dialog_view);
				
				ImageView imgView=
						(ImageView)dlg.findViewById(R.id.imageView1);
				imgView.setImageResource(ph.getImageId());
				
				dlg.show();
				
				
			}
		});
        
        
        
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
}//eof actvity

class PhotoAdapter extends BaseAdapter
{
   Context context;
   int resource;
   ArrayList<Photo> listpPhotos;
   
public PhotoAdapter(Context context, int resource, ArrayList<Photo> listpPhotos) {
	super();
	this.context = context;
	this.resource = resource;
	this.listpPhotos = listpPhotos;
}
   
@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return listpPhotos.size();
	}

@Override
	public Photo getItem(int position) {
		// TODO Auto-generated method stub
		return listpPhotos.get(position);
	}

@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
	  //load item view]
	LayoutInflater inflater=(LayoutInflater)
		context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	
	View itemView=inflater.inflate(resource, null);
	
	ImageView imgView=
			(ImageView)itemView.findViewById(R.id.imageView1);
	
	TextView textTitle=
			(TextView)itemView.findViewById(R.id.textView1);
	
	Photo ph=listpPhotos.get(position);
	
	textTitle.setText( ph.getTitle() );
	imgView.setImageResource( ph.getImageId() );
	
	
	return itemView;
	}
   
}






