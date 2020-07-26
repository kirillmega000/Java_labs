package com.example.simplecalculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_main.*

class Fragment_main:Fragment(){//фрагмент для рассчета
    companion object {

        fun newInstance(): Fragment_main {
            return Fragment_main()
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {


        return inflater.inflate(R.layout.fragment_main, container, false)


    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {//забинживание кнопок
        super.onActivityCreated(savedInstanceState)
        buttonZero.setOnClickListener {
            infoTextView.text=infoTextView.text.toString()+"0"
        }
        buttonOne.setOnClickListener {
            infoTextView.text=infoTextView.text.toString()+"1"
        }
        buttonTwo.setOnClickListener {
            infoTextView.text=infoTextView.text.toString()+"2"
        }
        buttonThree.setOnClickListener {
            infoTextView.text=infoTextView.text.toString()+"3"
        }
        buttonFour.setOnClickListener {
            infoTextView.text=infoTextView.text.toString()+"4"
        }
        buttonFive.setOnClickListener {
            infoTextView.text=infoTextView.text.toString()+"5"
        }
        buttonSix.setOnClickListener {
            infoTextView.text=infoTextView.text.toString()+"6"
        }
        buttonSeven.setOnClickListener {
            infoTextView.text=infoTextView.text.toString()+"7"
        }
        buttonEight.setOnClickListener {
            infoTextView.text=infoTextView.text.toString()+"8"
        }
        buttonNine.setOnClickListener {
            infoTextView.text=infoTextView.text.toString()+"9"
        }
        buttonDivide.setOnClickListener {
            infoTextView.text=infoTextView.text.toString()+"/"
        }
        buttonMultiply.setOnClickListener {
            infoTextView.text=infoTextView.text.toString()+"*"
        }
        buttonSubtract.setOnClickListener {
            infoTextView.text=infoTextView.text.toString()+"-"
        }
        buttonAdd.setOnClickListener {
            infoTextView.text=infoTextView.text.toString()+"+"
        }
        buttonDot.setOnClickListener {
            infoTextView.text=infoTextView.text.toString()+"."
        }
        buttonClear.setOnClickListener {
            infoTextView.text=""
        }
        buttonBeginBrace.setOnClickListener {
            infoTextView.text=infoTextView.text.toString()+"("
        }
        buttonEndBrace.setOnClickListener {
            infoTextView.text=infoTextView.text.toString()+")"
        }
        buttonEqual.setOnClickListener {
            editText.setText(Calculator.complicatedSequence(infoTextView.text.toString()))
        }
        buttonPow.setOnClickListener {
            infoTextView.text=infoTextView.text.toString()+"^"
        }
    }
}