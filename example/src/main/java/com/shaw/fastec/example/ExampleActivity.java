package com.shaw.fastec.example;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;

import com.shaw.latte.activitys.ProxyActivity;
import com.shaw.latte.delegates.LatteDelegate;
import com.shaw.latte.ec.launcher.LauncherDelegate;
import com.shaw.latte.ec.launcher.LauncherScrollDelegate;
import com.shaw.latte.ec.sign.SignUpDelegate;

public class ExampleActivity extends ProxyActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.hide();
        }
    }

    @Override
    public LatteDelegate setRootDelegate() {
        return new ExampleDelegate();
    }
}
