package com.example.administrator.cainiaocall;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.cainiaocall.TabhostFragment.AroundFragment;
import com.example.administrator.cainiaocall.TabhostFragment.HomeFragment;
import com.example.administrator.cainiaocall.TabhostFragment.MineFragment;
import com.example.administrator.cainiaocall.TabhostFragment.MoreFragment;

public class MainActivity extends AppCompatActivity {

Class[]fragmentNums=new Class[]{HomeFragment.class, AroundFragment.class, MineFragment.class,
        MoreFragment.class};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentTabHost tabHost = (FragmentTabHost) findViewById(R.id.main_tabhose);
        tabHost.setup(MainActivity.this,getSupportFragmentManager(),android.R.id.tabcontent);
        for (int i = 0; i <fragmentNums.length ; i++) {
            tabHost.addTab(tabHost.newTabSpec("").setIndicator("tab"+i),fragmentNums[i],null);
        }

    }
}
