package com.example.company.maina

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.media.MediaRecorder
import android.os.Environment

import java.io.IOException


class HomeFragment : Fragment() {



    companion object {

        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }
    private var state: Boolean = false
    private var mediaRecorder: MediaRecorder? = null
    private var  fileName: String?=null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        fileName = Environment.getExternalStorageDirectory().absolutePath + "/record.3gpp";
        mediaRecorder = MediaRecorder()
        mediaRecorder?.setAudioSource(MediaRecorder.AudioSource.MIC)
        mediaRecorder?.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4)
        mediaRecorder?.setAudioEncoder(MediaRecorder.AudioEncoder.AAC)
        mediaRecorder?.setOutputFile(fileName)
        return inflater.inflate(R.layout.fragment_home, container, false)

    }
    private fun onButton(){
        if(state)stopRecording()
        else startRecording()

    }
    private fun startRecording() {
        try {
            mediaRecorder?.prepare()
            mediaRecorder?.start()
            state = true
        } catch (e: IllegalStateException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
    private fun stopRecording() {

            mediaRecorder?.stop()
            mediaRecorder?.release()
            state = false

    }
}