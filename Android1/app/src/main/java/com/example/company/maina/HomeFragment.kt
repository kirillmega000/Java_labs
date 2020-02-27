package com.example.company.maina

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
import java.io.File

import java.io.IOException
import java.util.*
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel


class HomeFragment : Fragment() {
    private var state: Boolean = false
    var mediaRecorder: MediaRecorder? = null

    private var output: String? = null
    private var recordingTime: Long = 0
    private var timer = Timer()
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
        try {
            // create a File object for the parent directory
            val recorderDirectory = File(Environment.getExternalStorageDirectory().absolutePath + "/soundrecorder/")
            // have the object build the directory structure, if needed.
            recorderDirectory.mkdirs()
        } catch (e: IOException) {
            e.printStackTrace()
        }

        if (dir.exists()) {
            val count = dir.listFiles().size
            output = Environment.getExternalStorageDirectory().absolutePath + "/soundrecorder/recording" + count + ".mp3"
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


    }

        private fun initRecorder() {
            mediaRecorder = MediaRecorder()

            if (dir.exists()) {
                val count = dir.listFiles().size
                output = Environment.getExternalStorageDirectory().absolutePath + "/soundrecorder/recording" + count + ".mp3"
                Log.d("ENTERED", "sound" + count)
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


        fun startRecording() {
            Toast.makeText(context, "Запись началась!", Toast.LENGTH_SHORT).show()
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
            initRecorder()
            stopTimer()

        }

        fun playRecording(context: Context) {
            val path = Uri.parse(Environment.getExternalStorageDirectory().absolutePath + "/soundrecorder/recording" + (dir.listFiles().size - 1) + ".mp3")


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


}