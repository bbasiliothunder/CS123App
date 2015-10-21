package com.cs123grpE.restaurantorderingsystem;

import java.util.ArrayList;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import android.content.*;

public class Register extends Activity {
	SharedPreferences list;
	ArrayList<User> array;

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		// load SharedPreferences, if it exists. else, make empty arraylist
		list = getSharedPreferences("Users", Context.MODE_PRIVATE);
		if (!list.contains("nutzlich")) {
			array = new ArrayList<User>();
		} else {
			try {
				array = convert(list.getString("nutzlich", null));
			} catch (Exception e) {}
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.register, menu);
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
	
	public ArrayList<User> convert (String json) throws Exception {
    	ObjectMapper mapper = new ObjectMapper();		
    	ArrayList<User> stuff = mapper.readValue(json, 
    				new TypeReference<ArrayList<User>>(){});
    	return stuff;
    }
	
	public void sayYes (View v) throws Exception {
		EditText name = (EditText) findViewById (R.id.txtResto);
		EditText user = (EditText) findViewById (R.id.txtUser2);
		EditText pass = (EditText) findViewById (R.id.txtPass2);
		if (name.getText().toString().trim().length() == 0 ||
				user.getText().toString().trim().length() == 0 ||
				pass.getText().toString().trim().length() == 0) {
			Toast.makeText(this, "Please fill in all fields.",
					Toast.LENGTH_SHORT).show();
		} else {
			// save in an arraylist (JSON in SharedPreferences)
			User newUser = new User(name.getText().toString(),
					user.getText().toString(), pass.getText().toString());
			array.add(newUser);
			ObjectMapper map = new ObjectMapper();
			String json = map.writeValueAsString(array);
			SharedPreferences.Editor editor = list.edit();
			editor.putString("nutzlich", json);
			editor.commit();
			Intent i = new Intent (this, Login.class);
			startActivity(i);
			finish();
		}
	}
	
	public void sayNo (View v) {
		Intent i = new Intent (this, Login.class);
		startActivity(i);
		finish();
	}
}