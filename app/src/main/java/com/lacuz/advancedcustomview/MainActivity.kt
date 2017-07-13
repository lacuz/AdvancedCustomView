package com.lacuz.advancedcustomview

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import android.support.v4.app.FragmentPagerAdapter
import com.lacuz.advancedcustomview.funny.OctopusFragment
import com.lacuz.advancedcustomview.season.SeasonFragment


class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                mViewPager.currentItem=0
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                mViewPager.currentItem=1
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                mViewPager.currentItem=2
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        val fgLists = arrayListOf<Fragment>()
        fgLists.add(SeasonFragment())
        fgLists.add(OctopusFragment())
        fgLists.add(SeasonFragment())
        val mAdapter = object : FragmentPagerAdapter(supportFragmentManager) {
            override fun getItem(position: Int): Fragment {
                return fgLists.get(position)
            }

            override fun getCount(): Int {
                return fgLists.size
            }
        }
        mViewPager.adapter = mAdapter
        mViewPager.offscreenPageLimit = 2 //预加载剩下两页
    }
}
