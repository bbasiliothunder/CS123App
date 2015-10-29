package com.cs123grpE.restaurantorderingsystem;

import android.app.Activity;
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
		Toast.makeText(this, "You will add a new Menu Item.", Toast.LENGTH_SHORT).show();
	}
	
	public void editMenu (View v) {
		// edit an existing MenuListItem
		Toast.makeText(this, "You will edit a Menu Item.", Toast.LENGTH_SHORT).show();
	}
	
	public void deleteMenu (View v) {
		// delete a MenuListItem
		Toast.makeText(this, "You will delete a Menu Item.", Toast.LENGTH_SHORT).show();
	}
}
