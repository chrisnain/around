package de.chrisnain.around;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class MainActivity extends Activity {

	public final static String EXTRA_MESSAGE = "de.chrisnain.around.MESSAGE";
	public final static String HELLO_MESSAGE = "de.chrisnain.around.HELLO_MESSAGE";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		
		//savedInstanceState.
		
		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
			
			Log.v(getResources().getString(R.string.app_name), "savedInstanceState == null");
		}
		else
		{
			Log.v(getResources().getString(R.string.app_name), "savedInstanceState != null");
			
			// Restore value of members from saved state
	        String resouceString = savedInstanceState.getString(HELLO_MESSAGE);
	        Log.v(getResources().getString(R.string.app_name), "instance state: " + resouceString);
		}
	}
	
	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {
		super.onSaveInstanceState(savedInstanceState);
		
		Log.v(getResources().getString(R.string.app_name), "save instance state");
		
		// Save something.
		savedInstanceState.putString(HELLO_MESSAGE, getResources().getString(R.string.hello_world));
	}
	
	public void onRestoreInstanceState(Bundle savedInstanceState) {
	    // Always call the superclass so it can restore the view hierarchy
	    super.onRestoreInstanceState(savedInstanceState);
	   
	    // Restore state members from saved instance
	    String mCurrentLevel = savedInstanceState.getString(HELLO_MESSAGE);
	    
	    Log.v(getResources().getString(R.string.app_name), "restore instance state: " + mCurrentLevel);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu items for use in the action bar
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.main_activity_actions, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle presses on the action bar items
		switch (item.getItemId()) {
		case R.id.action_search:
			openSearch();
			return true;
		case R.id.action_settings:
			openSettings();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
	
	@Override
	protected void onStart() {
	    super.onStart();  // Always call the superclass method first
	    
	    /*
	     * Use this to:
	     * - Initialize components after onStop().
	     */
	}

	@Override
	public void onResume() {
	    super.onResume();  // Always call the superclass method first
	    
	    /*
	     * Use this to:
	     * - Initialize components that you release during onPause().
	     * - Begin animations.
	     * - Initialize components only used while the activity has user focus.
	     */
	}
	
	@Override
	protected void onRestart() {
	    super.onRestart();  // Always call the superclass method first
	    
	    // Activity being restarted from stopped state    
	    
	    /*
	     * Use this only:
	     * - If you can't use onStart().
	     */
	}
	
	@Override
	public void onPause() {
		super.onPause(); // Always call the superclass.
		
		/*
		 * Use this to:
		 * - Stop animations or other ongoing actions that could consume CPU.
		 * - Commit unsaved changes, but only if users expect such changes to be permanently saved when they leave (such as a draft email).
		 * - Release system resources, such as broadcast receivers, handles to sensors (like GPS), or any resources that may affect battery
		 *   life while your activity is paused and the user does not need them.
		 */
	}
	
	@Override
	protected void onStop() {
	    super.onStop();  // Always call the superclass method first
	    
	    /*
		 * Use this to:
		 * - Perform larger, more CPU intensive shut-down operations, such as writing information to a database.
		 */
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy(); // Always call the superclass.
		
		/*
		 * Use this to:
		 * - Release all long-running resources that could potentially leak memory.
		 */
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

	/** Called when the user clicks the Send button */
	public void sendMessage(View view) {
		Intent intent = new Intent(this, DisplayMessageActivity.class);
		EditText editText = (EditText) findViewById(R.id.edit_message);
		String message = editText.getText().toString();
		intent.putExtra(EXTRA_MESSAGE, message);
		startActivity(intent);
	}
	
	public void openSearch() {
		
	}
	
	public void openSettings() {
		
	}
}
