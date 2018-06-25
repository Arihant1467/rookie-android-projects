package com.example.menudesigndemo;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.ImageView;
import android.widget.TextView;

public class NextActivity extends Activity 
{ 
	TextView textTitle;
	ImageView imageCartoon;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.next);
		
		textTitle=(TextView)findViewById(R.id.textView1);
		imageCartoon=(ImageView)findViewById(R.id.imageView1);
		
		
		//activate view to show context menu
		registerForContextMenu(textTitle);
		registerForContextMenu(imageCartoon);
		
				
	}//eof oncreate
	
	//attach menu with views
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
		
		//
		
		MenuInflater inflater=getMenuInflater();
		
		switch (v.getId())
		{
		case R.id.textView1:
			   inflater.inflate(R.menu.textmenu, menu);
			break;
		case R.id.imageView1:
			   inflater.inflate(R.menu.imagemenu, menu);
			break;
		default:
			break;
		}
	}
	
	//menu item selection
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
	
		switch (item.getItemId()) 
		{
		case R.id.menuRED:
			textTitle.setTextColor(Color.RED);			
			break;

		case R.id.menuGreen:
			textTitle.setTextColor(Color.GREEN);			
			break;

		case R.id.menuBlue:
			textTitle.setTextColor(Color.BLUE);			
			break;
			
		case R.id.menuDonald :
			imageCartoon.setImageResource(R.drawable.donald);			
			break;

		case R.id.menuGoofie:
			imageCartoon.setImageResource(R.drawable.goofie);			
			break;
			
		case R.id.menuJerry :
			imageCartoon.setImageResource(R.drawable.jerrye);			
			break;
			
		default:
			break;
		}
		
		
		return super.onContextItemSelected(item);
	}
	
	
	
     
}
