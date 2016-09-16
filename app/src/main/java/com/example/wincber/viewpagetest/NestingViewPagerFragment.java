package com.example.wincber.viewpagetest;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by wincber on 9/16/2016.
 */
public class NestingViewPagerFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nesting_object,container,false);
        ImageView images = (ImageView)view.findViewById(R.id.images);
        images.setImageDrawable(getResources().getDrawable(getArguments().getInt("images")));
        return view;
    }
}
