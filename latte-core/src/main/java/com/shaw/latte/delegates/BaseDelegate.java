package com.shaw.latte.delegates;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shaw.latte.activitys.ProxyActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation_swipeback.SwipeBackFragment;

/**
 * Created by shaw on 2017/8/31.
 */

public abstract class BaseDelegate extends SwipeBackFragment {

    @SuppressWarnings("SpellCheckingInspection")
    private Unbinder mUnbinder = null;

    public abstract Object setLayout();

    public abstract void onBindView(@Nullable Bundle savedInstanceState,View rootview);

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootview ;
        if (setLayout() instanceof Integer){
            rootview = inflater.inflate((Integer) setLayout(),container,false);
        }else if (setLayout() instanceof View){
            rootview = (View)setLayout();
        }else {
            throw new ClassCastException("setLayout() type must be int or View");
        }

        //使用ButterKnife绑定视图
        mUnbinder = ButterKnife.bind(this,rootview);
        onBindView(savedInstanceState,rootview);

        return rootview;
    }

    public final ProxyActivity getProxyActivity(){
        return (ProxyActivity) _mActivity;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mUnbinder != null){
            mUnbinder.unbind();
        }
    }
}
