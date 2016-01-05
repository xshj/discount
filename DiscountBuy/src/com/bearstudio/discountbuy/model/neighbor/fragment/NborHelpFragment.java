package com.bearstudio.discountbuy.model.neighbor.fragment;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.bearstudio.discountbuy.R;
import com.bearstudio.discountbuy.bean.Seller;
import com.bearstudio.discountbuy.model.home.adapter.HomeSellerAdapter;
import com.bearstudio.discountbuy.net.HttpURL;
import com.bearstudio.discountbuy.net.RequestManager;
import com.bearstudio.discountbuy.net.RequestParam;
import com.bearstudio.discountbuy.util.AppLog;
import com.bearstudio.discountbuy.util.Constant;
import com.bearstudio.discountbuy.util.SmartToast;
import com.bearstudio.discountbuy.util.fragment.CommonFragment;
import com.bearstudio.discountbuy.util.view.CustomListView;
import com.bearstudio.discountbuy.util.view.CustomListView.OnRefreshListener;
import com.bearstudio.discountbuy.util.view.ImageCycleView;
import com.bearstudio.discountbuy.util.view.ImageCycleView.ImageCycleViewListener;
import com.bearstudio.discountbuy.util.view.ListViewForScrollView;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.umeng.update.UmengUpdateAgent;
import com.umeng.update.UmengUpdateListener;
import com.umeng.update.UpdateResponse;

public class NborHelpFragment extends CommonFragment implements OnClickListener,UmengUpdateListener{
	private TextView mHotMoreTv;
	private ListViewForScrollView mHotSellerView;
	private HomeSellerAdapter mSellAdapter;
	private List<Seller> mSellerList = new ArrayList<Seller>();
	private View mBaseView;
	private View mainview;
	private View mainProgressBar;
	private CustomListView mCustomListView;
	private ArrayAdapter mArrayAdapter;
	private boolean isFlush;// 城市切换
	
	// 轮播图片
	private ImageCycleView mAdView;
	private ArrayList<String> mImageUrl = null;
	private String imageUrl1 = "http://imgs.xiuna.com/xiezhen/2014-9-25/2/5562900520140919100645087.jpg";
	private String imageUrl2 = "http://imgs.xiuna.com/xiezhen/2013-3-20/1/12.jpg";
	private String imageUrl3 = "http://imgs.xiuna.com/xiezhen/2013-3-20/1/12.jpg";
	
	@Override
	public void requestData() {
		if(isFlush){
			startflushView();
		}
		RequestParam param = new RequestParam();
		HttpURL url = new HttpURL();
		url.setmBaseUrl(Constant.JILIBAO_BASE_URL+Constant.Home_INDEX);
		//		url.setmGetParamPrefix(RequestParamConfig.CITYID);
		//		url.setmGetParamValues(SharePreferenceUtils.getInstance(getActivity()).getArea().getmId());
		//      param.setmParserClassName(KnowLedgeListParser.class.getName());
		param.setmHttpURL(url);
		RequestManager.getRequestData(getActivity(), CreatReqSuccessListener(), CreateErrorListener(), 

				param);
	}
	private Response.Listener<Object> CreatReqSuccessListener() {
		return new Listener<Object>() {
			@Override
			public void onResponse(Object obj) {
				AppLog.Logd(obj.toString());
				AppLog.Loge(" data success to load" + obj.toString());
				mLoadHandler.removeMessages(Constant.NET_SUCCESS);
				mLoadHandler.sendEmptyMessage(Constant.NET_SUCCESS);
				mCustomListView.onRefreshComplete();
				mArrayAdapter.notifyDataSetChanged();

//				                String code = "";
//				                List<Product> productlist = new ArrayList<Product>();
//				                List<Seller> sellerList = new ArrayList<Seller>();
//				                JSONTokener jsonParser = new JSONTokener(obj.toString()); 
//				                try {
//									JSONObject jsonObj = (JSONObject) jsonParser.nextValue();
//									code = jsonObj.getString("code");
//									 JSONArray gjsonArray = jsonObj.getJSONObject("data").getJSONArray("gList");
//							            for(int i = 0; i < gjsonArray.length(); i++)
//							            {
//							            	JSONObject jsonObject = gjsonArray.getJSONObject(i);  
//							            	Product product = new Product();
//							                String id = jsonObject.getString("goodsId"); 
//							                product.setmId(id);
//							                String thumb = jsonObject.getString("thumb");
//							                product.setmImg(thumb);
//							                String name = jsonObject.getString("goodsName");
//							            	product.setmName(name);
//							            	String price = jsonObject.getString("price");
//							            	if(price!=null&&!"".equals(price)){
//							            		product.setmPrice(Float.parseFloat(price));
//							            	}
//							            	String sales = jsonObject.getString("sales");
//							            	product.setmSales(sales);
//							            	productlist.add(product);
//							            }
//						            	JSONArray sjsonArray = jsonObj.getJSONObject("data").getJSONArray("sList");
//						            	for(int i = 0; i < sjsonArray.length(); i++)
//							            {
//							            	JSONObject jsonObject = sjsonArray.getJSONObject(i); 
//							            	Seller seller = new Seller();
//							            	String supId = jsonObject.getString("supId");
//							            	seller.setmId(supId);
//							            	String thumb = jsonObject.getString("thumb");
//							            	seller.setmIcon(thumb);
//							            	String supName = jsonObject.getString("supName");
//							            	seller.setmName(supName);
//							            	String address = jsonObject.getString("address");
//							            	seller.setmAddress(address);
//							            	String score = jsonObject.getString("score");
//							                seller.setmRatingBar(score);
//							                sellerList.add(seller);
//							            }
//								} catch (JSONException e) {
//									e.printStackTrace();
//								} 
//				                
//				                
//				                if("0".equals(code)){
//				                	mSellerList.clear();
//				                	mProList.clear();
//				                    mSellerList.addAll(sellerList);
//				                    mProList.addAll(productlist);
//				                    mSellAdapter.notifyDataSetChanged();
//				                    mProAdapter.notifyDataSetChanged();
//				                }else{
//				                    showSmartToast(R.string.loading_fail, Toast.LENGTH_LONG);
//				                }

				endflushView();
			}
		};
	}

	private Response.ErrorListener CreateErrorListener() {
		return new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {
				//测试代码
				Seller s1 = new Seller();
				s1.setmName("万达和瓦路店");
				s1.setmAddress("合肥市和瓦路店双岗派出所交警庐阳大队北100米");
				s1.setInfo("起送价：20.00｜配送费：2.00｜营业中");
				s1.setHuodong("活动：买2送1");
				s1.setBaopin("爆品：稀饭绿豆粥");
				mSellerList.add(s1);
				mSellerList.add(s1);
				AppLog.Loge(" data failed to load" + error.getMessage());
				if (!isDetached()) {
					endflushView();
					mLoadHandler.removeMessages(Constant.NET_FAILURE);
					mLoadHandler.sendEmptyMessage(Constant.NET_FAILURE);
					mCustomListView.onRefreshComplete();
					mArrayAdapter.notifyDataSetChanged();
				}
			}

		};
	}

	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		startReqTask(this);
		//版本更新
		UmengUpdateAgent.update(getActivity());
		mLoadHandler.sendEmptyMessageDelayed(Constant.NET_SUCCESS, 100);
//		ManagerListener.newManagerListener().onRegisterUpdateListener(this);
	}

	@Override
	public void onDestroy() {
//		ManagerListener.newManagerListener().onUnRegisterUpdateListener(this);
		super.onDestroy();
	}

	@Override
	public void onDestroyView() {
		// TODO Auto-generated method stub
		super.onDestroyView();
	}
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onViewCreated(view, savedInstanceState);

	}
	
	private ImageCycleViewListener mAdCycleViewListener = new ImageCycleViewListener() {

		@Override
		public void onImageClick(int position, View imageView) {
			// TODO 单击图片处理事件
			SmartToast.makeText(getActivity(), "position->"+position, 0).show();
		}

		@Override
		public void displayImage(String imageURL, ImageView imageView) {
			ImageLoader.getInstance().displayImage(imageURL, imageView);// 此处本人使用了ImageLoader对图片进行加装！
		}
	};
	
	private void initView(final View view) {
		
		//轮播
		mImageUrl = new ArrayList<String>();
		mImageUrl.add(imageUrl1);
		mImageUrl.add(imageUrl2);
		mImageUrl.add(imageUrl3);
		mAdView = (ImageCycleView) view.findViewById(R.id.ad_view);
		mAdView.setImageResources(mImageUrl, mAdCycleViewListener);
		
		mainProgressBar = (View) mainview.findViewById(R.id.main_progressBar);
		mArrayAdapter = new ArrayAdapter(
				getActivity(), android.R.layout.simple_list_item_1,
				new Object[]{});
		mCustomListView=(CustomListView) mBaseView.findViewById(R.id.callListView);
		mCustomListView.setAdapter(mArrayAdapter);
		mCustomListView.addHeaderView(mainview);
		mCustomListView.setCanLoadMore(false);
		mCustomListView.setOnRefreshListener(new OnRefreshListener() {
			@Override
			public void onRefresh() {
				isFlush = false;
				requestData();
			}
		});
		
		
		mHotSellerView = (ListViewForScrollView) view.findViewById(R.id.hot_seller_listview);

		mSellAdapter = new HomeSellerAdapter(getActivity(), mSellerList);
		mHotSellerView.setAdapter(mSellAdapter);
		mHotSellerView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
//				UIHelper.toSellerInfoActivity(HomeFragment.this, mSellerList.get(arg2).getmId());
			}
		});


	}
	
	private void initTitleView(){
		setTitleText(R.string.app_name);

	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		mainview = inflater.inflate(R.layout.fragment_home,null);
		mBaseView=inflater.inflate(R.layout.fragment_base, null);
		initTitleView();
		initView(mainview);
		return mBaseView;
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
	}

	@Override
	public void onDetach() {
		// TODO Auto-generated method stub
		super.onDetach();
	}

	@Override
	public void onLowMemory() {
		// TODO Auto-generated method stub
		super.onLowMemory();
	}

	@Override
	public void onClick(View arg0) {
		int id = arg0.getId();
//		switch (id) {
//		case R.id.hot_seller_enter:
//			UIHelper.toClassActivity(HomeFragment.this, SellerListActivity.class.getName());
//			break;
//		case R.id.recommend_product_enter:
//			UIHelper.toClassActivity(HomeFragment.this, RecommendProductListActivity.class.getName());
//			break;
//		case R.id.all_hot_seller:
//			UIHelper.toClassActivity(HomeFragment.this, SellerListActivity.class.getName());
//			break;

//		default:
//			break;
//		}

	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		if(requestCode == 108){
//			if(data !=null)
//				UIHelper.toClassActivity(this, data.getStringExtra("des"));
		}
	}
//	@Override
//	public void onUpdate() {
//		isFlush = true;
//		requestData();
//	}

	public void startflushView(){
		if(mainProgressBar!=null)
			mainProgressBar.setVisibility(View.VISIBLE);
	}

	public void endflushView(){
		if(mainProgressBar!=null)
			mainProgressBar.setVisibility(View.GONE);
	}
	@Override
	public void onUpdateReturned(int arg0, UpdateResponse arg1) {
		// TODO Auto-generated method stub
		
	}
}
