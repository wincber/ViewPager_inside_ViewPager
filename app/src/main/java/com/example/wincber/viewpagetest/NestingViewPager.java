package com.example.wincber.viewpagetest;

import android.content.Context;
import android.graphics.PointF;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by wincber on 9/15/2016.
 */
public class NestingViewPager extends ViewPager {
    PointF downF = new PointF();
    PointF curF = new PointF();
    OnTouchListener onTouchListener;
    public NestingViewPager(Context context) {
        super(context);
    }
    public NestingViewPager(Context context, AttributeSet attributeSet)
    {
        super(context,attributeSet);
    }
    @Override
    public boolean onInterceptTouchEvent(MotionEvent arg0)
    {
        return true;
    }
    @Override
    public boolean onTouchEvent(MotionEvent arg0) {
        curF.x = arg0.getX();
        curF.y = arg0.getY();

        if(arg0.getAction() == MotionEvent.ACTION_DOWN) {
            downF.x = arg0.getX();
            downF.y = arg0.getY();
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        if(arg0.getAction() == MotionEvent.ACTION_MOVE) {
            curF.x =arg0.getX();
            curF.y=arg0.getY();
            if(Math.abs(curF.x-downF.x) > Math.abs(curF.y - downF.y)) {
                if(curF.x > downF.x) { //右划
                    if (getCurrentItem() == 0) {//第一个页面，需要父控件拦截
                        getParent().requestDisallowInterceptTouchEvent(false);
                    }
                } else {//左划
                    if (getCurrentItem() == getAdapter().getCount() - 1) {//最后一个页面，需要拦截
                        getParent().requestDisallowInterceptTouchEvent(false);
                    }
                }
            }else {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
        }
        return super.onTouchEvent(arg0);
    }

    @Override
    protected boolean canScroll(View v, boolean checkV, int dx, int x, int y) {
        if (v != this && v instanceof ViewPager) {
            ViewPager childViewPager = ((ViewPager) v);
            if (childViewPager.getAdapter() == null) return true;
            int currentItem = childViewPager.getCurrentItem();
            int countItem = childViewPager.getAdapter().getCount();
            if ((currentItem == (countItem - 1) && dx < 0) || (currentItem == 0 && dx > 0)) {
                return false;
            }
            return true;
        }
            return super.canScroll(v, checkV, dx, x, y);
        }
    }

