package com.shaw.latte.ec.launcher;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.shaw.latte.app.AccountManger;
import com.shaw.latte.app.IUserChecker;
import com.shaw.latte.delegates.LatteDelegate;
import com.shaw.latte.ec.R;
import com.shaw.latte.ui.launcher.ILauncherListener;
import com.shaw.latte.ui.launcher.LauncherHolderCreator;
import com.shaw.latte.ui.launcher.OnLauncherFinishTag;
import com.shaw.latte.ui.launcher.ScrollLauncherTag;
import com.shaw.latte.util.storage.LattePreference;

import java.util.ArrayList;

/**
 * Created by shaw on 2017/9/2.
 */

public class LauncherScrollDelegate extends LatteDelegate implements OnItemClickListener{

    private ConvenientBanner<Integer> mConvenientBanner = null;
    private static final ArrayList<Integer> INTEGERS = new ArrayList<>();
    private ILauncherListener mILauncherListener = null;

    private void initBanner(){
        INTEGERS.add(R.mipmap.launcher_01);
        INTEGERS.add(R.mipmap.launcher_02);
        INTEGERS.add(R.mipmap.launcher_03);
        INTEGERS.add(R.mipmap.launcher_04);
        INTEGERS.add(R.mipmap.launcher_05);

        mConvenientBanner
                .setPages(new LauncherHolderCreator(),INTEGERS)
                .setPageIndicator(new int[]{R.drawable.dot_normal,R.drawable.dot_focus})
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
                .setOnItemClickListener(this)
                .setCanLoop(false);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof ILauncherListener){
            mILauncherListener = (ILauncherListener)activity;
        }

    }

    @Override
    public Object setLayout() {
        mConvenientBanner = new ConvenientBanner<Integer>(getContext());
        return mConvenientBanner;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootview) {
        initBanner();
    }

    @Override
    public void onItemClick(int position) {
        //如果点击的是最后一个滑动图片
        if (position == INTEGERS.size()-1){
            LattePreference.setAppFlag(ScrollLauncherTag.HAS_FIRST_LAUNCHER_APP.name(),true);
            //检查用户是否已经登陆
            AccountManger.checkAccount(new IUserChecker() {
                @Override
                public void onSignIn() {
                    if(mILauncherListener !=null){
                        mILauncherListener.onLauncherFinish(OnLauncherFinishTag.SIGNED);
                    }
                }

                @Override
                public void onNotSignIn() {
                    if(mILauncherListener !=null){
                        mILauncherListener.onLauncherFinish(OnLauncherFinishTag.NOT_SIGNED);
                    }
                }
            });
        }
    }
}
