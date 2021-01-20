import java.util.Scanner;

class Zadanie3{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int p=0;
        long n=sc.nextLong();
        int m=sc.nextInt();

        int ml=m*6;//Последовательность чисел,где найдется цикл Пизано

        int ns=(int)n+1;//если n Больше Integer.MAX_VALUE,то cast вернет отрицательное число
        ns=Math.abs(ns);
        if(ml>ns)
            ml=ns;




        int f[]=new int[ml];//начальные условия
        f[0]=0;
        f[1]=1;
        if(n==0){
            System.out.println(0);
            return;
        };
        if(n==1){
            System.out.println(1);
            return;
        };
        for(int i=2;i<n+1;i++){

            f[i]=(f[i-1]+f[i-2])%m;
            if((f[i]==1)&(f[i-1]==0)){//когда нашлась цепочка,ливаем
                p=i-1;
                break;
            }
        }
        if(p==0) ml=(int)n;//если n<длины цепочки,то p=0
        else ml=(int)(n%p);
        System.out.println(f[ml]);
    }
}