import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int n=0;
        boolean b=false;
        while(num>0){
            int digit=num%10;
            if((b==false)&(digit!=1)) b=true;
            else if ((b==true)&(digit==1)) n+=1;
            num=num/10;
        }
        System.out.println(n);
    }
}
