package com.shaw.latte.ec.Icon;

import com.joanzapata.iconify.Icon;

/**
 * Created by shaw on 2017/8/31.
 */

public enum EcIcons implements Icon {
    //自己加入的字体
    icon_scan('\ue67e'),
    icon_ali_pay('\ue67c');

    private char character;

    EcIcons(char character) {
        this.character = character;
    }

    @Override
    public String key() {
        return name().replace('_','-');
    }

    @Override
    public char character() {
        return character;
    }
}
