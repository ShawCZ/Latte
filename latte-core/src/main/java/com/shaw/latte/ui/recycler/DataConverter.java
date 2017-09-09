package com.shaw.latte.ui.recycler;

import java.util.ArrayList;

/**
 * Created by shaw on 2017/9/8.
 */

public abstract class DataConverter {

    protected final ArrayList<MultipleItemEntity> ENTITIES = new ArrayList<>();
    private String mJsonData = null;

    public abstract ArrayList<MultipleItemEntity> convert();

    public DataConverter setJsonData(String json) {
        this.mJsonData = json;
        return this;
    }

    //判断，必须要有数据才能return数据
    protected String getJsonData() {
        if (mJsonData == null || mJsonData.isEmpty()) {
            throw new NullPointerException("DATA IS BULL!!!");
        }
        return mJsonData;
    }
}
