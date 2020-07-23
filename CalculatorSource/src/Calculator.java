import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Scanner;
//парсинг строки в выражение
public class Calculator {
    public static void main(String[] args) throws ScriptException {
        Scanner sc=new Scanner(System.in);
          /*  ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("JavaScript");
        System.out.println(engine.eval(expression));*/
            String expression = sc.nextLine();
            System.out.println(primalSequence(expression));


       /* sequence=sc.nextLine();
        System.out.println(countMaxPriority(sequence));*/
    }
    public static int countMaxPriority(String seq){//поиск максимального приоритета операции(в скобочках)
        int n = 0;
        int maxn = 0;
        for(int i=0;i<seq.length();i++){
            if(seq.charAt(i)=='('){
                n += 1;
                if(n>maxn) maxn=n;
            }
            else if(seq.charAt(i)==')'){
                n -= 1;
            }
        }
        return maxn;
    }
    public static String primalSequence(String seq){//парсинг элементарного выражения(без скобок)
        int i=0;
            while(i<seq.length()-1) {
                i+=1;
                if (seq.charAt(i) == '*') {
                    System.out.println(seq.charAt(i));
                    int n1 = i - 1;//поиск границ для элементарного умножения
                    int n2 = i + 1;
                    while (((seq.charAt(n1) > 47) && (seq.charAt(n1) < 58) && (n1 > 0)) || (seq.charAt(n1) == 46)) {
                        n1 -= 1;

                    }
                    while (((seq.charAt(n2) > 47) && (seq.charAt(n2) < 58) && (n2 < seq.length() - 1)) || (seq.charAt(n2) == 46)) {
                        n2 += 1;
                    }
                    System.out.println(i + "  " + n1 + "  " + n2 + "  ");
                    if (n1 != 0)
                        n1 += 1;
                    if (n2 != seq.length() - 1)
                        n2 -= 1;
                    System.out.println(Float.parseFloat(seq.substring(n1, i)));
                    System.out.println(Float.parseFloat(seq.substring(i + 1, n2 + 1)));
                    Float num = Float.parseFloat(seq.substring(n1, i)) * Float.parseFloat(seq.substring(i + 1, n2 + 1));
                    System.out.println(num);
                    String seqprev = seq.substring(0, n1);
                    String seqnext = seq.substring(n2 + 1, seq.length());
                    seq = seqprev + num.toString() + seqnext;
                    i=n1;
                }

                if (seq.charAt(i) == '/') {
                    System.out.println(seq.charAt(i));
                    int n1 = i - 1;//поиск границ для элементарного умножения
                    int n2 = i + 1;
                    while (((seq.charAt(n1) > 47) && (seq.charAt(n1) < 58) && (n1 > 0)) || (seq.charAt(n1) == 46)) {
                        n1 -= 1;

                    }
                    while (((seq.charAt(n2) > 47) && (seq.charAt(n2) < 58) && (n2 < seq.length() - 1)) || (seq.charAt(n2) == 46)) {
                        n2 += 1;
                    }
                    System.out.println(i + "  " + n1 + "  " + n2 + "  ");
                    if (n1 != 0)
                        n1 += 1;
                    if (n2 != seq.length() - 1)
                        n2 -= 1;
                    System.out.println(Float.parseFloat(seq.substring(n1, i)));
                    System.out.println(Float.parseFloat(seq.substring(i + 1, n2 + 1)));
                    Float num = Float.parseFloat(seq.substring(n1, i)) / Float.parseFloat(seq.substring(i + 1, n2 + 1));
                    System.out.println(num);
                    String seqprev = seq.substring(0, n1);
                    String seqnext = seq.substring(n2 + 1, seq.length());
                    seq = seqprev + num.toString() + seqnext;
                    i=n1;
                }
            }
            i=0;
            System.out.println(seq);
       while(i<seq.length()-1){
              i+=1;
            if(seq.charAt(i)=='+'){
                System.out.println(seq.charAt(i));
                int n1 = i - 1;//поиск границ для элементарного умножения
                int n2 = i + 1;
                while(((seq.charAt(n1)>47)&&(seq.charAt(n1)<58)&&(n1>0))||(seq.charAt(n1)==46)) {
                    n1 -= 1;

                }
                while(((seq.charAt(n2)>47)&&(seq.charAt(n2)<58)&&(n2<seq.length()-1))||(seq.charAt(n2)==46)) {
                    n2 += 1;
                }
                System.out.println(i+"  "+n1+"  "+n2+"  ");
                if(n1!=0)
                n1+=1;
                if(n2!=seq.length()-1)
                    n2-=1;
                System.out.println(Float.parseFloat(seq.substring(n1,i)));
                System.out.println(Float.parseFloat(seq.substring(i+1,n2+1)));
                Float num=Float.parseFloat(seq.substring(n1,i))+Float.parseFloat(seq.substring(i+1,n2+1));
                System.out.println(num);
                String seqprev=seq.substring(0,n1);
                String seqnext=seq.substring(n2+1,seq.length());
                seq=seqprev+num.toString()+seqnext;
                i=n1;
                System.out.println(seq);
            }
            if(seq.charAt(i)=='-'){
                System.out.println(seq.charAt(i));
                int n1 = i - 1;//поиск границ для элементарного умножения
                int n2 = i + 1;
                while(((seq.charAt(n1)>47)&&(seq.charAt(n1)<58)&&(n1>0))||(seq.charAt(n1)==46)) {
                    n1 -= 1;

                }
                while(((seq.charAt(n2)>47)&&(seq.charAt(n2)<58)&&(n2<seq.length()-1))||(seq.charAt(n2)==46)) {
                    n2 += 1;
                }
                System.out.println(i+"  "+n1+"  "+n2+"  ");
                if(n1!=0)
                n1+=1;
                if(n2!=seq.length()-1)
                    n2-=1;
                System.out.println(Float.parseFloat(seq.substring(n1,i)));
                System.out.println(Float.parseFloat(seq.substring(i+1,n2+1)));
                Float num=Float.parseFloat(seq.substring(n1,i))-Float.parseFloat(seq.substring(i+1,n2+1));
                System.out.println(num);
                String seqprev=seq.substring(0,n1);
                String seqnext=seq.substring(n2+1,seq.length());
                seq=seqprev+num.toString()+seqnext;
                i=n1;
                System.out.println(seq);
            }
        }
        System.out.println();
        return seq;
    }
}
