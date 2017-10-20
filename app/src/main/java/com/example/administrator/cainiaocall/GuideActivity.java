package com.example.administrator.cainiaocall;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/*
引导界面
*/
public class GuideActivity extends AppCompatActivity {
    //获取图片资源
    private ViewPager mViewPager;
    int[] imgs = new int[]{R.drawable.meijing,R.drawable.mei};
    List<View> viewList = new ArrayList<>();
    private Button mBtnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
//        it文件夹修改了东西
//        点点滴滴
        initData();
        mBtnStart = (Button) findViewById(R.id.btn_start);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mViewPager.setAdapter(new myPageAdapter());
        mViewPager.setOnPageChangeListener(new myPagerListener());
        mBtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GuideActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    //初始化数据
    private void initData() {
        for (int i = 0; i < imgs.length; i++) {
            View view = getLayoutInflater().inflate(R.layout.guide_item, null);
            ImageView item_iv = (ImageView) view.findViewById(R.id.guide_item_iv);
            item_iv.setImageResource(imgs[i]);
            viewList.add(item_iv);
        }

    }

    //    引导页viewpager适配器
    class myPageAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return imgs.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = viewList.get(position);
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(viewList.remove(position));
        }
    }

    class myPagerListener implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        //滑动到第几页
        @Override
        public void onPageSelected(int position) {
            if (position == viewList.size() - 1) {
                mBtnStart.setVisibility(View.VISIBLE);
                //加载动画
                Animation animation = AnimationUtils.loadAnimation(GuideActivity.this, R.anim.btnanim);
                mBtnStart.startAnimation(animation);



                
            } else {
                mBtnStart.setVisibility(View.GONE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }
    }

}
