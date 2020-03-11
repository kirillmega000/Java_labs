package com.example.company.maina

import android.Manifest
import android.content.Context
import android.media.AudioManager
import android.media.MediaPlayer
import kotlinx.android.synthetic.main.fragment_home.*
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.media.MediaRecorder
import android.net.Uri
import android.os.Environment
import android.util.Log
import android.widget.Toast

import java.util.*

import android.content.Context.*

import android.content.pm.PackageManager
import android.os.FileUtils
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.internal.schedulers.IoScheduler
import io.reactivex.schedulers.Schedulers
import java.io.*
import java.nio.charset.Charset
import java.nio.file.Files


class HomeFragment : Fragment() {
    private var state: Boolean = false
    var mediaRecorder: MediaRecorder? = null
    var request: Disposable? = null
    private var output: String? = null
    private var timen:String?=null
    private var recordingTime: Long = 0
    private var timer = Timer()
    private val dir: File = File(Environment.getExternalStorageDirectory().absolutePath + "/soundrecorder/recordings/")
    private var dirmeta:File=File(Environment.getExternalStorageDirectory().absolutePath + "/soundrecorder/metas/")

    private var outfile:String?=null
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
        try {
            // create a File object for the parent directory
            val recorderDirectory = File(Environment.getExternalStorageDirectory().absolutePath + "/soundrecorder/recordings/")
            val metasRepository= File(Environment.getExternalStorageDirectory().absolutePath + "/soundrecorder/metas/")
            // have the object build the directory structure, if needed.
            recorderDirectory.mkdirs()

            metasRepository.mkdirs()

        } catch (e: IOException) {
            e.printStackTrace()
        }

        if (dir.exists()) {
            timen=time.gettime()
            output = Environment.getExternalStorageDirectory().absolutePath + "/soundrecorder/recordings/recording" + timen + ".mp4"

        }
        mediaRecorder = MediaRecorder()
        mediaRecorder?.setAudioSource(MediaRecorder.AudioSource.MIC)
        mediaRecorder?.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4)
        mediaRecorder?.setAudioEncoder(MediaRecorder.AudioEncoder.AAC)
        mediaRecorder?.setOutputFile(output)
        fab_start_recording.setOnClickListener {
            onButton()
        }
        fab_start_playing.setOnClickListener { playRecording(context ?: return@setOnClickListener) }

        CheckSend.setOnClickListener {
            for(it in dir.listFiles())
            sendFile(it)
/*
            var metaFile=("meta"+dir.listFiles().last().name.substring(9,dir.listFiles().last().name.length-4))
            var info=this?.context?.openFileInput(metaFile)?.readBytes()?.toString(Charsets.UTF_8)?:return@setOnClickListener

            var obv=createRequest("http://192.168.100.222:8070/upload",dir.listFiles().last().absolutePath,info).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            obv.subscribe({Log.d("CheckSend","Success")},{Log.d("CheckSend","Fail")})}*/


    }


    }
    private fun sendFile( file:File){

        var metaFile=("meta"+file.name.substring(9,dir.listFiles().last().name.length-4))
        var info=this?.context?.openFileInput(metaFile)?.readBytes()?.toString(Charset.forName("UTF-8"))?:return

        var obv=createRequest("http://192.168.100.222:8070/upload",file.absolutePath,info).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
        request=obv.subscribe({Log.d("CheckSend","Success")},{Log.d("CheckSend","Fail")})
        file.delete()
        File(context?.filesDir?.absolutePath+File.pathSeparator+metaFile).delete()

    }
    private fun initRecorder() {
        mediaRecorder = MediaRecorder()

        if (dir.exists()) {
            timen=time.gettime()
            output = Environment.getExternalStorageDirectory().absolutePath + "/soundrecorder/recordings/recording" + timen + ".mp4"

        }

        mediaRecorder?.setAudioSource(MediaRecorder.AudioSource.MIC)
        mediaRecorder?.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4)
        mediaRecorder?.setAudioEncoder(MediaRecorder.AudioEncoder.AAC)
        mediaRecorder?.setOutputFile(output)

    }


    fun onButton() {
        if (state) stopRecording()
        else startRecording()

    }


    private fun startRecording() {
        if (ContextCompat.checkSelfPermission(context?:return, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {

            var fileName:String="meta"+timen
            var prefs=this.context?.getSharedPreferences("NamePrefs",MODE_PRIVATE)
            var name:String?=prefs?.getString("name","NoName")?:"NoName"
            Log.d("FileCheck",formatLocation())
            this.context?.openFileOutput(fileName, MODE_PRIVATE)?.write(("Name=${name} "+formatLocation()).toByteArray())?:return
            this.context?.openFileInput(fileName).use{
                Log.d("FileCheck",it?.readBytes()?.toString(Charset.forName("UTF-8")))
            }
        } else {
            // Request permission from the user
            ActivityCompat.requestPermissions(activity?.parent?:return,
                    arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), 0)

        }
        Toast.makeText(context, "Запись началась!", Toast.LENGTH_SHORT).show()
        fab_start_recording.setImageResource(R.drawable.ic_stop)
        state = true
        Log.d("ENTERED", "started")
        try {
            println("Starting recording!")
            mediaRecorder?.prepare()
            mediaRecorder?.start()
            startTimer()
        } catch (e: IllegalStateException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }

    }


    fun stopRecording() {
        state = false
        Log.d("ENTERED", "stopped")
        mediaRecorder?.stop()
        mediaRecorder?.release()

        stopTimer()
        fab_start_recording.setImageResource(R.drawable.ic_mic_black_24dp)
        val path = File(Environment.getExternalStorageDirectory().absolutePath + "/soundrecorder/recordings/recording" + timen + ".mp4")
        val copy= File (Environment.getExternalStorageDirectory().absolutePath + "/soundrecorder/metas/recording" + ".mp4")
        if(copy.exists()){
            copy.delete()
        }

        copy.createNewFile()
        org.apache.commons.io.FileUtils.copyFile(path,copy)
        initRecorder()
    }

    fun playRecording(context: Context) {
        val path = Uri.parse(Environment.getExternalStorageDirectory().absolutePath + "/soundrecorder/metas/recording" +  ".mp4")


        val manager: AudioManager = context.getSystemService(Context.AUDIO_SERVICE) as AudioManager
        if (manager.isMusicActive) {
            Toast.makeText(context, "Играет другая запись!", Toast.LENGTH_SHORT).show()
        } else if (state) {
            Toast.makeText(context, "Идет запись!", Toast.LENGTH_SHORT).show()
        } else if (dir.listFiles().isEmpty()) {
            Toast.makeText(context, "В папке нет записей!", Toast.LENGTH_SHORT).show()
        } else {
            startTimer()
            val mediaPlayer: MediaPlayer? = MediaPlayer().apply {
                setAudioStreamType(AudioManager.STREAM_MUSIC)
                setDataSource(context, path)
                prepare()
                start()
                setOnCompletionListener {
                    stopTimer()

                }
            }

        }

    }

    fun startTimer() {
        resetTimer()
        timer=Timer()
        timer.scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                recordingTime += 1
                activity?.runOnUiThread { updateDisplay() }
            }
        }, 1000, 1000)
    }

    fun stopTimer() {
        timer.cancel()
    }


    fun resetTimer() {
        timer.cancel()
        recordingTime = 0
        textview_recording_time.text = "00:00"
    }

    fun updateDisplay() {

        val minutes = recordingTime / (60)
        val seconds = recordingTime % 60
        val str = String.format("%d:%02d", minutes, seconds)
        textview_recording_time.text = str
    }
    private fun formatLocation(): String {
        var location=MyLocationListener.imHere
        return if (location == null) "none" else (String.format(
                "Coordinates: lat = %1$.4f, lon = %2$.4f",
                location!!.getLatitude(), location!!.getLongitude())+", time="+timen)

    }



}