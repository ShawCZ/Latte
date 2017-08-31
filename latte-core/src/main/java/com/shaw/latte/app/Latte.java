package com.shaw.latte.app;

import android.content.Context;

import java.util.HashMap;

/**
 * Created by shaw on 2017/8/30.
 */

public final class Latte {

    public static Configurator init(Context context){
        getCongigurations().put(ConfigType.APPLICATION_CONTEXT.name(),context.getApplicationContext());
        return Configurator.getInstance();
    }

    public static HashMap<String,Object> getCongigurations(){
        return Configurator.getInstance().getLatteConfigs();
    }

    public static Context getApplication(){
        return (Context) getCongigurations().get(ConfigType.APPLICATION_CONTEXT.name());
    }
}
