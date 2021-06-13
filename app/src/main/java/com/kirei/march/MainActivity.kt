package com.kirei.march

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kirei.march.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kirei.march.adapters.ViewPagerAdapter
import com.kirei.march.databinding.ActivityMainBinding
import com.kirei.march.fragments.Category
import com.kirei.march.fragments.Home
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tabLayoutId.tabRippleColor = null
        val adapter = ViewPagerAdapter(this)
        binding.viewpagerId.offscreenPageLimit = 2
        val tableNames = arrayOf("Home","Category")
        adapter.addFragment(Home(),tableNames[0])
        adapter.addFragment(Category(),tableNames[1])
        binding.viewpagerId.adapter = adapter
        TabLayoutMediator(binding.tabLayoutId,binding.viewpagerId) { tab ,position ->
            tab.text = tableNames[position]
            binding.viewpagerId.setCurrentItem(tab.position,true)
        }.attach()

    }
}