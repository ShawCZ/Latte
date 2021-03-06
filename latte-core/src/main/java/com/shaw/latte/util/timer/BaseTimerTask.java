package com.shaw.latte.util.timer;

import com.shaw.latte.net.interceptors.BaseInterceptor;

import java.util.TimerTask;

/**
 * Created by shaw on 2017/9/1.
 */

public class BaseTimerTask extends TimerTask {

    private ITimerListener mITimerListener = null;

    public BaseTimerTask(ITimerListener iTimerListener){
        this.mITimerListener = iTimerListener;
    }

    @Override
    public void run() {
        if (mITimerListener != null){
            mITimerListener.onTimer();
        }
    }
}
