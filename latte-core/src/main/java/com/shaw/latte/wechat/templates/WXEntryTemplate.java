package com.shaw.latte.wechat.templates;

import com.shaw.latte.activitys.ProxyActivity;
import com.shaw.latte.delegates.LatteDelegate;
import com.shaw.latte.wechat.BaseWXEntryActivity;
import com.shaw.latte.wechat.LatteWeChat;

/**
 * Created by shaw on 2017/9/5.
 */

public class WXEntryTemplate extends BaseWXEntryActivity {

    @Override
    protected void onResume() {
        super.onResume();
        finish();
        overridePendingTransition(0,0);
    }

    @Override
    protected void onSignInSuccess(String userInfo) {
        LatteWeChat.getInstance().getSignInCallback().onSignInSuccess(userInfo);
    }
}
