package com.example.company.maina

import kotlinx.android.synthetic.main.fragment_home.*
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.media.MediaRecorder
import android.os.Environment
import android.util.Log
import android.widget.Toast
import java.io.File

import java.io.IOException


class HomeFragment : Fragment() {
    private var state: Boolean = false
    var mediaRecorder:MediaRecorder?=null
    private var output: String? = null
    private val dir: File = File(Environment.getExternalStorageDirectory().absolutePath + "/soundrecorder/")


    companion object {

        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {


        return inflater.inflate(R.layout.fragment_home, container, false)


    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        try{
            // create a File object for the parent directory
            val recorderDirectory = File(Environment.getExternalStorageDirectory().absolutePath+"/soundrecorder/")
            // have the object build the directory structure, if needed.
            recorderDirectory.mkdirs()
        }catch (e: IOException){
            e.printStackTrace()
        }

        if(dir.exists()){
            val count = dir.listFiles().size
            output = Environment.getExternalStorageDirectory().absolutePath + "/soundrecorder/recording"+count+".mp3"
        }

        mediaRecorder = MediaRecorder()

        mediaRecorder?.setAudioSource(MediaRecorder.AudioSource.MIC)
        mediaRecorder?.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4)
        mediaRecorder?.setAudioEncoder(MediaRecorder.AudioEncoder.AAC)
        mediaRecorder?.setOutputFile(output)
        fab_start_recording.setOnClickListener{
            onButton()
        }
    }


    private fun initRecorder() {
        mediaRecorder = MediaRecorder()

        if(dir.exists()){
            val count = dir.listFiles().size
            output = Environment.getExternalStorageDirectory().absolutePath + "/soundrecorder/recording"+count+".mp3"
            Log.d("ENTERED","sound" + count)
        }

        mediaRecorder?.setAudioSource(MediaRecorder.AudioSource.MIC)
        mediaRecorder?.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4)
        mediaRecorder?.setAudioEncoder(MediaRecorder.AudioEncoder.AAC)
        mediaRecorder?.setOutputFile(output)

    }


    fun onButton(){
        if(state) stopRecording()
        else startRecording()

    }


    fun startRecording() {
        Toast.makeText(context, "Запись началась!", Toast.LENGTH_SHORT).show()
        state=true
        Log.d("ENTERED","started")
        try {
            println("Starting recording!")
            mediaRecorder?.prepare()
            mediaRecorder?.start()
        } catch (e: IllegalStateException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }

    }


    fun stopRecording(){
        state=false
        Log.d("ENTERED","stopped")
        mediaRecorder?.stop()
        mediaRecorder?.release()
        initRecorder()
    }

}