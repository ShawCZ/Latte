package com.shaw.latte.ec.main.personal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.shaw.latte.delegates.bottom.BottomItemDelegate;
import com.shaw.latte.ec.R;

/**
 * Created by shaw on 2017/9/6.
 */

public class PersonalDelagate extends BottomItemDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_personal;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootview) {

    }
}
