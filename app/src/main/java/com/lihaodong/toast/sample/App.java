package com.lihaodong.toast.sample;

import android.app.Application;

import com.lihaodong.toast.HToast;

/**
 * Created by lihaodong on 2017/12/22.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        HToast.newBuilder(this)
                .build();
    }
}
