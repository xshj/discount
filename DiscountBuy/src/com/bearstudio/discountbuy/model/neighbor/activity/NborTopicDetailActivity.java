package com.bearstudio.discountbuy.model.neighbor.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.bearstudio.discountbuy.model.neighbor.fragment.NborTopicDetailFragment;
import com.bearstudio.discountbuy.util.activity.BaseActivity;

public class NborTopicDetailActivity extends BaseActivity {

	private NborTopicDetailFragment mFragment;
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		onInitContent();
	}
	private void onInitContent(){
		mFragment=(NborTopicDetailFragment) Fragment.instantiate(this, NborTopicDetailFragment.class.getName());
		FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
		ft.add(android.R.id.content, mFragment);
		ft.commit();
	}

}
