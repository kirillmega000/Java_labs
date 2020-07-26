package com.example.simplecalculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class Fragment_history:Fragment(){//фрагмент с историей операций
    companion object{

        fun newInstance():Fragment_history{
            return Fragment_history()
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {


        return inflater.inflate(R.layout.fragment_history, container, false)


    }
}