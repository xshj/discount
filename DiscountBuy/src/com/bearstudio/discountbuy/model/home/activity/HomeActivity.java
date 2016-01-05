package com.bearstudio.discountbuy.model.home.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import com.bearstudio.discountbuy.model.home.fragment.HomeFragment;
import com.bearstudio.discountbuy.util.activity.BaseHomeActivity;

public class HomeActivity extends BaseHomeActivity{
    private HomeFragment mFragment;
    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        onInitContent();
    }
    private void onInitContent(){
        mFragment=(HomeFragment) Fragment.instantiate(this, HomeFragment.class.getName());
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.add(android.R.id.content, mFragment);
        ft.commit();
    }
}
