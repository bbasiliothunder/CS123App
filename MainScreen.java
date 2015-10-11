package cs123.app.restoandroid;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class MainScreen extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_screen);
		
		String[] names = {"Fish", "Milk", "Nuts", "Soy", "Shrimp"};
		setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_allergy_list_adapter, names));	
		ListView lv = (ListView)findViewById(R.id.allergyListView);
		lv.setTextFilterEnabled(true);
		lv.setOnItemClickListener(new OnItemClickListener(){
			public void onItemClick(AdapterView<?> parent, View view, int position, long id){
				Toast.makeText(getApplicationContext(), ((TextView) view).getText(), Toast.LENGTH_SHORT).show();
			}
		});
		
	}
}
