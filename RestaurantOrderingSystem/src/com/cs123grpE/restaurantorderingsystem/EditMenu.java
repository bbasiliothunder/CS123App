package com.cs123grpE.restaurantorderingsystem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class EditMenu extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_menu);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.edit_menu, menu);
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
	
	public void addMenu (View v) {
		// add a MenuListItem
		Intent i = new Intent (this, AddEditProfile.class);
		startActivity(i);
	}
	
	public void deleteMenu (View v) {
		// show dialog for confirmation
		Toast.makeText(this, "You will delete a Menu Item.", Toast.LENGTH_SHORT).show();
	}
	
	public void onResume() {
		// refresh menu list
	}
}
