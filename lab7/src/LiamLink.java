import java.util.concurrent.CopyOnWriteArrayList;

public class LiamLink {
    static CopyOnWriteArrayList<Person> Heroes=new CopyOnWriteArrayList<Person>();
    public void lremove(){
        this.Heroes.remove(this.Heroes.size()-1);
    }
    public void fremove(){
        this.Heroes.remove(0);
    }
    public void addel(String name){
        Person neo=new Person(name);
        this.Heroes.add(neo);
    }
    public void show(){

        for(int i=0;i<this.Heroes.size();i++){
            System.out.print(this.Heroes.get(i).Name + " |");
        }
    }
    public void remove(String name){
        for (int i = 0;i<this.Heroes.size();i++){
            if (this.Heroes.get(i).Name.equals(name)){
                this.Heroes.remove(i);
                break;
            }
        }
    }
    public void addifmax(String name){
        int n=0;
        for (int i = 0;i<this.Heroes.size();i++){
            if (name.length()>this.Heroes.get(i).Name.length())
                n+=1;
        }
        if (n==this.Heroes.size()){
            Person neo=new Person(name);
            this.Heroes.add(neo);
        }
    }
    public void info(){
        System.out.println("Тип "+ this.Heroes.get(1).getClass().getName());
        System.out.println("Дата инициализации 12.02.19");
        System.out.println("Количество элементов " + this.Heroes.size());
    }




}
