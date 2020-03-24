package com.example.instagramscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.instagramscreen.fragments.FragmentGallery
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val viewPagerAdapter = MyViewPagerAdapter(supportFragmentManager)

        viewPagerAdapter.addFragment(FragmentGallery(),"Gallery")

        viewPagerAdapter.addFragment(FragmentGallery(),"Menu")
        viewPagerAdapter.addFragment(FragmentGallery(),"Location")
        viewPagerAdapter.addFragment(FragmentGallery(),"Profile")

        viewPager.adapter = viewPagerAdapter
        tabs.setupWithViewPager(viewPager)

     Glide.with(this)
            .load(R.drawable.img_profile2)
            .placeholder(R.drawable.img_profile)
            .apply(RequestOptions.circleCropTransform())
            .into(iv_profile)

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
