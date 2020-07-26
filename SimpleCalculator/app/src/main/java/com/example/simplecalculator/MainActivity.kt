package com.example.simplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var viewpager: ViewPager = findViewById(R.id.viewpager)//настройка TabLayout с помощью ViewPager
        setupViewAdapter(viewpager)
        var tablayout: TabLayout = findViewById(R.id.sliding_tabs)
        tablayout.setupWithViewPager(viewpager)
    }
    private fun setupViewAdapter(viewPager: ViewPager){//Добавление фрагментов в ViewPager
        var viewpageradapter=ViewPagerAdapter(this,supportFragmentManager)
        viewpageradapter.addFragment(Fragment_main.newInstance(),"Главная")
        viewpageradapter.addFragment(Fragment_history.newInstance(),"История")
        viewPager.adapter=viewpageradapter
    }
}