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
import android.widget.ImageView;

import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.bearstudio.discountbuy.R;
import com.bearstudio.discountbuy.bean.Event;
import com.bearstudio.discountbuy.model.neighbor.adapter.NborEventAdapter;
import com.bearstudio.discountbuy.net.HttpURL;
import com.bearstudio.discountbuy.net.RequestManager;
import com.bearstudio.discountbuy.net.RequestParam;
import com.bearstudio.discountbuy.util.AppLog;
import com.bearstudio.discountbuy.util.Constant;
import com.bearstudio.discountbuy.util.SmartToast;
import com.bearstudio.discountbuy.util.fragment.CommonFragment;
import com.bearstudio.discountbuy.util.view.ImageCycleView.ImageCycleViewListener;
import com.bearstudio.discountbuy.util.view.ListViewForScrollView;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.umeng.update.UmengUpdateAgent;
import com.umeng.update.UmengUpdateListener;
import com.umeng.update.UpdateResponse;

public class NborEventFragment extends CommonFragment implements OnClickListener,UmengUpdateListener{
	private ListViewForScrollView mEventLView;
	private NborEventAdapter mEventAdapter;
	private List<Event> mEventList = new ArrayList<Event>();
	private View mainview;
	private View mainProgressBar;
	private boolean isFlush;// 城市切换

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

				endflushView();
			}
		};
	}

	private Response.ErrorListener CreateErrorListener() {
		return new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {
				//测试代码
				Event e1 = new Event();
				e1.setmName("一起去打羽毛球");
				e1.setmContent("地点在合肥市和瓦路店双岗派出所交警庐阳大队北100米");
				e1.setmPoints(10);
				e1.setmVisits(50);
				e1.setmIcon("http://images.quanjing.com/imageclk003/thu/ic00560904.jpg");
				e1.setmComments(50);
				e1.setmTime("2016-1-3 12:30");
				e1.setmStartTime("2016-1-15 15:30");
				mEventList.add(e1);
				mEventList.add(e1);
				AppLog.Loge(" data failed to load" + error.getMessage());
				if (!isDetached()) {
					endflushView();
					mLoadHandler.removeMessages(Constant.NET_FAILURE);
					mLoadHandler.sendEmptyMessage(Constant.NET_FAILURE);
					mEventAdapter.notifyDataSetChanged();
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

		mEventLView = (ListViewForScrollView) view.findViewById(R.id.lv_topic);

		mEventAdapter = new NborEventAdapter(getActivity(), mEventList);
		mEventLView.setAdapter(mEventAdapter);
		mEventLView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
			}
		});


	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_neighbor_topic,
				container, false);
		initView(view);
		return view;
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
