import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Scanner;
//парсинг строки в выражение
public class Calculator {
    public static void main(String[] args) throws ScriptException {
        Scanner sc=new Scanner(System.in);
            String expression = sc.nextLine();
            System.out.println(primalSequence(expression));
    }
     private static String primalSequence(String seq){//парсинг элементарного выражения(без скобок)
        int i=0;
        while(i<seq.length()-1) {//парсинг умножения и деления(по правилам математики они первые)
                i+=1;
                if (seq.charAt(i) == '*') {
                    Pair fin=binaryOperation(seq,'*',i);
                    seq=fin.seq;
                    i=fin.num;
                }

                if (seq.charAt(i) == '/') {
                    Pair fin=binaryOperation(seq,'/',i);
                    seq=fin.seq;
                    i=fin.num;
                }
            }
            i=0;
       while(i<seq.length()-1){//парсинг сложения и вычитания
              i+=1;
            if(seq.charAt(i)=='+'){
                Pair fin=binaryOperation(seq,'+',i);
                seq=fin.seq;
                i=fin.num;
            }
            if(seq.charAt(i)=='-'){
                Pair fin=binaryOperation(seq,'-',i);
                seq=fin.seq;
                i=fin.num;
            }
        }

        return seq;
    }
     private static Pair binaryOperation(String seq,char op,int i){
        int n1 = i - 1;//поиск границ для элементарной операции
        int n2 = i + 1;
        while(((seq.charAt(n1)>47)&&(seq.charAt(n1)<58)&&(n1>0))||(seq.charAt(n1)==46)) {
            n1 -= 1;

        }
        while(((seq.charAt(n2)>47)&&(seq.charAt(n2)<58)&&(n2<seq.length()-1))||(seq.charAt(n2)==46)) {
            n2 += 1;
        }
         //сдвиг границ операции(если мы не с краю строки)
        if(n1!=0)
            n1+=1;
        if(n2!=seq.length()-1)
            n2-=1;
        //сама операция
        Float num= Float.valueOf(0);
        if(op=='*')
            num=Float.parseFloat(seq.substring(n1,i))*Float.parseFloat(seq.substring(i+1,n2+1));
        if(op=='/')
            num=Float.parseFloat(seq.substring(n1,i))/Float.parseFloat(seq.substring(i+1,n2+1));
        if(op=='+')
            num=Float.parseFloat(seq.substring(n1,i))+Float.parseFloat(seq.substring(i+1,n2+1));
        if(op=='-')
            num=Float.parseFloat(seq.substring(n1,i))-Float.parseFloat(seq.substring(i+1,n2+1));
        //возвращение значений(сама преобразованная строка и номер символа для продолжения преобразования строки);
        String seqprev=seq.substring(0,n1);
        String seqnext=seq.substring(n2+1,seq.length());
        seq=seqprev+num.toString()+seqnext;
        return new Pair(n1,seq);
    }
}

