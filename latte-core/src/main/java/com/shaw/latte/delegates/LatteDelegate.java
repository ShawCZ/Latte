package com.shaw.latte.delegates;

/**
 * Created by shaw on 2017/8/31.
 */

public abstract class LatteDelegate extends PermissionCheckerDelegate {

    @SuppressWarnings("unchecked")
    public <T extends LatteDelegate> T getParentDelegate(){
        return (T)getParentFragment();
    }
}
