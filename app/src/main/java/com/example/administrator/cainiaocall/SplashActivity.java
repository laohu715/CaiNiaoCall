package com.example.administrator.cainiaocall;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sp = getPreferences(MODE_PRIVATE);
                boolean isFirst = sp.getBoolean("isFirst", true);
                Intent intent = new Intent();
                if (isFirst) {  //第一次进行判断进入引导页
                    sp.edit().putBoolean("isFirst", false).commit();
                    intent.setClass(SplashActivity.this, GuideActivity.class);
                } else {   //否则进入主页
                    intent.setClass(SplashActivity.this, MainActivity.class);
                }
                startActivity(intent);
                //设置界面之间的切换动画
//                overridePendingTransition(R。);
                finish();
            }
        }, 1000);
    }
}
