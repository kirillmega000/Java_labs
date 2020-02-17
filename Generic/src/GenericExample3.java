import java.util.ArrayList;
import java.util.List;

public class GenericExample3 {
    public static  Object getFirstValue(List list){
        return list.get(0);
    }
    public static String getFirstStringValue(List<String> listOfStrings){
        return  listOfStrings.get(0);
    }
    public static void main(String[] args){
        List<Integer> listOfNumbers=new ArrayList<>();
        listOfNumbers.add(42);

        String name1=(String) getFirstValue(listOfNumbers);//Runtine error
        //String name2=getFirstStringValue(listOfNumbers);//Compile error
    }
}
