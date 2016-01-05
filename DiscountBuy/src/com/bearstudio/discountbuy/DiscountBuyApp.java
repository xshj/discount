package com.bearstudio.discountbuy;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.Application;

import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

public class DiscountBuyApp extends Application {
	private static DiscountBuyApp application = null;
	private List<Activity> allActivitys = new ArrayList<Activity>();
	
    @Override
    public void onCreate() {
        super.onCreate();
        init();
//        this.registerActivityLifecycleCallbacks(new MyActivityLifecycleCallbacks());
    }
    /**
     * Intialize the request manager and the image cache
     */
    private void init() {
//        RequestManager.init(this);
        initImageLoader();
   
    }
    private void initImageLoader() {
        // This configuration tuning is custom. You can tune every option, you
        // may tune some of them,
        // or you can create default configuration by
        // ImageLoaderConfiguration.createDefault(this);
        // method.
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                this).threadPriority(Thread.NORM_PRIORITY - 2)
                .denyCacheImageMultipleSizesInMemory()
                .memoryCache(new LruMemoryCache(5 * 1024 * 1024))
                .memoryCacheSize(5 * 1024 * 1024)
                .diskCacheSize(50 * 1024 * 1024) 
                .diskCacheFileCount(100)
                .tasksProcessingOrder(QueueProcessingType.LIFO) // Not
                .build();
        // Initialize ImageLoader with configuration.
        ImageLoader.getInstance().init(config);
    
    }

    @Override
    public void onLowMemory() {
        // TODO Auto-generated method stub
        super.onLowMemory();
    }
    /**
     * Create the image cache. Uses Memory Cache by default. Change to Disk for
     * a Disk based LRU implementation.
     */
   
    public static DiscountBuyApp getInstance(){
    	if(application == null){
    		application = new DiscountBuyApp();
    	}
		return application;
    	
    }
    
    
    public void addActivitys(Activity act){
    	allActivitys.add(act);
    }
    
    public void finishActivitys(){
    	int len = allActivitys.size();
    	for(int i=0;i<len;i++){
    		allActivitys.get(i).finish();
    	}
    }
}
