package com.lannix.netfilmdata.activity

import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager

import android.os.Bundle
import android.view.View
import android.widget.Button

import com.lannix.netfilmdata.R
import com.lannix.netfilmdata.fragment.MainActivityInterface
import com.lannix.netfilmdata.stuff.MyPagerAdapter
import com.lannix.netfilmdata.stuff.MyPagerAdapter.Companion.NUM_PAGES
import com.lannix.netfilmdata.stuff.OnBackPressedInterface
import com.rbrooks.indefinitepagerindicator.IndefinitePagerIndicator


import com.lannix.netfilmdata.stuff.MyPagerAdapter.NUM_PAGES

class MainActivity : AppCompatActivity(), MainActivityInterface {

    private var myPager: ViewPager? = null
    private var pagerAdapter: PagerAdapter? = null
    private var pagerIndicator: IndefinitePagerIndicator? = null
    private var backButton: Button? = null
    private var nextButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pagerAdapter = MyPagerAdapter(supportFragmentManager)
        myPager = findViewById(R.id.pager)
        myPager!!.adapter = pagerAdapter
        pagerIndicator = findViewById(R.id.pager_indicator)
        pagerIndicator!!.attachToViewPager(myPager)


        backButton = findViewById(R.id.backButton)
        nextButton = findViewById(R.id.nextButton)

        backButton!!.setOnClickListener {
            if (myPager!!.currentItem != 0) {
                myPager!!.currentItem = myPager!!.currentItem - 1
            }
        }
        nextButton!!.setOnClickListener {
            if (myPager!!.currentItem != NUM_PAGES) {
                myPager!!.currentItem = myPager!!.currentItem + 1
            }
        }

    }

    override fun onBackPressed() {
        if (pagerAdapter is OnBackPressedInterface) {
            (pagerAdapter as OnBackPressedInterface).onBackPressedAction()
        }
        if (myPager!!.currentItem == 0) {
            super.onBackPressed()
        } else {
            myPager!!.currentItem = myPager!!.currentItem - 1
        }
    }
}