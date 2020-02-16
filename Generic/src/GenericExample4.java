public class GenericExample4<T extends Number> {//Number может быть как класс,так и интерфейс
    private T value;
    public GenericExample4(T value){
        this.value=value;
    }
    public void setValue(T value){
        this.value=value;
    }
    public T getValue(){
        return value;
    }
    public static void main(String [] args){
        //Integer extends Number -- ok
        GenericExample4<Integer> intObject=new GenericExample4<Integer>(1);
        Integer valueInt=intObject.getValue();
        //Strings not extends Number-error
        //GenericExample4<String> strObject=new GenericExample4<String>("ex");
      //  String strValue=strObject.getValue();


    }

}
