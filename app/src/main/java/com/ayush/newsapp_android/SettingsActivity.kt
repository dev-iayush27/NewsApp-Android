package com.ayush.newsapp_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        //to change title of activity
        val actionBar = supportActionBar
        actionBar?.title = "Settings"
    }
}