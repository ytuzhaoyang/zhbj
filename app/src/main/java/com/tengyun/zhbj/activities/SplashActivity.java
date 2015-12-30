package com.tengyun.zhbj.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;

import com.tengyun.zhbj.R;
import com.tengyun.zhbj.utils.SharePreferenceUtils;

public class SplashActivity extends AppCompatActivity implements Animation.AnimationListener {

    private static final String FIRST = "first";
    private RelativeLayout mRelativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去除状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);


        mRelativeLayout = (RelativeLayout) findViewById(R.id.rl_root_splash);
        // 处理动画
        initAnim();

    }

    private void initAnim() {
        //旋转动画
        RotateAnimation rotateAnimation = new RotateAnimation(
                0,
                360,
                Animation.RELATIVE_TO_SELF,
                0.5f,
                Animation.RELATIVE_TO_SELF,
                0.5f
        );
        //动画时间
        rotateAnimation.setDuration(1500);
        //保持结束后的状态
        rotateAnimation.setFillAfter(true);

        //缩放动画,相对于中心缩放
        ScaleAnimation scaleAnimation = new ScaleAnimation(
                0,
                1.0f,
                0,
                1.0f,
                Animation.RELATIVE_TO_SELF,
                0.5f,
                Animation.RELATIVE_TO_SELF,
                0.5f
        );
        scaleAnimation.setDuration(1500);
        scaleAnimation.setFillAfter(true);

        //透明度
        AlphaAnimation alphaAnimation = new AlphaAnimation(0f, 1f);
        alphaAnimation.setDuration(1500);
        alphaAnimation.setFillAfter(true);

        //参数代表是否共用插补器
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(rotateAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(alphaAnimation);
        mRelativeLayout.startAnimation(animationSet);

        animationSet.setAnimationListener(this);
    }

    //动画监听的回调方法

    /**
     * 动画开始
     *
     * @param animation
     */
    @Override
    public void onAnimationStart(Animation animation) {

    }

    /**
     * 动画结束
     *
     * @param animation
     */
    @Override
    public void onAnimationEnd(Animation animation) {

        //动画结束后，等待一会，再进行页面跳转
        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(1000);
                // 做页面跳转
                doNavgation();
            }
        }).start();


    }

    private void doNavgation() {
        //判断是否是第一次进入，第一次进入则跳转引导页面，否则直接进入主页面
        boolean first = SharePreferenceUtils.getBoolean(this, FIRST, true);
        if (first) {
            Log.d("SplashActivity", "第一次进入 ");
            //第一次进入,进入引导页
            startActivity(new Intent(SplashActivity.this, GuidActivity.class));
        } else {
            //不是第一次
            Log.d("SplashActivity", "不是第一次 ");
        }
        finish();
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
