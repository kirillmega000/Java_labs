import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int midsum=0,midn=0,minmax,n,m,sumrazn=0;
        n=sc.nextInt();
        m=sc.nextInt();
        int[] nums=new int[n];
        int[] razn=new int[n-1];
        for(int i=1;i<n;i++) {
            nums[i]=sc.nextInt();
        }
        for(int i=1;i<n;i++) {
            razn[i - 1] = nums[i] - nums[i - 1];
            sumrazn+=razn[i-1];
        }
        minmax=sumrazn/(m-1);
        System.out.println();
        exitlabel:for(int i=minmax;i>1;i++){

            for(int j=0;j<n-1;j++){
                midsum+=razn[j];
                if(midsum>i){
                    midsum=0;
                    midn+=1;
                    if(midn==m-1){
                        midsum=i;
                        break exitlabel;
                    } }        }
            midsum=0;
            for(int j=n-2;j>0;j--){
                midsum+=razn[j];
                if(midsum>i){
                    midsum=0;
                    midn+=1;
                    if(midn==m-1){
                        midsum=i;
                        break exitlabel;
                    } }        }
             midsum=0;
        }

            System.out.println(midsum);

    }
}
