package com.cs123grpE.restaurantorderingsystem;

import java.util.ArrayList;

import android.app.ExpandableListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.content.Context;
import android.view.LayoutInflater;

public class Customer extends ExpandableListActivity {
	
	private ArrayList<String> parentItems = new ArrayList<String>();
    private ArrayList<Object> childItems = new ArrayList<Object>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_customer);
		/**
		ExpandableListView expList = (ExpandableListView) findViewById(R.id.list);
		expList.setDividerHeight(2);
		expList.setGroupIndicator(null);
		expList.setClickable(true);
		setGroupParents();
		setChildData();*/
		
		ExpandableAdapter a = new ExpandableAdapter(parentItems, childItems);
		a.setInflater((LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE),
				this);
		setListAdapter(a);
		//expList.setOnChildClickListener(this); 
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
	
	public void setGroupParents() {
		        parentItems.add("Android");
		        parentItems.add("Core Java");
		        parentItems.add("Desktop Java");
		        parentItems.add("Enterprise Java");
		    }

		    public void setChildData() {
		        // Android
		        ArrayList<String> child = new ArrayList<String>();
		        child.add("Core");
		        child.add("Games");
		        childItems.add(child);

		        // Core Java
		        child = new ArrayList<String>();
		        child.add("Apache");
		        child.add("Applet");
		        child.add("AspectJ");
		        child.add("Beans");
		        child.add("Crypto");
		        childItems.add(child);

		        // Desktop Java
		        child = new ArrayList<String>();
		        child.add("Accessibility");
		        child.add("AWT");
		        child.add("ImageIO");
		        child.add("Print");
		        childItems.add(child);

		        // Enterprise Java
		        child = new ArrayList<String>();
		        child.add("EJB3");
		        child.add("GWT");
		        child.add("Hibernate");
		        child.add("JSP");
		        childItems.add(child);
		    }
		}
