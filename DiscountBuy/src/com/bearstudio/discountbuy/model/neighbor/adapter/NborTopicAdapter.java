package com.bearstudio.discountbuy.model.neighbor.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bearstudio.discountbuy.R;
import com.bearstudio.discountbuy.bean.Topic;
import com.bearstudio.discountbuy.util.ImageLoaderUtil;
import com.nostra13.universalimageloader.core.ImageLoader;

public class NborTopicAdapter extends BaseAdapter{
	private List<Topic> mItemList;
	private Context mContext;
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mItemList==null?0:mItemList.size();
		//        return 4;
	}
	public NborTopicAdapter(Context context, List<Topic> items) {
		this.mContext = context;
		this.mItemList = items;
	}
	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		//        if(mItemList==null){
		//            Product pro = new Product();
		//            pro.setmId("6");
		//            return pro;
		//        }
		return mItemList.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup arg2) {
		ViewHolder holder = null;
		if (convertView == null) {
			holder  = new ViewHolder();
			convertView = LayoutInflater.from(mContext).inflate(R.layout.item_neighbor_topic, null);
			holder.mIcon = (ImageView) convertView.findViewById(R.id.icon);
			holder.mName = (TextView) convertView.findViewById(R.id.name);
			holder.mPageViews = (TextView) convertView.findViewById(R.id.pageviews);
			holder.mTimes = (TextView) convertView.findViewById(R.id.time);
			convertView.setTag(holder);
		}
		holder = (ViewHolder) convertView.getTag();
		holder.mName.setText(mItemList.get(position).getmName());
		int points =  mItemList.get(position).getmPoints();
		int visits = mItemList.get(position).getmVisits();
		int comments =  mItemList.get(position).getmComments();
		holder.mPageViews.setText("浏览人数："+visits+" 点赞人数："+points+" 评论数："+comments);
		holder.mTimes.setText("发布时间："+mItemList.get(position).getmTime());
		String imageUrl = mItemList.get(position).getmIcon();
		holder.mIcon.setTag(imageUrl);
		if (holder.mIcon.getTag() != null && holder.mIcon.getTag().equals(imageUrl)) {
			ImageLoader.getInstance().displayImage(mItemList.get(position).getmIcon(),holder.mIcon,ImageLoaderUtil.mHallIconLoaderOptions);
		}
		return convertView;
	}

	class ViewHolder {
		private ImageView mIcon;
		private TextView mName;
		private TextView mPageViews;
		private TextView mTimes;
	}
}
