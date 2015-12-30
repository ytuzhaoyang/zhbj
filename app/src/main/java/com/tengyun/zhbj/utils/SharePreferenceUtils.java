package com.tengyun.zhbj.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2015/12/29.
 */
public class SharePreferenceUtils {

    private static final String SP_NAME = "zh_config";
    private static SharedPreferences mSharedPreferences;

    /**
     * 获取SharedPreferences对象，这样只会创建一次对象
     * @param context
     * @return
     */
    private static SharedPreferences getSp(Context context){
        if (mSharedPreferences == null){
            mSharedPreferences = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        }
        return mSharedPreferences;
    }

    /**
     * 获取boolean类型的值,默认返回false
     * @param context
     * @param key  参数名称
     * @return
     */
    public static boolean getBoolean(Context context, String key){
        SharedPreferences sp = getSp(context);
        boolean result = sp.getBoolean(key, false);
        return result;
    }

    /**
     * 获取boolean类型的值,并指定默认返回值
     * @param context
     * @param key
     * @param defaultVale  默认返回值
     * @return
     */
    public static boolean getBoolean(Context context, String key, boolean defaultVale){
        SharedPreferences sp = getSp(context);
        boolean result = sp.getBoolean(key, defaultVale);
        return result;
    }

}
