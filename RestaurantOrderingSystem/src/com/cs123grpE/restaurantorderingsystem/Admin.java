package com.cs123grpE.restaurantorderingsystem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class Admin extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_admin);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.admin, menu);
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
	
	public void editMenu (View v) {
		// go to edit menu screen
		Toast.makeText (this, "You have clicked the Edit Menu button.",
				Toast.LENGTH_SHORT).show();
	}
	
	public void editBill (View v) {
		// go to edit bill screen
		Toast.makeText (this, "You have clicked the Edit Bill button.",
				Toast.LENGTH_SHORT).show();
	}
	
	public void config (View v) {
		Intent i = new Intent (this, Settings.class);
		startActivity(i);
		finish();
	}
	
	public void logoff (View v) {
		Intent i = new Intent (this, Login.class);
		startActivity(i);
		finish();
	}
}
