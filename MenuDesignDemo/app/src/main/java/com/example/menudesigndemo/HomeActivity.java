package com.example.menudesigndemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class HomeActivity extends Activity{

	EditText editNum;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
		editNum=(EditText)findViewById(R.id.editText1);
	
		
	}//eof oncreate
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		MenuInflater inflater=getMenuInflater();
		inflater.inflate(R.menu.homemenu, menu);
				
		return super.onCreateOptionsMenu(menu);
	}
	
	//menu item selection
	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// TODO Auto-generated method stub
		int menuId=item.getItemId();
		switch (menuId) 
		{
		case R.id.menuFact:
			int n=Integer.parseInt(editNum.getText().toString());
			int f=1;
			
			for(int i=1;i<=n;i++)
				f=f*i;
			
			Toast.makeText(HomeActivity.this, "fact:"+f, 7).show();
			
			break;
		case R.id.menuHelp:
			Toast.makeText(HomeActivity.this,				
							"help coming soon..", 7).show();
			break;

		case R.id.menuNext:
			Intent inNext=new Intent(HomeActivity.this,NextActivity.class);
			startActivity(inNext);
			break;
			
		case R.id.menuExit:
			finish();
		default:
			break;
		}
		
		return super.onOptionsItemSelected(item);
	}
	
	
	
}
