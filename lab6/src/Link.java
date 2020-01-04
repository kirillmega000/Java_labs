/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.util.*;
import java.util.concurrent.*;
/**
 *
 * @author kiril
 */
public class Link {

    Scanner in = new Scanner(System.in);
    static CopyOnWriteArrayList <Person> Heroes=new CopyOnWriteArrayList<Person>();

    public void start()throws IOException{

        FileWork.ReadFile(this.Heroes);

        for(int i=0;i<this.Heroes.size();i++){
            System.out.print(this.Heroes.get(i).Name + " |");
        }

        System.out.println();

        System.out.println( "Введите команду");

        while(true){
            String s=in.nextLine();
            if(s.equals("exit")){

                return;
            }
            this.read(s);

        }

    }
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
    public void read(String com) throws ArrayIndexOutOfBoundsException{
   try {
       if (com.equals("remove_last")) {
           this.lremove();
       } else if (com.equals("remove_first")) {
           this.fremove();
       } else if (com.contains("remove")) {
           String[] red = com.split("\"");
           this.remove(red[3]);
       } else if (com.equals("show")) {
           this.show();
           System.out.println();
       } else if (com.contains("add_if_max")) {

           String[] red = com.split("\"");

           this.addifmax(red[3]);


       } else if (com.contains("add")) {

           String[] red = com.split("\"");
           this.addel(red[3]);

       } else if (com.equals("info")) {
           this.info();

       } else {
           System.out.println("unknown command");
       }

   }
   catch (ArrayIndexOutOfBoundsException e){
       System.out.println("unknown command");
   }
    }
}