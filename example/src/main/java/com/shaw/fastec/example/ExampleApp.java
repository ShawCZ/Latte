package com.shaw.fastec.example;

import android.app.Application;

import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.shaw.latte.app.Latte;
import com.shaw.latte.ec.Icon.FontEcModule;

/**
 * Created by shaw on 2017/8/30.
 */

public class ExampleApp extends Application{

    @Override
    public void onCreate(){
        super.onCreate();
        Latte.init(this)
                .withIcon(new FontAwesomeModule())
                .withIcon(new FontEcModule())
                .withApiHost("http://127.0.0.1/")
                .configure();
    }
}
