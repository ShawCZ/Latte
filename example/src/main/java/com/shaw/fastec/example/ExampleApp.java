package com.shaw.fastec.example;

import android.app.Application;

import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.shaw.latte.app.Latte;
import com.shaw.latte.ec.Icon.FontEcModule;
import com.shaw.latte.ec.database.DatabaseManger;
import com.shaw.latte.net.interceptors.DebugInterceptor;

/**
 * Created by shaw on 2017/8/30.
 */

public class ExampleApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withIcon(new FontAwesomeModule())
                .withIcon(new FontEcModule())
                .withLoaderDelayed(1000)
                .withApiHost("http://127.0.0.1/")
                .withInterceptor(new DebugInterceptor("test", R.raw.user_profile))
                .withInterceptor(new DebugInterceptor("index",R.raw.index))
                .withInterceptor(new DebugInterceptor("sort",R.raw.sort_list))
                .withInterceptor(new DebugInterceptor("content",R.raw.sort_content))
                .withInterceptor(new DebugInterceptor("shop_cart",R.raw.shop_cart))
                .withWeChatAppId("")
                .withWeChatAppSecret("")
                .configure();
        DatabaseManger.getInstance().init(this);
    }
}
