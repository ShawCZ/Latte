package com.shaw.latte.util;

import android.content.res.Resources;
import android.util.DisplayMetrics;

import com.shaw.latte.app.Latte;

/**
 * Created by shaw on 2017/8/31.
 */

public class DimenUtil {
    public static int getScreenWidth(){
        final Resources resources = Latte.getApplication().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.widthPixels;
    }

    public static int getScreenHeight(){
        final Resources resources = Latte.getApplication().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.heightPixels;
    }
}
