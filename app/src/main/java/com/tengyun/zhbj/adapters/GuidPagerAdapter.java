package com.tengyun.zhbj.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Administrator on 2015/12/29.
 */
public class GuidPagerAdapter extends PagerAdapter {

    private Context context;
    private List<ImageView> list;

    public GuidPagerAdapter(Context context) {
        this.context = context;
        list = new ArrayList<ImageView>();
    }

    public void addAll(Collection<? extends ImageView> collection){
        list.addAll(collection);
    }

    @Override
    public int getCount() {
        if (list != null){
            return list.size();
        }
        return 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = list.get(position);
        //将控件添加到ViewPa中
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //将控件从ViewPager中移出
        container.removeView(list.get(position));
    }
}
