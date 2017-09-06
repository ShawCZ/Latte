package com.shaw.latte.app;

import com.shaw.latte.util.storage.LattePreference;

/**
 * Created by shaw on 2017/9/5.
 * 管理用户信息
 */

public class AccountManger {

    private enum SignTag{
        SIGN_TAG
    }

    public static void setSignState(boolean state){
        LattePreference.setAppFlag(SignTag.SIGN_TAG.name(),state);
    }

    private static boolean isSignIn(){
        return LattePreference.getAppFlag(SignTag.SIGN_TAG.name());
    }

    public static void checkAccount(IUserChecker checker){
        if (isSignIn()){
            checker.onSignIn();
        }else {
            checker.onNotSignIn();
        }
    }
}
