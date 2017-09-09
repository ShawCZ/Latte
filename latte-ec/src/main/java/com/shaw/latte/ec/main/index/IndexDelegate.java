package com.shaw.latte.ec.main.index;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.joanzapata.iconify.widget.IconTextView;
import com.shaw.latte.delegates.bottom.BottomItemDelegate;
import com.shaw.latte.ec.R;
import com.shaw.latte.ec.R2;
import com.shaw.latte.ec.main.EcBottomDelegate;
import com.shaw.latte.net.RestClient;
import com.shaw.latte.net.callback.ISuccess;
import com.shaw.latte.ui.recycler.BaseDecoration;
import com.shaw.latte.ui.recycler.MultipleFields;
import com.shaw.latte.ui.recycler.MultipleItemEntity;
import com.shaw.latte.ui.refresh.RefreshHandler;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by shaw on 2017/9/6.
 */

public class IndexDelegate extends BottomItemDelegate {

    @BindView(R2.id.rv_index)
    RecyclerView mRecyclerView = null;
    @BindView(R2.id.srl_index)
    SwipeRefreshLayout mRefreshLayout = null;
    @BindView(R2.id.tb_index)
    Toolbar mToolbar = null;
    @BindView(R2.id.icon_index_scan)
    IconTextView mIconScan = null;
    @BindView(R2.id.et_search_view)
    AppCompatEditText mSearchView = null;
    @BindView(R2.id.icon_index_message)
    IconTextView mIconMessage = null;


    private RefreshHandler mRefreshHandler = null;

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootview) {
        mRefreshHandler = RefreshHandler
                .create(mRefreshLayout, mRecyclerView, new IndexDataConverter());
    }

    //初始化，设置颜色
    private void initRefreshLayout(){
        mRefreshLayout.setColorSchemeResources(
                android.R.color.holo_blue_bright,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light
        );

        /**
        * 设置位置和显示
        * true为下拉时球变大，回弹则大变小
        * 120为启示高度
        * 300为终止高度
        * */
        mRefreshLayout.setProgressViewOffset(true,120,300);
    }

    private void initRecyclerView(){
        final GridLayoutManager manager = new GridLayoutManager(getContext(),4);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.addItemDecoration
                (BaseDecoration.create(ContextCompat.getColor(getContext(),R.color.app_background),5));
        final EcBottomDelegate ecBottomDelegate = getParentDelegate();
        mRecyclerView.addOnItemTouchListener(IndexItemClickListener.create(ecBottomDelegate));


    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        initRefreshLayout();
        initRecyclerView();
        mRefreshHandler.firstPage("http://172.25.56.76:8080/index.json");
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_index;
    }
}
