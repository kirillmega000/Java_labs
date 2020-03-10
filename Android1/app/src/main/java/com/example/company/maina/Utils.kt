package com.example.company.maina

import android.os.Environment
import android.util.Log
import io.reactivex.Observable
import java.io.*
import java.net.HttpURLConnection
import java.net.URL

import java.lang.Exception


fun createRequest(url: String,filename:String,filemeta:String) = Observable.create<String> {
    val lineEnd = "\r\n"
    val twoHyphens = "--"
    val boundary = "*****"

    var FORM_FILE_NAME="file1"
    val urlConnection = URL(url).openConnection() as HttpURLConnection
    try {

        Log.d("CheckSend",filemeta)
        urlConnection.useCaches=false
        urlConnection.doInput=true
        urlConnection.doOutput=true
        urlConnection.requestMethod="POST"
        urlConnection.setRequestProperty("Connection", "Keep-Alive")
        urlConnection.setRequestProperty("ENCTYPE", "multipart/form-data")
        urlConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary="+boundary)
        urlConnection.setRequestProperty("uploaded_file", filename)
        val outputStream = DataOutputStream(urlConnection.getOutputStream())

        outputStream.writeBytes(twoHyphens + boundary + lineEnd)
        outputStream.writeBytes("Content-Disposition: form-data; name=\"meta\"; filename=\""  +  filemeta + "\"\r\n\r\n")
        outputStream.write(org.apache.commons.io.FileUtils.readFileToByteArray(File(filemeta)))
        outputStream.writeBytes(lineEnd)

        outputStream.writeBytes(twoHyphens + boundary + lineEnd)
        outputStream.writeBytes("Content-Disposition: form-data; name=\"" +
                FORM_FILE_NAME + "\"; filename=\"" + filename +  "\"\r\n\r\n")

        outputStream.write(org.apache.commons.io.FileUtils.readFileToByteArray(File(filename)))
        outputStream.writeBytes(lineEnd)
        outputStream.writeBytes(twoHyphens + boundary + twoHyphens + lineEnd)
        /* val serverResponseCode = urlConnection.responseCode*/


        outputStream.flush()
        outputStream.close()
        urlConnection.connect()
        Log.d("CheckSend","Complete")

    }catch (e:Exception){
        e.printStackTrace()
    }
    finally {
        urlConnection.disconnect()
    }

}