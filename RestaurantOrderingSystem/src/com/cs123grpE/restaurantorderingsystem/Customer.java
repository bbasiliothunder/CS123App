package com.cs123grpE.restaurantorderingsystem;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Customer extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_customer);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.customer, menu);
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
	
	public void onBackPressed() {
		// do nothing
	}
	
	public void filterOff (View v) {
		// toggle to filter items without specified item from item list
	}
	
	public void filterOn (View v) {
		// toggle to filter items with specified item from item list
	}
	
	public void search (View v) {
		// search for query in menu name or description
	}
	
	public void viewCart (View v) {
		// go to cart screen
	}
}
