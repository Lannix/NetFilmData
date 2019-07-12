package com.example.netfilmdata.stuff;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.netfilmdata.fragment.Page_0;
import com.example.netfilmdata.fragment.Page_1;

public class MyPagerAdapter extends FragmentStatePagerAdapter {

    public static final int NUM_PAGES = 2;

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new Page_0();
            case 1:
                return new Page_1();
            default:
                return new Page_0();
        }
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }
}
