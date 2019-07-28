package com.lannix.netfilmdata.stuff;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.lannix.netfilmdata.fragment.Page_0;
import com.lannix.netfilmdata.fragment.Page_1;

public class MyPagerAdapter extends FragmentStatePagerAdapter implements OnBackPressedInterface {

    public static final int NUM_PAGES = 2;

    private Fragment currentFragment;

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                currentFragment = new Page_0();
                break;
            case 1:
                currentFragment = new Page_1();
                break;
        }
        return currentFragment;
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }

    @Override
    public void onBackPressedAction() {
        if (currentFragment instanceof OnBackPressedInterface) {
            ((OnBackPressedInterface) currentFragment).onBackPressedAction();
        }
    }

    public Fragment getCurrentFragment() {
        return currentFragment;
    }
}
