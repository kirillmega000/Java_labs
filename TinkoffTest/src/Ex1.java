import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        LinkedList<Integer> ls=new LinkedList<>();
        for(int i=0;i<4;i++){
            ls.add(sc.nextInt());
        }

        ls.sort(Comparator.naturalOrder());
        System.out.println(ls.get(0)*ls.get(1)+ls.get(2)*ls.get(3));



    }
}
