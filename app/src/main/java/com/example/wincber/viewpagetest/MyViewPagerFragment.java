package com.example.wincber.viewpagetest;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by wincber on 9/16/2016.
 */
public class MyViewPagerFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_object,container,false);
        ImageView images = (ImageView)view.findViewById(R.id.image_iv);
        images.setImageDrawable(getResources().getDrawable(getArguments().getInt("pager")));
        NestingViewPager nestPager = (NestingViewPager)view.findViewById(R.id.nesting_vp);
        nestPager.setAdapter(new NestingViewPagerAdapter(getChildFragmentManager()));
        return view;
    }

    private class NestingViewPagerAdapter extends FragmentPagerAdapter {
        int []imagesId={R.drawable.icon1,R.drawable.icon2,R.drawable.icon3};
        public NestingViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            NestingViewPagerFragment fragment = new NestingViewPagerFragment();
            Bundle args  = new Bundle();
            args.putInt("images",imagesId[position]);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public int getCount() {
            return imagesId.length;
        }
    }
}
