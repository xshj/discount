package com.bearstudio.discountbuy.model.neighbor.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.bearstudio.discountbuy.model.neighbor.fragment.NborTopicFragment;
import com.bearstudio.discountbuy.util.activity.BaseHomeActivity;

public class NborTopicActivity extends BaseHomeActivity {

	private NborTopicFragment mFragment;
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		onInitContent();
	}
	private void onInitContent(){
		mFragment=(NborTopicFragment) Fragment.instantiate(this, NborTopicFragment.class.getName());
		FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
		ft.add(android.R.id.content, mFragment);
		ft.commit();
	}

}
