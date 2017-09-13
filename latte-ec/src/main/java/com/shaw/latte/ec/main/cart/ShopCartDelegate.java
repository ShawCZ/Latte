package com.shaw.latte.ec.main.cart;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.shaw.latte.delegates.bottom.BottomItemDelegate;
import com.shaw.latte.ec.R;
import com.shaw.latte.ec.R2;
import com.shaw.latte.net.RestClient;
import com.shaw.latte.net.callback.ISuccess;
import com.shaw.latte.ui.recycler.MultipleItemEntity;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by shaw on 2017/9/6.
 */

public class ShopCartDelegate extends BottomItemDelegate implements ISuccess {

    @BindView(R2.id.rv_shop_cart)
    RecyclerView mRecyvlerView = null;

    private ShopCartAdapter mAdapter = null;

    @Override
    public Object setLayout() {
        return R.layout.delegate_shop_cart;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootview) {

    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        RestClient.builder()
                .url("shop_cart")
                .loader(getContext())
                .success(this)
                .build()
                .get();
    }

    @Override
    public void onSuccess(String response) {
        final ArrayList<MultipleItemEntity > data =
                new ShopCartDataConverter()
                        .setJsonData(response)
                        .convert();
        mAdapter = new ShopCartAdapter(data);
        final LinearLayoutManager manager = new LinearLayoutManager(getContext());
        mRecyvlerView.setLayoutManager(manager);
        mRecyvlerView.setAdapter(mAdapter);
    }
}
