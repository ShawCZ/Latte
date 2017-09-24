package com.shaw.fastec.example;

import android.app.Application;
import android.support.annotation.Nullable;

import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.shaw.latte.app.Latte;
import com.shaw.latte.ec.Icon.FontEcModule;
import com.shaw.latte.ec.database.DatabaseManger;
import com.shaw.latte.net.interceptors.DebugInterceptor;
import com.shaw.latte.util.callback.CallbackManager;
import com.shaw.latte.util.callback.CallbackType;
import com.shaw.latte.util.callback.IGlobalCallback;

import cn.jpush.android.api.JPushInterface;

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
                .withInterceptor(new DebugInterceptor("index", R.raw.index))
                .withInterceptor(new DebugInterceptor("sort", R.raw.sort_list))
                .withInterceptor(new DebugInterceptor("content", R.raw.sort_content))
                .withInterceptor(new DebugInterceptor("shop_cart", R.raw.shop_cart))
                .withInterceptor(new DebugInterceptor("order_list", R.raw.oeder_list))
                .withInterceptor(new DebugInterceptor("address", R.raw.address))
                .withInterceptor(new DebugInterceptor("about", R.raw.about))
                .withInterceptor(new DebugInterceptor("goods", R.raw.goods))
                .withWeChatAppId("wxfcdcecd9df8e0faa")
                .withWeChatAppSecret("a0560f75335b06e3ebea70f29ff219bf")
                .configure();
        DatabaseManger.getInstance().init(this);

        //开启极光推送
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);

        CallbackManager.getInstance()
                .addCallback(CallbackType.TAG_OPEN_PUSH, new IGlobalCallback() {
                    @Override
                    public void executeCallback(@Nullable Object args) {
                        if (JPushInterface.isPushStopped(Latte.getApplicationContext())) {
                            //开启极光推送
                            JPushInterface.setDebugMode(true);
                            JPushInterface.init(Latte.getApplicationContext());
                        }
                    }
                })
                .addCallback(CallbackType.TAG_STOP_PUSH, new IGlobalCallback() {
                    @Override
                    public void executeCallback(@Nullable Object args) {
                        if (!JPushInterface.isPushStopped(Latte.getApplicationContext())) {
                            JPushInterface.stopPush(Latte.getApplicationContext());
                        }
                    }
                });

    }


}
