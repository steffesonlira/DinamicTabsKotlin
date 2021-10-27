package com.example.tabhost

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class MyPagerAdapter(fa: FragmentManager, numOfTabs: Int): FragmentStatePagerAdapter(fa){
    var numTab = numOfTabs
    var fragment = fa

    override fun getCount(): Int {
        return numTab
    }

    override fun getItem(position: Int): Fragment {
        return DynamicFragment.addFrag(position)
    }
}