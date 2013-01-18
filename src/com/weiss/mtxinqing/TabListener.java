package com.weiss.mtxinqing;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;

public class TabListener implements ActionBar.TabListener {
	private final TabContentFragment fragment;

	public TabListener(TabContentFragment fragment) {
		this.fragment = fragment;
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		ft.add(R.id.container, fragment, fragment.getArguments().getString("content"));
		Main.currentFragment = fragment;
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		ft.remove(fragment);

	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {

	}
}
