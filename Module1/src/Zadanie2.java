import java.util.Scanner;

public class Zadanie2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=0,b=1;

        int n=sc.nextInt();
        if(n==0){
            System.out.println(0);
            return;
        };
        if(n==1){
            System.out.println(0);
            return;
        };
        for(int i=2;i<n+1;i++){
            b=a+b;
            a=(b-a)%10;
            b=b%10;
        }
        System.out.println(b);
    }
}
