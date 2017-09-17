package com.shaw.latte.ec.pay;

/**
 * Created by shaw on 2017/9/14.
 */

public interface IAlPayResultListener {

    void onPaySuccess();

    void onPaying();

    void onPayFail();

    void onPayCancel();

    void onPayConnectError();
}
