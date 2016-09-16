package com.example.wincber.viewpagetest;

import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends FragmentActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager mViewPaper = (ViewPager) findViewById(R.id.pager);
        mViewPaper.setAdapter(new MyViewPagerAdapter(getSupportFragmentManager()));
    }

   private class MyViewPagerAdapter extends FragmentPagerAdapter {
        int []imagesId={R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4,R.drawable.image5,};
        public MyViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            MyViewPagerFragment mFragment = new MyViewPagerFragment();
            Bundle args = new Bundle();
            args.putInt("pager",imagesId[position]);
            mFragment.setArguments(args);
            return mFragment;
        }

        @Override
        public int getCount() {
            return imagesId.length;
        }
    }
}
