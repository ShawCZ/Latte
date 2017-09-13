package com.shaw.latte.ec.main;

import android.graphics.Color;

import com.shaw.latte.delegates.bottom.BaseBottomDelegate;
import com.shaw.latte.delegates.bottom.BottomItemDelegate;
import com.shaw.latte.delegates.bottom.BottomTabBean;
import com.shaw.latte.delegates.bottom.ItemBuilder;
import com.shaw.latte.ec.main.cart.ShopCartDelegate;
import com.shaw.latte.ec.main.discover.DiscoverDelegate;
import com.shaw.latte.ec.main.index.IndexDelegate;
import com.shaw.latte.ec.main.personal.PersonalDelagate;
import com.shaw.latte.ec.main.sort.SortDelegate;

import java.util.LinkedHashMap;

/**
 * Created by shaw on 2017/9/6.
 */

public class EcBottomDelegate extends BaseBottomDelegate {
    @Override
    public LinkedHashMap<BottomTabBean, BottomItemDelegate> setItems(ItemBuilder builder) {
        final LinkedHashMap<BottomTabBean, BottomItemDelegate> items = new LinkedHashMap<>();
        items.put(new BottomTabBean("{fa-home}","主页"),new IndexDelegate());
        items.put(new BottomTabBean("{fa-sort}","分类"),new SortDelegate());
        items.put(new BottomTabBean("{fa-shopping-cart}","购物车"),new ShopCartDelegate());
        items.put(new BottomTabBean("{fa-user}","我的"),new PersonalDelagate());
        return builder.addItems(items).build();
    }

    @Override
    public int setIndexDelegate() {
        return 0;
    }

    @Override
    public int setClickedColor() {
        return Color.parseColor("#ffff8800");
    }
}
