package com.lannix.netfilmdata.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.lannix.netfilmdata.R;
import com.lannix.netfilmdata.fragment.MainActivityInterface;
import com.lannix.netfilmdata.stuff.MyPagerAdapter;
import com.lannix.netfilmdata.stuff.OnBackPressedInterface;
import com.rbrooks.indefinitepagerindicator.IndefinitePagerIndicator;


import static com.lannix.netfilmdata.stuff.MyPagerAdapter.NUM_PAGES;

public class MainActivity extends AppCompatActivity implements MainActivityInterface {

    private ViewPager myPager;
    private PagerAdapter pagerAdapter;
    private IndefinitePagerIndicator pagerIndicator;
    private Button backButton;
    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        myPager = findViewById(R.id.pager);
        myPager.setAdapter(pagerAdapter);
        pagerIndicator = findViewById(R.id.pager_indicator);
        pagerIndicator.attachToViewPager(myPager);


        backButton = findViewById(R.id.backButton);
        nextButton = findViewById(R.id.nextButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (myPager.getCurrentItem() != 0) {
                    myPager.setCurrentItem(myPager.getCurrentItem() - 1);
                }
            }
        });
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (myPager.getCurrentItem() != NUM_PAGES) {
                    myPager.setCurrentItem(myPager.getCurrentItem() + 1);
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        if (pagerAdapter instanceof OnBackPressedInterface) {
            ((OnBackPressedInterface) pagerAdapter).onBackPressedAction();
        }
        if (myPager.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
            myPager.setCurrentItem(myPager.getCurrentItem() - 1);
        }
    }
}