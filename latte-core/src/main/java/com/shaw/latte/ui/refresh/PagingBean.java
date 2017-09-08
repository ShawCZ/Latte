package com.shaw.latte.ui.refresh;

/**
 * Created by shaw on 2017/9/8.
 */

public final class PagingBean {
    //当前时第几页
    private int mPageIndex = 0;
    //总数据条数
    private int mTotal = 0;
    //一页显示多少条数据
    private int mPageSize = 0;
    //当前已经显示了几条数据
    private int mCorrentCount = 0;
    //加载延迟
    private int mDelayed = 0;

    public int getPageIndex() {
        return mPageIndex;
    }

    public PagingBean setPageIndex(int mPageIndex) {
        this.mPageIndex = mPageIndex;
        return this;
    }

    public int getTotal() {
        return mTotal;
    }

    public PagingBean setTotal(int mTotal) {
        this.mTotal = mTotal;
        return this;
    }

    public int getPageSize() {
        return mPageSize;
    }

    public PagingBean setPageSize(int mPageSize) {
        this.mPageSize = mPageSize;
        return this;
    }

    public int getCorrentCount() {
        return mCorrentCount;
    }

    public PagingBean setCorrentCount(int mCorrentCount) {
        this.mCorrentCount = mCorrentCount;
        return this;
    }

    public int getDelayed() {
        return mDelayed;
    }

    public PagingBean setDelayed(int mDelayed) {
        this.mDelayed = mDelayed;
        return this;
    }

    PagingBean addIndex(){
         mPageSize++;
        return this;
    }

}
