package com.shaw.fastec.example.generators;

import com.shaw.latte.annotations.AppRegisterGenerator;
import com.shaw.latte.wechat.templates.AppRegisterTemplate;

/**
 * Created by shaw on 2017/9/5.
 */

@AppRegisterGenerator(
        packageName = "com.shaw.fastec.example",
        registerTemplate = AppRegisterTemplate.class
)
public interface AppRegister {
}
