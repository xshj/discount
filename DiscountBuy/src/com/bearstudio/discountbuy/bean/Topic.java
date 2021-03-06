package com.bearstudio.discountbuy.bean;

import java.io.Serializable;

public class Topic implements Serializable{
	private static final long serialVersionUID = 2L;

	private String mId;
	private String mName;
	private String mContent;
	private String mIcon;
	//浏览人数
	private int mVisits;
	//点赞人数
	private int mPoints;
	//评论人数
	private int mComments;
	//发帖时间
	private String mTime;
	public int getmComments() {
		return mComments;
	}
	public void setmComments(int mComments) {
		this.mComments = mComments;
	}
	

	public void setmTime(String mTime) {
		this.mTime = mTime;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public String getmContent() {
		return mContent;
	}
	public void setmContent(String mContent) {
		this.mContent = mContent;
	}
	public String getmIcon() {
		return mIcon;
	}
	public void setmIcon(String mIcon) {
		this.mIcon = mIcon;
	}
	public int getmVisits() {
		return mVisits;
	}
	public int getmPoints() {
		return mPoints;
	}
	public void setmPoints(int mPoints) {
		this.mPoints = mPoints;
	}
	public void setmVisits(int mVisits) {
		this.mVisits = mVisits;
	}
	public String getmTime() {
		return mTime;
	}
}
