package com.shaw.fastec.example;

import com.shaw.latte.activitys.ProxyActivity;
import com.shaw.latte.delegates.LatteDelegate;

public class ExampleActivity extends ProxyActivity {

    @Override
    public LatteDelegate setRootDelegate() {
        return new ExampleDelegate();
    }
}
