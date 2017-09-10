package com.shaw.latte.ec.main.sort;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.shaw.latte.delegates.bottom.BottomItemDelegate;
import com.shaw.latte.ec.R;
import com.shaw.latte.ec.main.sort.content.ContentDelegate;
import com.shaw.latte.ec.main.sort.list.VerticalListDelegate;

/**
 * Created by shaw on 2017/9/6.
 */

public class SortDelegate extends BottomItemDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_sort;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootview) {

    }

    /**
     * 当点开分类的时候，布局才开始渲染，如果放在onBindView里，
     * 在打开主页的时候，就已经开始渲染了
     */
    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        final VerticalListDelegate listDelegate = new VerticalListDelegate();

        getSupportDelegate().loadRootFragment(R.id.vertical_list_container,listDelegate);
        //设置右侧第一个分类显示，默认显示分类一
        getSupportDelegate().loadRootFragment(R.id.sort_content_container,ContentDelegate.newInstance(1));
    }
}
