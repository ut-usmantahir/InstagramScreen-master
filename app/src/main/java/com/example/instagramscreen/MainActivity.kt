package com.example.instagramscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.instagramscreen.fragments.FragmentGallery
import com.example.instagramscreen.fragments.FragmentLocation
import com.example.instagramscreen.fragments.FragmentMenu
import com.example.instagramscreen.fragments.FragmentProfile
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val viewPagerAdapter = MyViewPagerAdapter(supportFragmentManager)

        viewPagerAdapter.addFragment(FragmentGallery(),"")
        viewPagerAdapter.addFragment(FragmentMenu(),"")
        viewPagerAdapter.addFragment(FragmentLocation(),"")
        viewPagerAdapter.addFragment(FragmentProfile(),"")

        viewPager.adapter = viewPagerAdapter
        tabs.setupWithViewPager(viewPager)

        setIcons()

        Glide.with(this)
            .load(R.drawable.img_profile2)
            .placeholder(R.drawable.img_profile)
            .apply(RequestOptions.circleCropTransform())
            .into(iv_profile)

    }

    private fun setIcons(){
        tabs.getTabAt(0)?.setIcon(R.drawable.ic_grid)
        tabs.getTabAt(1)?.setIcon(R.drawable.ic_open_menu)
        tabs.getTabAt(2)?.setIcon(R.drawable.ic_marker)
        tabs.getTabAt(3)?.setIcon(R.drawable.ic_user)

    }
    class MyViewPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){

        private val fragmentList : MutableList<Fragment> = ArrayList()
        private val titleList : MutableList<String> = ArrayList()

        override fun getItem(position: Int): Fragment {
            return fragmentList[position]
        }

        override fun getCount(): Int {
            return fragmentList.size
        }
        fun addFragment (fragment: Fragment, title: String){
            fragmentList.add(fragment)
            titleList.add(title)
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return titleList[position]
        }


    }

}
