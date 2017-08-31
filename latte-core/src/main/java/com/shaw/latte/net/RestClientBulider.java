package com.shaw.latte.net;

import com.shaw.latte.net.callback.IError;
import com.shaw.latte.net.callback.IFailure;
import com.shaw.latte.net.callback.IRequest;
import com.shaw.latte.net.callback.ISuccess;

import java.util.Map;
import java.util.WeakHashMap;

import okhttp3.MediaType;
import okhttp3.ResponseBody;

/**
 * Created by shaw on 2017/8/31.
 */

public class RestClientBulider {
    private String mUrl;
    private static final Map<String,Object> PARAMS = RestCreator.getParams();
    private IRequest mIRequest;
    private ISuccess mISuccess;
    private IFailure mIFailure;
    private IError mIError;
    private ResponseBody mBody;

    RestClientBulider(){

    }

    public final RestClientBulider url(String url){
        this.mUrl = url;
        return this;
    }

    public final RestClientBulider params(WeakHashMap<String,Object> params){
        PARAMS.putAll(params);
        return this;
    }

    public final RestClientBulider params(String key,Object value){
        PARAMS.put(key,value);
        return this;
    }

    public final RestClientBulider raw(String raw){
        this.mBody = ResponseBody.create(MediaType.parse("application/json;chearset=UTF-8"),raw);
        return this;
    }

    public final RestClientBulider success(ISuccess iSuccess){
        this.mISuccess = iSuccess;
        return this;
    }

    public final RestClientBulider request(IRequest iRequest){
        this.mIRequest = iRequest;
        return this;
    }

    public final RestClientBulider failure(IFailure iFailure){
        this.mIFailure = iFailure;
        return this;
    }

    public final RestClientBulider error(IError iError){
        this.mIError = iError;
        return this;
    }

    public final RestClient bulid(){
        return new RestClient(mUrl,PARAMS,mIRequest,mISuccess,mIFailure,mIError,mBody);
    }

}
