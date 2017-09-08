package com.shaw.latte.delegates.bottom;

/**
 * Created by shaw on 2017/9/6.
 */

public final class BottomTabBean {

    //变量定义为final类型，在构造函数里面传值赋值，可以防止多线程中的问题
    private final CharSequence ICON;
    private final CharSequence TITLE;

    public BottomTabBean(CharSequence icon, CharSequence title) {
        this.ICON = icon;
        this.TITLE = title;
    }

    public CharSequence getIcon() {
        return ICON;
    }

    public CharSequence getTitle() {
        return TITLE;
    }
}
