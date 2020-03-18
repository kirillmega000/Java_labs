package com.example.broadcasttest



import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.content.Intent
import android.content.IntentFilter
import androidx.core.view.KeyEventDispatcher


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val filter = IntentFilter(Intent.ACTION_MEDIA_BUTTON)

        val r = MediaReciever()
        filter.priority = 1000
        registerReceiver(r, filter)



    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        return super.onKeyDown(keyCode, event)
        if(keyCode.equals(KeyEvent.KEYCODE_MEDIA_PLAY))
            Log.d("Q","govno")
    }



}
