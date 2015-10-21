package com.cs123grpE.restaurantorderingsystem;

import java.util.ArrayList;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import android.app.Activity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import android.content.*;


public class Login extends Activity {
	SharedPreferences list;
	ArrayList<User> array;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // check for saved preferences, populate the fields
        list = getSharedPreferences("Users", Context.MODE_PRIVATE);
        if (!list.contains("nutzlich")) {
        	Toast.makeText(this, "NO USERS", Toast.LENGTH_LONG).show();
        }
        EditText user = (EditText) findViewById (R.id.txtUser);
        EditText pass = (EditText) findViewById (R.id.txtPass);
        CheckBox rem = (CheckBox) findViewById (R.id.checkRem);
        user.setText(list.getString("uname", ""), TextView.BufferType.EDITABLE);
        pass.setText(list.getString("passw", ""), TextView.BufferType.EDITABLE);
        rem.setChecked(list.getBoolean("checked", false));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.login, menu);
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
    
    public void logon (View v) throws Exception {
    	/**
    	 * if one or more fields are empty, show toast
    	 * if account doesn't exist, show toast
    	 * otherwise, go to the account selection screen
    	 */
    	EditText user = (EditText) findViewById (R.id.txtUser);
    	EditText pass = (EditText) findViewById (R.id.txtPass);
    	CheckBox rem = (CheckBox) findViewById (R.id.checkRem);
    	try {
    	array = convert(list.getString("nutzlich", null));
    	if ((user.getText().toString().trim().length() == 0 &&
    			pass.getText().toString().trim().length() == 0)) {
    		Toast.makeText(this, "No User", Toast.LENGTH_SHORT).show();
    	} else {
    		// check if inputed values exist in list
    		Intent intent = new Intent (this, SelectAccount.class);
    		for (User a: array) {
    			if (user.getText().toString().equals(a.getUser()) &&
    					pass.getText().toString().equals(a.getPass())) {
    				if (rem.isChecked()) {
    					SharedPreferences.Editor editor = list.edit();
    					editor.putString("uname", user.getText().toString());
    					editor.putString("passw", pass.getText().toString());
    					editor.putBoolean("checked", rem.isChecked());
    					editor.commit();
    				}
    				startActivity(intent);
    				finish();
    			} else {
    				Toast.makeText(this, "Invalid Credentials",
    						Toast.LENGTH_SHORT).show();
    				break;
    			}
    		}
    	}
    	} catch (Exception e) {
    		if ((user.getText().toString().trim().length() == 0 &&
        			pass.getText().toString().trim().length() == 0)) {
        		Toast.makeText(this, "No User", Toast.LENGTH_SHORT).show();
        	} else {
        		Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
        	}
    	}
    }
    
    public void register (View v) {
    	// go to register screen
    	Intent i = new Intent(this, Register.class);
    	startActivity(i);
    	finish();
    }
}
