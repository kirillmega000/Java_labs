package com.example.simplecalculator

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.marginBottom
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_history.*
import kotlinx.android.synthetic.main.fragment_main.*

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
    public fun OnChoose(){
        val linearLayout: LinearLayout =Linear
        val layoutParams: LinearLayout.LayoutParams=
            LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        layoutParams.setMargins(0,50,0,30)
        for(i in SingletonList.getInstance()){
            Log.d("CheckHistory",i)
            var view: TextView = TextView(context)
            view.setOnClickListener { v->
                if(v is TextView) {
                    var s= v.text.toString()
                    var activity=activity//смена фраггмента на главный через метод главной активити
                    if(activity is MainActivity)
                        activity.changeToMain(s)

                }

            }
            view.textSize=30.0F
            view.setText(i)
            view.layoutParams=layoutParams
            linearLayout.addView(view)

        }
        SingletonList.getInstance().clear()
    }



}