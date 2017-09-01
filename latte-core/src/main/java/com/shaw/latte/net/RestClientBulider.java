package com.shaw.latte.net;

import android.content.Context;

import com.shaw.latte.net.callback.IError;
import com.shaw.latte.net.callback.IFailure;
import com.shaw.latte.net.callback.IRequest;
import com.shaw.latte.net.callback.ISuccess;
import com.shaw.latte.ui.LoaderStyle;

import java.io.File;
import java.util.Map;
import java.util.WeakHashMap;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/**
 * Created by shaw on 2017/8/31.
 */

public class RestClientBulider {
    private String mUrl = null;
    private static final Map<String,Object> PARAMS = RestCreator.getParams();
    private IRequest mIRequest = null;
    private ISuccess mISuccess = null;
    private IFailure mIFailure = null;
    private IError mIError = null;
    private RequestBody mBody = null;
    private Context mContext = null;
    private LoaderStyle mLoaderStyle = null;
    private File mFile = null;
    private String  mDownloadDir= null;
    private String  mExtension= null;
    private String  mName= null;


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

    public final RestClientBulider file(String filePath){
        this.mFile = new File(filePath);
        return this;
    }

    public final RestClientBulider file(File file){
        this.mFile = file;
        return this;
    }

    public final RestClientBulider dir(String dir){
        this.mDownloadDir = dir;
        return this;
    }

    public final RestClientBulider extension(String extension){
        this.mExtension = extension;
        return this;
    }

    public final RestClientBulider name(String name){
        this.mName = name;
        return this;
    }

    public final RestClientBulider raw(String raw){
        this.mBody = RequestBody.create(MediaType.parse("application/json;chearset=UTF-8"),raw);
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

    public final RestClientBulider loader(Context context,LoaderStyle loaderStyle){
        this.mContext = context;
        this.mLoaderStyle = loaderStyle;
        return this;
    }

    //使用默认的风格
    public final RestClientBulider loader(Context context){
        this.mContext = context;
        this.mLoaderStyle = LoaderStyle.BallClipRotateIndicator;
        return this;
    }

    public final RestClient bulid(){
        return new RestClient(mUrl,PARAMS,mDownloadDir,mExtension,mName,mIRequest,mISuccess,mIFailure,mIError,mBody,mFile,mLoaderStyle,mContext);
    }

}
