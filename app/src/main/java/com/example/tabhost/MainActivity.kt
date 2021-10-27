package com.example.tabhost

import android.os.Bundle
import android.view.ViewGroup
import android.widget.TableLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: MyPagerAdapter
    private lateinit var tab: TabLayout
    private lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.view_pager)
        tab = findViewById(R.id.tab_layout)

        //viewPager.scrollY
        setupViewPager()

        var listGroups = mutableListOf("group1","group2", "group3", "group4")

        listGroups.forEach {
            with(tab) {
                this.addTab(this.newTab().setText(it))
        }

        }
        disableTabAt(tab,1)

        adapter = MyPagerAdapter(supportFragmentManager, tab.getTabCount())
        viewPager.setAdapter(adapter)

        //Change the position of tabs in according swipe screen
        viewPager.addOnPageChangeListener(TabLayoutOnPageChangeListener(tab))
    }

    fun setupViewPager(){

        tab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                print("")
                viewPager.currentItem = tab?.position ?: 0
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                print("")
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                print("")
            }

        })

        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                print("")
            }

            override fun onPageSelected(position: Int) {
            }

            override fun onPageScrollStateChanged(state: Int) {
                print("")
            }

        }
        )
    }

    fun disableTabAt(tablayout: TabLayout?, index: Int) {
        (tablayout?.getChildAt(0) as? ViewGroup)?.getChildAt(index)?.isEnabled = false
    }
}