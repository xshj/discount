package com.bearstudio.discountbuy;

import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TextView;

import com.bearstudio.discountbuy.model.home.activity.HomeActivity;
import com.bearstudio.discountbuy.model.neighbor.activity.NeighborActivity;

public class MainActivity extends TabActivity {

	private TabHost mTabHost;
	
	private static final String TAB_HOME = "tab_home";
	private static final String TAB_NEIGHBOR = "tab_neighbor";
	private static final String TAB_MERCHANTS = "tab_merchants";
	private static final String TAB_BUY = "tab_buy";
	private static final String TAB_PCENTER = "tab_pcenter";
	private Context mContext;
	private TextView mShopNumTv;
	private TextView mCityTv ;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mContext = this;
		setContentView(R.layout.activity_main);
		initTabHost();
	}

	 private void initTabHost() {
	        mTabHost = getTabHost();
	        mTabHost.setup();
	        mTabHost.setup(this.getLocalActivityManager());
	        mTabHost.setOnTabChangedListener(onTabChangeListener);
	        Intent intent = new Intent(this, HomeActivity.class);
	        mTabHost.addTab(mTabHost
	                .newTabSpec(TAB_HOME)
	                .setIndicator(
	                        getMenuItem(R.drawable.ic_tab_home,
	                                getString(R.string.home_tab)))
	                .setContent(intent));
	        mTabHost.addTab(mTabHost
	                .newTabSpec(TAB_NEIGHBOR)
	                .setIndicator(
	                        getMenuItem(R.drawable.ic_tab_mall,
	                                getString(R.string.home_neighbor_tab)))
	                .setContent(new Intent(this, NeighborActivity.class)));
	        mTabHost.addTab(mTabHost
	                .newTabSpec(TAB_MERCHANTS)
	                .setIndicator(
	                		getMenuItem(R.drawable.ic_tab_mall,
	                                getString(R.string.home_neighbor_tab)))
	                .setContent(new Intent(this, HomeActivity.class)));
	        mTabHost.addTab(mTabHost
	                .newTabSpec(TAB_BUY)
	                .setIndicator(
	                		getMenuItem(R.drawable.ic_tab_shopcar,
	                                getString(R.string.home_shopcar_tab)))
	                .setContent(new Intent(this, HomeActivity.class)));
	        mTabHost.addTab(mTabHost
	                .newTabSpec(TAB_PCENTER)
	                .setIndicator(
	                        getMenuItem(R.drawable.ic_tab_pcenter,
	                                getString(R.string.home_pcenter_tab)))
	                .setContent(new Intent(this, HomeActivity.class)));
	    }
	 public View getMenuItem(int imgID, String textID) {
	        LinearLayout ll = (LinearLayout) LayoutInflater.from(mContext).inflate(
	                R.layout.tab_item, null);
	        ImageView imgView = (ImageView) ll.findViewById(R.id.icon);
	        // imgView.setBackgroundResource(imgID);
	        imgView.setImageDrawable(getResources().getDrawable(imgID));
	        TextView textView = (TextView) ll.findViewById(R.id.name);
	        textView.setText(textID);
	        return ll;
	    }
	 private OnTabChangeListener onTabChangeListener = new OnTabChangeListener() {

	        @Override
	        public void onTabChanged(String tabId) {
	        	findViewById(R.id.header_search_layout).setVisibility(View.GONE);
	            if (tabId.equals(TAB_HOME)) {
//	                AppLog.Logd("switch to TAB_MANGOZONE initMangoAreaTabs");
	                findViewById(R.id.header_search_layout).setVisibility(View.VISIBLE);
//	                mCityTv = (TextView) findViewById(R.id.home_header_cityname);
//	                mCityTv.setOnClickListener(new OnClickListener(){
//	                	@Override
//						public void onClick(View v) {
//							 UIHelper.toCityChooseActivity(MainActivity.this);
//						}
//	                });
//	                mCityTv.setText(SharePreferenceUtils.getInstance(MainActivity.this).getArea().getmName());
//	             
	            }
//	            	else if (tabId.equals(TAB_WEIBO)) {
//	                AppLog.Logd("switch to TAB_MANGOBOARD initBoardTabs ");
//	            } else if (tabId.equals(TAB_MALL)) {
//	                AppLog.Logd("switch to TAB_MANGOREMMEND initRecommendTab");
//	              
//	            } else if (tabId.equals(TAB_PCENTER)) {
//	                AppLog.Logd("switch to TAB_MANGOCATE initCateTabs");
//	              
//	            }
	        }
	    };
}
