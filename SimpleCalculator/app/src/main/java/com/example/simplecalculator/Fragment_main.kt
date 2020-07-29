package com.example.simplecalculator

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_history.*
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
        infoTextView.showSoftInputOnFocus=false//чтобы не выводилась андроидовская клава при клике
        buttonClean.text="<-"
        buttonZero.setOnClickListener {
            addSign("0",infoTextView.selectionStart)
        }
        buttonOne.setOnClickListener {
            addSign("1",infoTextView.selectionStart)
        }
        buttonTwo.setOnClickListener {
            addSign("2",infoTextView.selectionStart)
        }
        buttonThree.setOnClickListener {
            addSign("3",infoTextView.selectionStart)
        }
        buttonFour.setOnClickListener {
            addSign("4",infoTextView.selectionStart)
        }
        buttonFive.setOnClickListener {
            addSign("5",infoTextView.selectionStart)
        }
        buttonSix.setOnClickListener {
            addSign("6",infoTextView.selectionStart)
        }
        buttonSeven.setOnClickListener {
            addSign("7",infoTextView.selectionStart)
        }
        buttonEight.setOnClickListener {
            addSign("8",infoTextView.selectionStart)
        }
        buttonNine.setOnClickListener {
            addSign("9",infoTextView.selectionStart)
        }
        buttonDivide.setOnClickListener {
            addSign("/",infoTextView.selectionStart)
        }
        buttonMultiply.setOnClickListener {
            addSign("*",infoTextView.selectionStart)
        }
        buttonSubtract.setOnClickListener {
            addSign("-",infoTextView.selectionStart)
        }
        buttonAdd.setOnClickListener {
            addSign("+",infoTextView.selectionStart)
        }
        buttonDot.setOnClickListener {
            addSign(".",infoTextView.selectionStart)
        }
        buttonClear.setOnClickListener {
            infoTextView.setText("")
        }
        buttonBeginBrace.setOnClickListener {
            addSign("(",infoTextView.selectionStart)
        }
        buttonEndBrace.setOnClickListener {
            addSign(")",infoTextView.selectionStart)
        }
        buttonEqual.setOnClickListener {
            editText.setText(Calculator.complicatedSequence(infoTextView.text.toString()))
            if(editText.text.toString()!="Ошибка в выражении")
            SingletonList.getInstance()//Использование листа-синглтона для соххраненения истории выражений и прокидывания в другой фрагмент
                .add(infoTextView.text.toString() + "=" + editText.text.toString())
        }
        buttonPow.setOnClickListener {
            addSign("^",infoTextView.selectionStart)
        }
        buttonClean.setOnClickListener {
            val pos=infoTextView.selectionStart
            if(pos!=0){
            infoTextView.setText(infoTextView.text.toString().removeRange(pos-1,pos))
            infoTextView.setSelection(pos-1)}
        }
    }
    public fun setTextOnInfo(text:String){//метод для загрузки выражения из фрагмента истории
        // (из фрагмента истории через ссылку на главную активность в viewpager сменяется фрагмент,запускается этот метод через адаптер)
        infoTextView.setText(text.split("=")[0])
        editText.setText(text.split("=")[1])
    }
    private fun addSign(sign:String,position:Int){//добавление символа в строку с учетом расположения курсора
        infoTextView.setText(infoTextView.text.toString().substring(0,position)+sign+infoTextView.text.toString().substring(position,infoTextView.text.toString().length))
        infoTextView.setSelection(position+1)
    }
}