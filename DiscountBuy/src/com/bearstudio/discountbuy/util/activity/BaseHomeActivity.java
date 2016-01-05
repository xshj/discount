package com.bearstudio.discountbuy.util.activity;

import android.widget.Toast;

import com.bearstudio.discountbuy.R;

public class BaseHomeActivity extends BaseActivity{
    @Override
    public void onBackPressed() {
        boolean isReturn = showConfirmToast();
        if (isReturn)
            return;
//        ShopCar.getShopCar().emptyproductes(this);
        AppManager.getAppManager().finishAllActivity();
        super.onBackPressed();
    }

    private long mExitTime;

    public boolean showConfirmToast() {
        long secondTime = System.currentTimeMillis();
        if (secondTime - mExitTime > 2000) {
            Toast.makeText(this, R.string.double_back_exit_ap, Toast.LENGTH_SHORT).show();
            mExitTime = secondTime;
            return true;
        }
        return false;
    }
}
