package com.bearstudio.discountbuy.model.neighbor.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.bearstudio.discountbuy.R;
import com.bearstudio.discountbuy.bean.Topic;
import com.bearstudio.discountbuy.model.neighbor.adapter.NborTopicAdapter;
import com.bearstudio.discountbuy.util.AppLog;
import com.bearstudio.discountbuy.util.Constant;
import com.bearstudio.discountbuy.util.fragment.CommonFragment;
import com.umeng.update.UmengUpdateAgent;
import com.umeng.update.UmengUpdateListener;
import com.umeng.update.UpdateResponse;

public class NborTopicDetailFragment extends CommonFragment implements OnClickListener,UmengUpdateListener{
	private Topic mTopic;
	private NborTopicAdapter mTopicAdapter;
	private View mainview;
	private View mainProgressBar;
	private boolean isFlush;// 城市切换

	@Override
	public void requestData() {
//		if(isFlush){
//			startflushView();
//		}
//		RequestParam param = new RequestParam();
//		HttpURL url = new HttpURL();
//		url.setmBaseUrl(Constant.JILIBAO_BASE_URL+Constant.Home_INDEX);
//		//		url.setmGetParamPrefix(RequestParamConfig.CITYID);
//		//		url.setmGetParamValues(SharePreferenceUtils.getInstance(getActivity()).getArea().getmId());
//		//      param.setmParserClassName(KnowLedgeListParser.class.getName());
//		param.setmHttpURL(url);
//		RequestManager.getRequestData(getActivity(), CreatReqSuccessListener(), CreateErrorListener(), 
//
//				param);
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
				AppLog.Loge(" data failed to load" + error.getMessage());
				if (!isDetached()) {
					endflushView();
					mLoadHandler.removeMessages(Constant.NET_FAILURE);
					mLoadHandler.sendEmptyMessage(Constant.NET_FAILURE);
					mTopicAdapter.notifyDataSetChanged();
				}
			}

		};
	}

	@Override
	public void onAttach(Activity activity) {
		mTopic =(Topic) activity.getIntent().getSerializableExtra("topic");
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

	private void initView(final View view) {
		TextView title = (TextView)view.findViewById(R.id.name);
		title.setText(mTopic.getmName());
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_neighbor_topic_detail,
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
