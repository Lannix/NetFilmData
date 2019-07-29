package com.lannix.netfilmdata.stuff

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

import com.lannix.netfilmdata.fragment.Page_0
import com.lannix.netfilmdata.fragment.Page_1

class MyPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm), OnBackPressedInterface {

    var currentFragment: Fragment? = null
        private set

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> currentFragment = Page_0()
            1 -> currentFragment = Page_1()
        }
        return currentFragment
    }

    override fun getCount(): Int {
        return NUM_PAGES
    }

    override fun onBackPressedAction() {
        if (currentFragment is OnBackPressedInterface) {
            (currentFragment as OnBackPressedInterface).onBackPressedAction()
        }
    }

    companion object {

        val NUM_PAGES = 2
    }
}
