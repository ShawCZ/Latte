package com.shaw.latte.ec.pay;

import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.alibaba.fastjson.JSON;
import com.shaw.latte.delegates.LatteDelegate;
import com.shaw.latte.ec.R;
import com.shaw.latte.net.RestClient;
import com.shaw.latte.net.callback.ISuccess;
import com.shaw.latte.util.log.LatteLogger;

/**
 * Created by shaw on 2017/9/14.
 */

public class FastPay implements View.OnClickListener {

    //设置支付回调监听
    private IAlPayResultListener mAlPayResultListener = null;
    private Activity mActivity = null;

    private AlertDialog mDialog = null;
    private int mOrderID = -1;

    private FastPay(LatteDelegate delegate) {
        this.mActivity = delegate.getProxyActivity();
        this.mDialog = new AlertDialog.Builder(delegate.getContext()).create();
    }

    public static FastPay create(LatteDelegate delegate) {
        return new FastPay(delegate);
    }

    public void beginPayDialog() {
        mDialog.show();
        final Window window = mDialog.getWindow();
        if (window != null) {
            window.setContentView(R.layout.dialog_pay_panel);
            window.setGravity(Gravity.BOTTOM);
            window.setWindowAnimations(R.style.anim_panel_up_from_bottom);
            window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            //设置属性
            final WindowManager.LayoutParams params = window.getAttributes();
            params.width = WindowManager.LayoutParams.MATCH_PARENT;
            params.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
            window.setAttributes(params);

            window.findViewById(R.id.btn_dialog_pay_cancel).setOnClickListener(this);
            window.findViewById(R.id.icon_dialog_pay_alpay).setOnClickListener(this);
            window.findViewById(R.id.icon_dialog_pay_alpay).setOnClickListener(this);
        }
    }

    public FastPay setPayResultListener(IAlPayResultListener listener) {
        this.mAlPayResultListener = listener;
        return this;
    }

    public FastPay setPayOrderID(int orderId) {
        this.mOrderID = orderId;
        return this;
    }

    public final void alPay(int orderId) {
        //签名串
        final String singUrl = "";
        //获取签名字符串
        RestClient.builder()
                .url(singUrl)
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        final String paySign = JSON.parseObject(response).getString("result");
                        LatteLogger.d("PAY_SIGN", paySign);
                        //必须是异步的调用客户端支付接口
                        final PayAsyncTask payAsyncTask = new PayAsyncTask(mActivity, mAlPayResultListener);
                        payAsyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, paySign);
                    }
                })
                .build()
                .post();
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_dialog_pay_cancel) {
            alPay(mOrderID);
            mDialog.cancel();
        } else if (id == R.id.icon_dialog_pay_alpay) {
            mDialog.cancel();
        } else if (id == R.id.icon_dialog_pay_wechat) {
            mDialog.cancel();
        }
    }
}
