import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GenericExample2 {
    public static <T> T getTheFirst(List<T> list){//Generic метод
         return list.get(0);
    }
    public static void main(String[]args){
        List<Integer> listOfInts=new ArrayList<>();
        listOfInts.add(0);
        Integer intValue=getTheFirst(listOfInts);

        List<String> listOfStrings=new ArrayList<>();
        listOfStrings.add("ex");
        String strValue=getTheFirst(listOfStrings);
    }
}
