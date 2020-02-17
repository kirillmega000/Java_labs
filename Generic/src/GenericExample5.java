import java.util.ArrayList;
import java.util.List;

public class GenericExample5 {
    public static void getFirstValue(List<? extends Number> list){
        System.out.println(list.get(0).getClass());
    }

    public static void main(String[] args){
        List<Integer> listOfNumbers=new ArrayList<>();
        listOfNumbers.add(42);
        getFirstValue(listOfNumbers);


    }
}
