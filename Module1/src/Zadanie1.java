import java.util.Scanner;

public class Zadanie1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a[]=new int[40];
        a[0]=0;
        a[1]=1;
        int n=sc.nextInt();
        for(int i=2;i<n+1;i++){
            a[i]=a[i-1]+a[i-2];
        }
        System.out.println(a[n]);
    }
}
