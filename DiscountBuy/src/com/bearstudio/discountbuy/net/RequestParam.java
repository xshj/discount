package com.bearstudio.discountbuy.net;

import org.json.JSONObject;

import android.util.Log;

import com.android.volley.Request.Method;

public class RequestParam implements IRequestParam {
	private HttpURL mHttpURL;

	private String mParserClassName;

	private int mRequestMethod = -1;

	private JSONObject mPostJsonObject = new JSONObject(); // post请求需要提交的数据

	public HttpURL getmHttpURL() {
		return mHttpURL;
	}

	public void setmHttpURL(HttpURL mHttpURL) {
		this.mHttpURL = mHttpURL;
	}

	public JSONObject getmPostJsonObject() {
		//Log.i("qinxu", "RequestParam getmPostJsonObject mPostJsonObject.toString() = " + mPostJsonObject.toString());

		return mPostJsonObject;
	}

	public void setmPostarams(JSONObject postJsonObject) {
		this.mPostJsonObject = postJsonObject;
	}

	public void setPostRequestMethod() {
		mRequestMethod = Method.POST;
	}

	public void setDeleteRequestMethod() {
		mRequestMethod = Method.DELETE;
	}

	public void setPutRequestMethod() {
		mRequestMethod = Method.PUT;
	}

	@Override
	public String buildRequestUrl() {
		// TODO Auto-generated method stub
		return mHttpURL.toString();
	}

	public String getmParserClassName() {
		return mParserClassName;
	}

	public void setmParserClassName(String mParserClassName) {
		this.mParserClassName = mParserClassName;
	}

	@Override
	public int requestMethod() {
		return mRequestMethod;
	}

}
