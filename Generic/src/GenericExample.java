public class GenericExample<T>{//Generic класс
    private T value;
    public GenericExample(T value){
        this.value=value;
    }
    public void setValue(T value){
        this.value=value;
    }
    public T getValue(){
        return value;
    }
    public static void main(String [] args){
        GenericExample<Integer> intObject=new GenericExample<Integer>(1);
        Integer valueInt=intObject.getValue();

        GenericExample<String> strObject=new GenericExample<String>("ex");
        String strValue=strObject.getValue();


    }
}
