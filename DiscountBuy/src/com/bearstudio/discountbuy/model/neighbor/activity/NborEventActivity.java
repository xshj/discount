package com.bearstudio.discountbuy.model.neighbor.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.bearstudio.discountbuy.model.neighbor.fragment.NborEventFragment;
import com.bearstudio.discountbuy.util.activity.BaseHomeActivity;

public class NborEventActivity extends BaseHomeActivity {

	private NborEventFragment mFragment;
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		onInitContent();
	}
	private void onInitContent(){
		mFragment=(NborEventFragment) Fragment.instantiate(this, NborEventFragment.class.getName());
		FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
		ft.add(android.R.id.content, mFragment);
		ft.commit();
	}
}
