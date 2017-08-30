package com.shaw.latte.app;

import java.util.WeakHashMap;

/**
 * Created by shaw on 2017/8/30.
 */

public class Configurator {

    private static final WeakHashMap<String,Object> LATTE_CONFIGS = new WeakHashMap<>();

    //配置开始了，但是还没配置完
    private Configurator(){
        LATTE_CONFIGS.put(ConfigType.CONFIG_READY.name(),false);
    }

    public static Configurator getInstance(){
        return Holder.INSTANCE;
    }

    final WeakHashMap<String,Object> getLatteConfigs(){
        return LATTE_CONFIGS;
    }
    //线程安全的懒汉单例模式
    private static class Holder{
        private static final Configurator INSTANCE = new Configurator();
    }

    //配置结束
    public final void configure(){
        LATTE_CONFIGS.put(ConfigType.CONFIG_READY.name(),true);
    }

    public final Configurator withApiHost(String host){
        LATTE_CONFIGS.put(ConfigType.API_HOST.name(),host);
        return this;
    }

    private void checkConfiguration(){
        final boolean isReady = (boolean)LATTE_CONFIGS.get(ConfigType.CONFIG_READY.name());
        if (!isReady){
            throw new RuntimeException("Configuration is not read,call configure");
        }
    }

    final <T> T getConfigurtion(Enum<ConfigType> key){
        checkConfiguration();
        return (T)LATTE_CONFIGS.get(key.name());
    }
}
