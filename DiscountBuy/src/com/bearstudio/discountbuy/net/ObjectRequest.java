package com.bearstudio.discountbuy.net;

import java.io.UnsupportedEncodingException;

import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonRequest;
import com.bearstudio.discountbuy.net.pscontrol.DeliverParser;
import com.bearstudio.discountbuy.net.pscontrol.IDeliverParser;
import com.bearstudio.discountbuy.util.AppLog;

/**
 * Wrapper for Volley requests to facilitate parsing of json responses.
 * 
 * @param <T>
 */
public class ObjectRequest extends JsonRequest<Object> {

	private Listener<Object> mListener;
	private RequestParam mRequestParam;

	/**
	 * Creates a new request.
	 * 
	 * @param method the HTTP method to use
	 * @param url URL to fetch the Object from
	 * @param jsonRequest A {@link JSONObject} to post with the request. Null is allowed and indicates no parameters will be posted along with request.
	 * @param listener Listener to receive the JSON response
	 * @param errorListener Error listener, or null to ignore errors.
	 */
	public ObjectRequest(int method, RequestParam param, JSONObject jsonRequest, Listener<Object> listener, ErrorListener errorListener) {
		super(method, param.buildRequestUrl(), (jsonRequest == null) ? null : jsonRequest.toString(), listener, errorListener);
		mListener = listener;
		mRequestParam = param;
	}

	/**
	 * Constructor which defaults to <code>GET</code> if <code>jsonRequest</code> is <code>null</code>, <code>POST</code> otherwise.
	 * 
	 * @throws JSONException
	 * 
	 * @see #ObjectRequest(int, String, JSONObject, Listener, ErrorListener)
	 */
	public ObjectRequest(RequestParam param, Listener<Object> listener, ErrorListener errorListener) throws JSONException {

		this(param.requestMethod() == -1 ? Method.GET : param.requestMethod(), param, param.requestMethod() != -1 ? null : null, listener, errorListener);

	}

	/**
	 * Constructor which defaults to <code>GET</code> if <code>jsonRequest</code> is <code>null</code>, <code>POST</code> otherwise.
	 * 
	 * @throws JSONException
	 * 
	 * @see #ObjectRequest(int, String, JSONObject, Listener, ErrorListener)
	 */
	public ObjectRequest(RequestParam param, Listener<Object> listener, ErrorListener errorListener, int i) throws JSONException {

		this(param.requestMethod() == -1 ? Method.GET : param.requestMethod(), param, param.requestMethod() != -1 ? param.getmPostJsonObject() : null, listener, errorListener);

	}

	@Override
	protected Response<Object> parseNetworkResponse(NetworkResponse response) {
		try {
			byte[] data = response.data;
			String charset = HttpHeaderParser.parseCharset(response.headers);
			String jsonString = new String(data, charset);
			IDeliverParser deliverParser = DeliverParser.newDeliverParser();
			Object object = null;
			if (mRequestParam.getmParserClassName() == null) {
				object = jsonString;
			} else {
				object = deliverParser.deliverJson(mRequestParam.getmParserClassName(), jsonString);
			}

			return Response.success(object, HttpHeaderParser.parseCacheHeaders(response));
		} catch (UnsupportedEncodingException e) {
			return Response.error(new ParseError(e));
		}
	}

	@Override
	protected void deliverResponse(Object response) {
		if (response != null) {
			AppLog.Logd("response===" + response.toString());
			mListener.onResponse(response);
		}

	}
}
