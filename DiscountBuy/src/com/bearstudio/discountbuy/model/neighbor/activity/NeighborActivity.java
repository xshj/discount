package com.bearstudio.discountbuy.model.neighbor.activity;

import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TextView;

import com.bearstudio.discountbuy.R;

public class NeighborActivity extends TabActivity {

	private TabHost mTabHost;
	private static final String TAB_TOPIC = "tab_topic";
	private static final String TAB_EVENT= "tab_event";
	private static final String TAB_HELP = "tab_help";
	private Context mContext;
	private TextView mShopNumTv;
	private TextView mCityTv ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mContext = this;
		setContentView(R.layout.activity_neighbor);
		initTabHost();
	}

	private void initTabHost() {
		mTabHost = getTabHost();
		mTabHost.setup();
		mTabHost.setup(this.getLocalActivityManager());
		mTabHost.setOnTabChangedListener(onTabChangeListener);
		mTabHost.addTab(mTabHost
				.newTabSpec(TAB_TOPIC)
				.setIndicator(
						getMenuItem(
								getString(R.string.neighbor_tab_topic)))
								.setContent(new Intent(this, NborTopicActivity.class)));
		mTabHost.addTab(mTabHost
				.newTabSpec(TAB_EVENT)
				.setIndicator(
						getMenuItem(
								getString(R.string.neighbor_tab_event)))
								.setContent(new Intent(this, NborEventActivity.class)));
		mTabHost.addTab(mTabHost
				.newTabSpec(TAB_HELP)
				.setIndicator(
						getMenuItem(
								getString(R.string.neighbor_tab_help)))
								.setContent(new Intent(this, NborHelpActivity.class)));
	}
	public View getMenuItem(String textID) {
		LinearLayout ll = (LinearLayout) LayoutInflater.from(mContext).inflate(
				R.layout.tab_item_nbor, null);
		TextView textView = (TextView) ll.findViewById(R.id.name);
		textView.setText(textID);
		return ll;
	}
	private OnTabChangeListener onTabChangeListener = new OnTabChangeListener() {

		@Override
		public void onTabChanged(String tabId) {
		}
	};
}
