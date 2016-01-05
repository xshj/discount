package com.bearstudio.discountbuy.net.pscontrol;

import org.json.JSONObject;

public interface Parser {
    Object fromJson(JSONObject object);
    
    Object fromJson(String json);
}
