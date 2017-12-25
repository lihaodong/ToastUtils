package com.lihaodong.toast.sample;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.lihaodong.toast.HToast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.bt_error).setOnClickListener(this);
        findViewById(R.id.bt_nomal).setOnClickListener(this);
        findViewById(R.id.bt_success).setOnClickListener(this);
        findViewById(R.id.bt_war).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_error:
                HToast.error("我错了");
                break;
            case R.id.bt_nomal:
                HToast.normal("我正常了");
                break;
            case R.id.bt_success:
                HToast.success("我成功了");
                break;
            case R.id.bt_war:
                HToast.warning("我警告了");
                break;
        }
    }
}
