import java.util.Scanner;

public class Zadanie4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int nod=Evkliid(a,b);
        System.out.println(nod);
        System.out.println(algPhi(a*b-1));
    }
    private static int Evkliid(int a,int b){
        if(a==0) return b;
        if(b==0) return a;
        if(a>=b) return  Evkliid(a%b,b);
        else return  Evkliid(a,b%a);
    }
    private static int algPhi(int n){

        int limit = (int) Math.ceil(Math.sqrt(n));
        for (int i =2 ;i<=limit;i++){
            if(n%i==0) return i;
        }
        return n;
    }
}
