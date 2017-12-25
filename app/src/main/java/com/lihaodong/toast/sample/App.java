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
//                .setTextColor(R.color.white)
//                .setErrorBgColor(R.color.htoast_error)
//                .setSuccessBgColor(R.color.htoast_success)
//                .setErrorIcon(R.drawable.htoast_error)
//                .setSuccessIcon(R.drawable.htoast_success)
//                .setShowIcon(false)
//                .setDuration(1000)
                .build();
    }
}
