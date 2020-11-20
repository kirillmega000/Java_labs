import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int l,k,m;
        l=sc.nextInt();
        k=sc.nextInt();
        m=sc.nextInt();
        if ((l-k)%m==0) System.out.println((l-k)/m+1);
        else System.out.println(-1);
    }
}
