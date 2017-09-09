package com.shaw.latte.ec.main.sort.list;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.shaw.latte.delegates.LatteDelegate;
import com.shaw.latte.ec.R;

/**
 * Created by shaw on 2017/9/9.
 */

public class VerticalListDelegate  extends LatteDelegate{
    @Override
    public Object setLayout() {
        return R.layout.delegate_vertical_list;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootview) {

    }
}
