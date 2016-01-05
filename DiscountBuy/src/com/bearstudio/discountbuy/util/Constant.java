package com.bearstudio.discountbuy.util;

public class Constant {
	public static final String JILIBAO_BASE_URL = "http://114.215.187.74:10201/jilibao-api/";
//    public static final String JILIBAO_BASE_URL = "http://api.benbanghui.com/";
//    public static final String GETORDERMESSAGE_URL = "http://114.215.187.74:10201/jilibao-api/trans/getSign";
    public static final String Wuliu_BASE_URL = "http://v.juhe.cn/exp/index?key=d8e2eb0ab582dffb428c7bfbc48d6213&dtype=json";//物流接口
	public static final int NETWORK_NOT_AVALIABLE_MESSAG = 0x901;
	public static final int NET_STATUS_NODATA = 0x902;
	public static final int NET_SUCCESS = 0x903;
	public static final int NET_LOAD = 0x904;
	public static final int NET_REFRESH = 0x905;
	public static final int NET_FAILURE = 0x906;
	public static final int NET_REFRESHING = 0x907;
    public static final int PAGE_SIZE = 10;
 
    public static int LOGIN_REQUEST_CODE= 0x201;
    public static int ORDER_CITY_INTENT= 0x202;
    public static int ORDER_ADDRESS_INTENT=0x203;
    public static int ADDRESS_SUCCESS=0x204;
    public static int AD_MANAGE_INTENT=0x205;
	public static int SCREEN_WIDTH = 480;
	public static int SCREEN_HEIGHT = 800;
	public static float SCREEN_DENSITY = (float) 1.0;
	
	public static int REGISTER_SUCCESS = 0X301;
	
	
	public static int HEADER_TITLE_LEFT_ICON_DISPLAY_FLAG = 0;// BACK iCON

    public static String UPDATE_VERSION="system/upgrade";// 软体更新
    
    public static String REQ_SELLER_URL="supplier/query";// 商户列表
    
    public static String GOODS_CATEGORY_URL="goods/querycategory";// 商品/商家分类列表
    
    public static String REQ_HOT_SELLER_URL="index/supplier";// 首页热门商家
    
    public static String REQ_PRODUCT_URL="goods/querygoodslist";// 商品列表
    
    public static String REQ_HOT_PRODUCT_URL="index/goods";// 首页热门推荐商品
    
    public static String CITY_REQUEST_LIST_URL="syscity";// 城市列表
    
    public static String REGISTER_REQUEST_URL="customer/register";// 注册请求 
    
    public static String LOGIN_REQUEST_URL="customer/login";// 登录请求 
    
    public static String COLLECT_URL="custom/creatfavour";// 商品收藏或者商家收藏
    
    public static String CANCEL_COLLECT_URL="custom/deletefavour";// 商品取消收藏或者商家取消收藏
    
    public static String COLLECT_GOOD_LIST="custom/goodsfavour"; // 商品收藏列表

    public static String COLLECT_SUPPLIER_LIST="custom/supplierfavour"; // 商户收藏列表


    public static String PRODUCT_INFO_URL="goodsinfo/query";// 商品信息
    
    public static String PRODUCT_DETAIL_URL="goods/desc?id=";// 商品图文详情
    
    public static String SELLER_DETAIL_URL="supplier/desc?id=";// 商户图文详情
    
    public static String TAKING_ORDER_REQUEST_URL="cart/jiesuan";// 下单
    
    public static String ADDRESS_REQUEST_URL="address/list";// 地址列表
    
    public static String DEFAULT_ADDRESS_REQUEST_URL="address/setdefault";// 默认地址列表
    
    public static String UPDATE_ADDRESS_REQUEST_URL="address/update";// 更新收货地址信息
    
    public static String DELETE_ADDRESS_REQUEST_URL="address/delete";// 更新收货地址信息
    
    
    public static String SEARCH_PRODUCT_REQUEST_URL="serach/goodslist";// 搜索商品信息
    
    public static final String SEARCH_SELLER_REQUEST_URL = "serach/supplier";// 根据关键字搜索商户
    
    public static final String ADD_ADDRESS_REQUEST_URL ="address/create";// 增加地址信息
    
    public static final String CITY_URL =  "syscity";
  
    public static final String GOODS_PIC_TEXT  =  "goods/desc?id=";// 查看商家的图文的商品详情
    
    public static final String SELLER_PIC_TEXT  =  "supplier/desc?id=";// 查看商户的图文详情
    
    public static final String MESSAGE_CODE_REQUEST_URL = "customer/getcode/zc";// 获取注册验证码
    
    public static final String MODIFY_PASSSWORD_URL = "customer/updatepwd";// 修改密码
    
    public static final String FORGET_PASSSWORD_URL = "customer/forgetpwd";// 忘记密码
    
    public static final String MESSAGE_CODE_FORGET_URL = "customer/getcode/mm";// 获取忘记密码验证码
    
    public static final String MODIFY_PHONE_URL ="customer/updateMobile"; // 修改手机号
    
    public static final String MESSAGE_CODE_MODIFY_URL = "customer/getcode/sj";// 获取修改手机号验证
    
    public static final String CERTIFICATION_URL = "customer/rzApply";// 消费者认证
   
    public static String DELETE_TO_CART_REQUEST_URL="cart/del";// 删除购物车中 产品
    
    public static String UPDATE_TO_CART_REQUEST_URL ="cart/update";// 更新购物车中商品的数量
    
    public static String ADD_TO_CART_REQUEST_URL="cart/add";// 加入到购物车
    
    public static String SHOP_CARD_REQUEST_URL ="cart/list?custId=";//我的购物车
    
    public static String AREA_QUERY_URL="region/query";// 地区查询
    
    public static String ORDER_CREATE_REQUEST_URL="order/create";// 订单创建
    
    public static String ORDER_LIST_URL="orderList/sp";// 我的订单

    public static String SELLER_INFO_REQUEST_URL="supplierinfo/query";// 商户信息接口查询
    
    public static String SELLER_ONLINE_PRODUCT_URL="goodsdisplayList/query";// 商家在线商品列表

    public static String SELLER_RECOMMEND_PRODUCT_URL="goodsdisplay/query";// 商家推荐商品列表
   
    public static String Home_INDEX="index";// 首页
   
    public static String Home_SUPPLIER_MAP="suppliermap/query";// 距离用户1000米以内的商家列表
    
    public static String REQ_COMMENT_LIST_URL="comment/sup/list";// 请求评论列表
    
    public static String REQ_GOODS_COMMENT_LIST_URL="comment/goods/list";// 请求商品评论列表
    
    public static String REQ_BANK_LIST_URL="custbank/query";// 请求储蓄卡/信用卡列表
    
    public static String ADD_BANK_URL="custbank/create";// 新增储蓄卡/信用卡
    
    public static String REQ_BANK_URL="bank/query"; //查询已开通的银行列表
    
    public static String DELETE_ORDER_REQUEST_URL="order/seal";// 删除订单的请求
    
    public static String MY_ORDER_REQUEST_URL="orderList/sp";// 我的订单列表请求
    
    public static String CONFIRM_ORDER_REQUEST_URL="order/sure";// 确认收货请求
    
    public static String COMMENT_REQ_URL="comment/sup/add";// 发表评论的请求
    
    public static String GOODS_CLASSIFY_URL="supplier/querycategory";// 商家列表检索项
    
    public static String Pay_Offline="pay/offline";// 首页支付
    
    public static String Pay_Sup_Info="pay/sup/info";//立即支付-根据商户账号查询商户信息
    
    public static String COMMENT_LIST_REQUEST_URL="order/commentList";
    
    public static String COMMENT_ORDER_REQUEST_URL="order/comment";
    
    public static String Deposit_Huankuan_URL="deposit/huankuan"; //信用卡还款 
    
    public static String Zhuanzhang_Query_URL="trans/zhuanzhang/query";//转账-查询账户信息
    
    public static String Zhuanzhang_URL="trans/zhuanzhang";// 转账
    
    public static String Custbank_Delete_URL="custbank/delete";//删除信用卡
    
    public static String Supplier_OrderList_URL="supplier/orderList/sp";// 商户订单
    
    public static String PAY_URL = "pay/callback"; //批量订单支付
	
    public static String PAY_ORDER_URL = "pay/callback/order";	//单个订单支付
    
    public static String PAY_GWCARD_URL = "trans/gwkcz";	//本贝点充值
    
    public static String PAY_LCCARD_URL = "trans/lckcz";	//理财卡充值
    
    public static String USER_INFO_REQ_URL = "customer/info?custId="; //用户信息
     
    public static String SHOUYI_URL = "lixi/shouyi"; //收益
    
    public static String Sales_Monthly_URL = "sales/monthly/query"; //商户订单销售额统计
    public static String Sales_M_URL = "sales/month/query";  //每月销售总额统计


    public static String ABOUT_URL = "sys/about"; //关于
    
    public static String FEED_URL = "sys/feedback"; //意见反馈
    
    public static String MESSAGE_QUERY_URL = "message/query";  //客户消息列表
    public static String MESSAGE_UPDATE_URL = "message/renew";  //更新客户消息列表
    public static String MESSAGE_DEL_URL = "message/delete";  //删除客户消息列表
    
    public static String TRANS_TYPELIST_URL="customer/trans/typeList";// 交易记录-查询交易类型
    public static String TRANS_RECORDS_URL="customer/trans/records";// 交易记录
 
    public static String MY_BUSINESS_URL="business/query";// 业务员-我的业务
    
    public static String ORDER_EXP_URL="supplier/order/exp"; // 订单发货
    
    public static String Return_GOOD_URL="order/reject"; // 退货
    
    public static String SellerReturn_GOOD_URL="supplier/order/doReject"; // 订单发货
    
    public static String SellerDel_GOOD_URL="order/supseal"; // 商户订单删除
    
    public static String SYS_EXPCOLIST_URL = "sys/expCoList"; //获取快递公司列表

    public static String UPDATE_THUMB_URL = "customer/update/thumb";//修改头像

    public static String DEPOSIT_TIXIAN_URL = "deposit/tixian";//储蓄卡提现
    
    public static String APPLy_Return_URL = "order/reject/apply";//申请退货
    
    public static String APPLy_Deal_URL = "supplier/order/reject/apply";//商户同意、拒绝退货申请
    
    public static String Return_Money_URL="order/tuikuan";// 退款请求
    
    public static String Return_Money_Confrim_URL="supplier/order/tuikuan";// 确认退款请求
    
    public static String GETORDERMESSAGE_URL="trans/getSign";
    
    public static String preSign_URL = "trans/ylcz";
}
