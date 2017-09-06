package com.shaw.fastec.example;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.orhanobut.logger.Logger;
import com.shaw.latte.app.Latte;
import com.shaw.latte.delegates.LatteDelegate;
import com.shaw.latte.net.RestClient;
import com.shaw.latte.net.callback.IError;
import com.shaw.latte.net.callback.IFailure;
import com.shaw.latte.net.callback.ISuccess;

/**
 * Created by shaw on 2017/8/31.
 */

public class ExampleDelegate extends LatteDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_example;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootview) {
//        testRestClient();
    }

    private void testRestClient() {
        RestClient.bulider()
                .url("http://172.0.0.1/index")
                .loader(getContext())
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        Toast.makeText(getContext(), response, Toast.LENGTH_LONG).show();
                        Log.d("获取到本地json数据",response);
                    }
                })
                .failure(new IFailure() {
                    @Override
                    public void onFailure() {

                    }
                })
                .error(new IError() {
                    @Override
                    public void onError(int code, String msg) {

                    }
                })
                .bulid()
                .get();
    }
}
