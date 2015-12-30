package com.tengyun.zhbj.activities;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.ImageView;

import com.tengyun.zhbj.R;
import com.tengyun.zhbj.adapters.GuidPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class GuidActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    private ViewPager mViewPager;
    private List<ImageView> mListData;
    private GuidPagerAdapter mGuidPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去掉状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_guid);
        initView();
        initData();
    }

    /**
     * 初始化数据
     */
    private void initData() {
        int[] imgRes = new int[] {
                R.mipmap.guide_1,
                R.mipmap.guide_2,
                R.mipmap.guide_3
        };

        mListData = new ArrayList<ImageView>();
        ImageView imageView;
        for (int i = 0; i < imgRes.length; i++) {
            imageView = new ImageView(this);
            imageView.setImageResource(imgRes[i]);
            mListData.add(imageView);
        }

        mGuidPagerAdapter = new GuidPagerAdapter(this);
        mGuidPagerAdapter.addAll(mListData);
        mViewPager.setAdapter(mGuidPagerAdapter);

        mViewPager.addOnPageChangeListener(this);
    }

    /**
     * 初始化界面
     */
    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.pager_guid);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
