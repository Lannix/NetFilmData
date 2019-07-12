package com.example.netfilmdata.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.netfilmdata.R;
import com.example.netfilmdata.fragment.MainActivityInterface;
import com.example.netfilmdata.stuff.MyPagerAdapter;
import com.rbrooks.indefinitepagerindicator.IndefinitePagerIndicator;

import me.saket.inboxrecyclerview.page.ExpandablePageLayout;

import static com.example.netfilmdata.stuff.MyPagerAdapter.NUM_PAGES;

public class MainActivity extends AppCompatActivity implements MainActivityInterface {

    private ViewPager myPager;
    private PagerAdapter pagerAdapter;
    private IndefinitePagerIndicator pagerIndicator;
    private Button backButton;
    private Button nextButton;
    private ExpandablePageLayout expandablePageLayout;

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

        expandablePageLayout = findViewById(R.id.inbox_page);
    }

    @Override
    public void onBackPressed() {
        if (myPager.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
            myPager.setCurrentItem(myPager.getCurrentItem() - 1);
        }
    }

    @Override
    public ExpandablePageLayout getExpandablePageLayout() {
        return expandablePageLayout;
    }
}