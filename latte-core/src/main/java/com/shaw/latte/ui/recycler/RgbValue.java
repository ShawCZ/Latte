package com.shaw.latte.ui.recycler;

import com.google.auto.value.AutoValue;

/**
 * Created by shaw on 2017/9/9.
 */

@AutoValue
public abstract class RgbValue {

    public abstract int red();

    public abstract int green();

    public abstract int blue();

    public static RgbValue create(int red,int greeen,int blue){
        return new AutoValue_RgbValue(red,greeen,blue);
    }
}
