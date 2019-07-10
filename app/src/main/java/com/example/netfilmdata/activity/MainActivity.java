package com.example.netfilmdata.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.netfilmdata.R;
import com.example.netfilmdata.fragment.MainActivityInterface;
import com.example.netfilmdata.stuff.MyPagerAdapter;
import com.rbrooks.indefinitepagerindicator.IndefinitePagerIndicator;

public class MainActivity extends AppCompatActivity implements MainActivityInterface {

    private ViewPager myPager;
    private PagerAdapter pagerAdapter;
    private IndefinitePagerIndicator pagerIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        myPager = findViewById(R.id.pager);
        myPager.setAdapter(pagerAdapter);
        pagerIndicator = findViewById(R.id.pager_indicator);
        pagerIndicator.attachToViewPager(myPager);
    }

    @Override
    public void onBackPressed() {
        if (myPager.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
            myPager.setCurrentItem(myPager.getCurrentItem() - 1);
        }
    }
}