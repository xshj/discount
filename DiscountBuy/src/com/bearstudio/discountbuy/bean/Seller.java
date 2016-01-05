package com.bearstudio.discountbuy.bean;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Seller implements Serializable{
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    @Expose
	@SerializedName("id")
	private String mId;
	@Expose
	@SerializedName("name")
	private String mName;
	@Expose
	@SerializedName("address")
	private String mAddress;
	@Expose
	@SerializedName("score")
	private String mRatingBar;
	private String mComment;
	@Expose
	@SerializedName("thumb")
	private String mIcon;
	@Expose
	@SerializedName("distance")
	private String mMiles;// 商家的距离
	private String mArea;// 商家的区
	
	private double lat;
	private double lng;

	private String info;
	private String baopin;
	private String huodong;
	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	public String getBaopin() {
		return baopin;
	}

	public void setBaopin(String baopin) {
		this.baopin = baopin;
	}

	public String getHuodong() {
		return huodong;
	}

	public void setHuodong(String huodong) {
		this.huodong = huodong;
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

	public String getmAddress() {
		return mAddress;
	}

	public void setmAddress(String mAddress) {
		this.mAddress = mAddress;
	}

	public String getmRatingBar() {
		return mRatingBar;
	}

	public void setmRatingBar(String mRatingBar) {
		this.mRatingBar = mRatingBar;
	}

	public String getmComment() {
		return mComment;
	}

	public void setmComment(String mComment) {
		this.mComment = mComment;
	}

	public String getmIcon() {
		return mIcon;
	}

	public void setmIcon(String mIcon) {
		this.mIcon = mIcon;
	}

	public String getmMiles() {
		return mMiles;
	}

	public void setmMiles(String mMiles) {
		this.mMiles = mMiles;
	}

	public String getmArea() {
		return mArea;
	}

	public void setmArea(String mArea) {
		this.mArea = mArea;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}
	
	
}
