package com.bwei.czx.czx1102study2;

import android.app.Application;
import android.content.Context;

/**
 * Created by czx on 2017/11/2.
 */

public class MyApplication extends Application{
    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }
    public static Context getContext(){
        return context;
    }
}
