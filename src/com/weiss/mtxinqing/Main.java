package com.weiss.mtxinqing;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

public class Main extends Activity implements SearchView.OnQueryTextListener {
	static TabContentFragment currentFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
		setContentView(R.layout.main);

		settingTabs();
	}

	private void settingTabs() {
		ActionBar bar = getActionBar();
		bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		bar.setDisplayOptions(ActionBar.DISPLAY_SHOW_TITLE, ActionBar.DISPLAY_SHOW_TITLE);

		String[] titles = getResources().getStringArray(R.array.fragment_title);
		for (int i = 0; i < titles.length; i++) {
			TabContentFragment fragment = new TabContentFragment();
			fragment.setResourceId(R.layout.fragment);
			Bundle args = new Bundle();
			args.putString("content", titles[i]);
			fragment.setArguments(args);
			bar.addTab(bar.newTab().setText(titles[i]).setTabListener(new TabListener(fragment)));
		}

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Toast.makeText(this, item.getTitle(), Toast.LENGTH_LONG).show();
		return super.onOptionsItemSelected(item);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		SearchView search = (SearchView) menu.findItem(R.id.menu_search).getActionView();
		search.setOnQueryTextListener(this);
		return true;
	}

	@Override
	public boolean onQueryTextSubmit(String query) {
		Log.d("test-onQueryTextSubmit", "the query result is: " + query);
		if (query != null) {
			TextView text = (TextView) currentFragment.getView().findViewById(R.id.fragment_view);
			text.setText(query);
		}
		return false;
	}

	@Override
	public boolean onQueryTextChange(String newText) {
		// TODO Auto-generated method stub
		return false;
	}

}
