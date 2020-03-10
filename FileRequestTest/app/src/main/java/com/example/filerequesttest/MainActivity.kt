
package com.example.filerequesttest

import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Environment
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.internal.schedulers.IoScheduler
import io.reactivex.schedulers.Schedulers
import java.io.File

import java.sql.DriverManager.println

class MainActivity : AppCompatActivity() {
    private val dir: File = File(Environment.getExternalStorageDirectory().absolutePath + "/soundrecorder/recordings/")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        checkNeededPermissions()
        Log.d("CheckSend",dir.listFiles().last().absolutePath)
        var obv=createRequest("http://192.168.100.222:8070/upload",dir.listFiles().last().absolutePath,"Priva").subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
        obv.subscribe({Log.d("CheckSend","Success")},{Log.d("CheckSend","Fail")})

    }

    private fun checkNeededPermissions() {
        kotlin.io.println("Requesting permission")
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED ||ContextCompat.checkSelfPermission(this,Manifest.permission.INTERNET)
                != PackageManager.PERMISSION_GRANTED) {
            kotlin.io.println("Requesting permission")
            ActivityCompat.requestPermissions(this,
                    arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.INTERNET  ), 0)
        }
    }

}