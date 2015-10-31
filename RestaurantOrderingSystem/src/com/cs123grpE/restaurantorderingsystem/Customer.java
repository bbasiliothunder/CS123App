package com.cs123grpE.restaurantorderingsystem;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;

public class Customer extends Activity {

	
    	String [] menu = {"BAKED POTATO", "BAKED POTATO3", "BAKED POTATO6", "BAKED POTATO5", "BAKED POTATO4"};
    private ExpandableAdapter epa;
    private ExpandableListView exp;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_customer);
		
		
		ListView lv = (ListView)findViewById(R.id.listview1);
		lv.setAdapter(new ArrayAdapter<String>(this, R.layout.menu_item, menu));
		
		exp = (ExpandableListView)findViewById(R.id.list);
		
		prepareListData();
		
		epa = new ExpandableAdapter(this, listDataHeader, listDataChild);
		
		exp.setAdapter(epa);
		
		exp.setOnGroupClickListener(new OnGroupClickListener() {

			@Override
			public boolean onGroupClick(ExpandableListView parent, View v,
					int groupPosition, long id) {
				// Toast.makeText(getApplicationContext(),
				// "Group Clicked " + listDataHeader.get(groupPosition),
				// Toast.LENGTH_SHORT).show();
				return false;
			}
		});

		// Listview Group expanded listener
		exp.setOnGroupExpandListener(new OnGroupExpandListener() {

			@Override
			public void onGroupExpand(int groupPosition) {
				Toast.makeText(getApplicationContext(),
						listDataHeader.get(groupPosition) + " Expanded",
						Toast.LENGTH_SHORT).show();
			}
		});

		// Listview Group collasped listener
		exp.setOnGroupCollapseListener(new OnGroupCollapseListener() {

			@Override
			public void onGroupCollapse(int groupPosition) {
				Toast.makeText(getApplicationContext(),
						listDataHeader.get(groupPosition) + " Collapsed",
						Toast.LENGTH_SHORT).show();

			}
		});

		// Listview on child click listener
		exp.setOnChildClickListener(new OnChildClickListener() {

			@Override
			public boolean onChildClick(ExpandableListView parent, View v,
					int groupPosition, int childPosition, long id) {
				// TODO Auto-generated method stub
				Toast.makeText(
						getApplicationContext(),
						listDataHeader.get(groupPosition)
								+ " : "
								+ listDataChild.get(
										listDataHeader.get(groupPosition)).get(
										childPosition), Toast.LENGTH_SHORT)
						.show();
				return false;
			}
		});
		
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
	
	private void prepareListData() {
		listDataHeader = new ArrayList<String>();
		listDataChild = new HashMap<String, List<String>>();

		// Adding child data
		listDataHeader.add("MEAT");
		listDataHeader.add("SOUP");
		listDataHeader.add("FISH");

		// Adding child data
		List<String> top250 = new ArrayList<String>();
		top250.add("DICK");
		top250.add("CRISPY PATA");
		top250.add("ADUBA");
		top250.add("PATAATIM");
		top250.add("SINIGANG");

		List<String> nowShowing = new ArrayList<String>();
		nowShowing.add("CHICKEN NOODLE SOUP");
		nowShowing.add("SINIGANG SA MISO");
		nowShowing.add("SPINACH");
		nowShowing.add("BIRD'S NEST");

		List<String> comingSoon = new ArrayList<String>();
		comingSoon.add("TALAKITOK");
		comingSoon.add("PAKSIW");
		comingSoon.add("ESCABECHE");

		listDataChild.put(listDataHeader.get(0), top250); // Header, Child data
		listDataChild.put(listDataHeader.get(1), nowShowing);
		listDataChild.put(listDataHeader.get(2), comingSoon);
	}
}