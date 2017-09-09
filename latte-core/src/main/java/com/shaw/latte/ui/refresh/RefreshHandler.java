package com.shaw.latte.ui.refresh;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.shaw.latte.app.Latte;
import com.shaw.latte.net.RestClient;
import com.shaw.latte.net.callback.ISuccess;
import com.shaw.latte.ui.recycler.DataConverter;
import com.shaw.latte.ui.recycler.MultipleRecyclerAdapter;

/**
 * Created by shaw on 2017/9/6.
 */

public class RefreshHandler implements
        SwipeRefreshLayout.OnRefreshListener
        , BaseQuickAdapter.RequestLoadMoreListener {

    private final SwipeRefreshLayout REFRESH_LAYOUT;
    private final PagingBean BEAN;
    private final RecyclerView RECYCLERVIEW;
    private MultipleRecyclerAdapter mAdapter = null;
    private final DataConverter CONVERTER;

    private RefreshHandler(SwipeRefreshLayout refresh_layout,
                           RecyclerView recyclerview,
                           DataConverter converter,
                           PagingBean bean) {
        this.REFRESH_LAYOUT = refresh_layout;
        this.BEAN = bean;
        this.RECYCLERVIEW = recyclerview;
        this.CONVERTER = converter;
        this.REFRESH_LAYOUT.setOnRefreshListener(this);
    }

    //简单工厂模式
    public static RefreshHandler create(SwipeRefreshLayout swipeRefreshLayout,
                                        RecyclerView recyclerView, DataConverter converter) {
        return new RefreshHandler(swipeRefreshLayout, recyclerView, converter, new PagingBean());
    }


    private void refresh() {
        //开始加载
        REFRESH_LAYOUT.setRefreshing(true);

        Latte.getHandler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //进行网络请求，把下面这个方法放到onSuccess里面，完成下拉刷新
                REFRESH_LAYOUT.setRefreshing(false);
            }
        }, 2000);
    }

    //第一页数据
    public void firstPage(String url) {
        BEAN.setDelayed(1000);
        RestClient.bulider()
                .url(url)
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        final JSONObject object = JSON.parseObject(response);
                        BEAN.setTotal(object.getInteger("total"))
                                .setPageSize(object.getInteger("page_size"));
                        //设置Adapter
                        mAdapter = MultipleRecyclerAdapter.create(CONVERTER.setJsonData(response));
                        mAdapter.setOnLoadMoreListener(RefreshHandler.this,RECYCLERVIEW);
                        RECYCLERVIEW.setAdapter(mAdapter);
                        BEAN.addIndex();
                    }
                })
                .bulid()
                .get();
    }

    @Override
    public void onRefresh() {
        refresh();
    }

    @Override
    public void onLoadMoreRequested() {

    }
}
