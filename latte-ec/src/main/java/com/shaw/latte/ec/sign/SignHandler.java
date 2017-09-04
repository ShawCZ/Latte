package com.shaw.latte.ec.sign;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shaw.latte.ec.database.DatabaseManger;
import com.shaw.latte.ec.database.UserProfile;

/**
 * Created by shaw on 2017/9/2.
 */

public class SignHandler {

    public static void onSignJson (String response){
        final JSONObject profileJson = JSON.parseObject(response).getJSONObject("data");
        final long userId = profileJson.getLong("userId");
        final String name = profileJson.getString("name");
        final String avatar = profileJson.getString("avatar");
        final String gender = profileJson.getString("gender");
        final String adress = profileJson.getString("adress");

        final UserProfile profile = new UserProfile(userId,name,avatar,gender,adress);
        DatabaseManger.getInstance().getDao().insert(profile);
    }
}
