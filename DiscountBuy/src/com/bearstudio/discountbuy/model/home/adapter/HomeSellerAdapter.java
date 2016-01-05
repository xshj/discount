package com.bearstudio.discountbuy.model.home.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bearstudio.discountbuy.R;
import com.bearstudio.discountbuy.bean.Seller;
import com.bearstudio.discountbuy.util.ImageLoaderUtil;
import com.nostra13.universalimageloader.core.ImageLoader;

public class HomeSellerAdapter extends BaseAdapter{
    private List<Seller> mItemList;
    private Context mContext;
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return mItemList==null?0:mItemList.size();
//        return 4;
    }
    public HomeSellerAdapter(Context context, List<Seller> items) {
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
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_home_hot_seller, null);
            holder.mIcon = (ImageView) convertView.findViewById(R.id.icon);
            holder.mName = (TextView) convertView.findViewById(R.id.name);
            holder.mAddress = (TextView) convertView.findViewById(R.id.address);
            holder.mInfo= (TextView) convertView.findViewById(R.id.info);
            holder.mHuodong= (TextView) convertView.findViewById(R.id.huodong);
            holder.mBaopin= (TextView) convertView.findViewById(R.id.baopin);
            convertView.setTag(holder);
        }
        holder = (ViewHolder) convertView.getTag();
        holder.mName.setText(mItemList.get(position).getmName());
        holder.mAddress.setText(mItemList.get(position).getmAddress());
        holder.mInfo.setText(mItemList.get(position).getInfo());
        holder.mHuodong.setText(mItemList.get(position).getHuodong());
        holder.mBaopin.setText(mItemList.get(position).getBaopin());
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
        private TextView mAddress;
        private TextView mInfo;
        private TextView mHuodong;
        private TextView mBaopin;
    }
}
