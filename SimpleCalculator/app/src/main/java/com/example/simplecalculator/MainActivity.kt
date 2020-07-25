package com.example.simplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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