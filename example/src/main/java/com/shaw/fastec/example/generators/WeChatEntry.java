package com.shaw.fastec.example.generators;

import com.shaw.latte.annotations.EntryGenerator;
import com.shaw.latte.wechat.templates.WXEntryTemplate;

/**
 * Created by shaw on 2017/9/5.
 */

@EntryGenerator(
        packageName = "com.shaw.fastec.example",
        entryTemplate = WXEntryTemplate.class
)
public interface WeChatEntry {
}
