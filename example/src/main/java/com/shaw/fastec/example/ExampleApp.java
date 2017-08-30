package com.shaw.fastec.example;

import android.app.Application;

import com.shaw.latte.app.Latte;

/**
 * Created by shaw on 2017/8/30.
 */

public class ExampleApp extends Application{

    @Override
    public void onCreate(){
        super.onCreate();
        Latte.init(this)
                .withApiHost("http://127.0.0.1/")
                .configure();
    }
}
