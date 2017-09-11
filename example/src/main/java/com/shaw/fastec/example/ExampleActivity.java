package com.shaw.fastec.example;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.widget.Toast;

import com.shaw.latte.activitys.ProxyActivity;
import com.shaw.latte.app.Latte;
import com.shaw.latte.delegates.LatteDelegate;
import com.shaw.latte.ec.launcher.LauncherDelegate;
import com.shaw.latte.ec.launcher.LauncherScrollDelegate;
import com.shaw.latte.ec.main.EcBottomDelegate;
import com.shaw.latte.ec.main.index.IndexDelegate;
import com.shaw.latte.ec.sign.ISignListener;
import com.shaw.latte.ec.sign.SignInDelegate;
import com.shaw.latte.ec.sign.SignUpDelegate;
import com.shaw.latte.ui.launcher.ILauncherListener;
import com.shaw.latte.ui.launcher.OnLauncherFinishTag;

import qiu.niorgai.StatusBarCompat;

public class ExampleActivity extends ProxyActivity implements
        ISignListener,
        ILauncherListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //隐藏ActionBar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        Latte.getConfigurator().withActivity(this);
        //设置为沉浸式状态栏
        StatusBarCompat.translucentStatusBar(this,true);
    }

    @Override
    public LatteDelegate setRootDelegate() {
        return new LauncherDelegate();
    }

    @Override
    public void onSignInSuccess() {
        startWithPop(new EcBottomDelegate());
        Toast.makeText(this,"登陆成功",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onSignUpSuccess() {
        startWithPop(new EcBottomDelegate());
        Toast.makeText(this,"注册成功",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onLauncherFinish(OnLauncherFinishTag tag) {
        switch (tag){
            case SIGNED:
                Toast.makeText(this,"启动结束，用户登录了",Toast.LENGTH_SHORT).show();
                startWithPop(new EcBottomDelegate());
                break;
            case NOT_SIGNED:
                Toast.makeText(this,"启动结束，用户没有登录",Toast.LENGTH_SHORT).show();
                startWithPop(new SignInDelegate());
                break;
            default:
                break;
        }
    }
}
