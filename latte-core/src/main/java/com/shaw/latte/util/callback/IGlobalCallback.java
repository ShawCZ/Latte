package com.shaw.latte.util.callback;

import android.support.annotation.Nullable;

/**
 * Created by Shaw
 */

public interface IGlobalCallback<T> {

    void executeCallback(@Nullable T args);
}
