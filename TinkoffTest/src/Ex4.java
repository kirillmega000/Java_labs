import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
/*Вам дано число n и
        последовательность чисел a 1 , a 2 , … , a n . Необходимо выбрать из нее
        такую строго возрастающую подпоследовательность, что сумма элементов этой
        подпоследовательности максимальна.*/
public class Ex4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int [] numbers=new int[n];
        Integer [] count=new Integer[n];
        for(int i=0;i<n;i++){
            numbers[i]=sc.nextInt();
            count[i]=numbers[i];
        }
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){

              if(numbers[j]>numbers[i]){
                  int intmed=count[i]+numbers[j];
                  if(intmed>count[j]) count[j]=intmed;
              }
            }
        }
        Arrays.sort(count, Collections.reverseOrder());

        System.out.println(count[0]);
    }
}
