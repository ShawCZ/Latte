package com.shaw.fastec.example.generators;

import com.shaw.latte.annotations.PayEntryGenerator;
import com.shaw.latte.wechat.templates.WXPayEntryTemplate;

/**
 * Created by shaw on 2017/9/5.
 */

@PayEntryGenerator(
        packageName = "com.shaw.fastec.example",
        payEntryTemplate = WXPayEntryTemplate.class
)
public interface WeChatPayEntry {
}
