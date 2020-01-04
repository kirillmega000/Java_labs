import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Comparator;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

public class LinkServer {
       public LinkServer(CopyOnWriteArrayList<Person> Heroes,ObjectOutputStream out,ObjectInputStream in){
           this.Heroes=Heroes;
           this.out=out;
           this.in=in;
       }
    static CopyOnWriteArrayList<Person> Heroes=new CopyOnWriteArrayList<Person>();
      ObjectOutputStream out;
      ObjectInputStream in;
      command neo;
      start st;
    public void start()throws IOException,ClassNotFoundException {







        while(true){
            neo=(command)in.readObject();
            if(neo.com.equals("exit")){

                return;
            }
            this.read(neo.s.Name);

        }

    }
    public void lremove(){
        this.Heroes.remove(this.Heroes.size()-1);
    }
    public void fremove(){
        this.Heroes.remove(0);
    }
    public void addel(Person neo){

        this.Heroes.add(neo);
        Comparator<Person> comparator = (o1, o2) -> o1.size.compareTo(o2.size);
        Heroes.sort(comparator);
    }
    public void show() throws IOException{
        out.writeObject(this.Heroes);
    }
    public void remove(String name){
        for (int i = 0;i<this.Heroes.size();i++){
            if (this.Heroes.get(i).Name.equals(name)){
                this.Heroes.remove(i);
                break;
            }
        }
    }
    public void addifmax(Person neo){

            if(Heroes.stream().allMatch((s)->s.size <neo.size )){
                this.Heroes.add(neo);
                Comparator<Person> comparator = (o1, o2) -> o1.size.compareTo(o2.size);
                Heroes.sort(comparator);
            }


    }
    public void info() throws IOException{
        String s="Тип "+ this.Heroes.get(1).getClass().getName()+'\n'+"Дата инициализации 12.02.19"+'\n'+"Количество элементов " + this.Heroes.size()+'\n';
        out.writeObject(s);
    }
    public void save(){
        if(st.cho==1)
        {
            try{out.writeObject(this.Heroes);}
            catch(IOException e){
                System.out.println("Error");
            }
            }
        else if(st.cho==2){

                try{FileWork.WriteFile(this.Heroes,st.path);}
                catch(IOException e){
                    System.out.println("Error");
                }

        }
    }
    public void read(String com) throws ArrayIndexOutOfBoundsException,IOException{
        try {
            if (com.equals("remove_last")) {
                Runnable prog=()-> {this.lremove();
                try {
                    this.out.writeBoolean(Boolean.TRUE);
                }
                catch(IOException e){
                    System.out.println("error");
                }
                };
                Thread thread = new Thread(prog);
                thread.start();
            } else if (com.equals("remove_first")) {
                Runnable prog=()-> {this.fremove();
                    try {
                        this.out.writeBoolean(Boolean.TRUE);
                    }
                    catch(IOException e){
                        System.out.println("error");
                    }};
                Thread thread = new Thread(prog);
                thread.start();
            } else if (com.equals("remove")) {
                Runnable prog=()-> {this.remove(neo.s.Name);
                try {
                    this.out.writeBoolean(Boolean.TRUE);
                }
                catch(IOException e){
                    System.out.println("error");
                }};
                Thread thread = new Thread(prog);
                thread.start();
            } else if (com.equals("show")) {
                Runnable prog=()-> {
                    try {this.show();
                        this.out.writeBoolean(Boolean.TRUE);
                    }
                    catch(IOException e){
                        System.out.println("error");
                    }};
                Thread thread = new Thread(prog);
                thread.start();

            } else if (com.contains("add_if_max")) {
                Runnable prog=()-> {this.addifmax(neo.s);
                    try {
                        this.out.writeBoolean(Boolean.TRUE);
                    }
                    catch(IOException e){
                        System.out.println("error");
                    }};
                Thread thread = new Thread(prog);
                thread.start();



            } else if (com.contains("add")) {
                Runnable prog=()-> {this.addel(neo.s);
                    try {
                        this.out.writeBoolean(Boolean.TRUE);
                    }
                    catch(IOException e){
                        System.out.println("error");
                    }};
                Thread thread = new Thread(prog);
                thread.start();


            } else if (com.equals("info")) {
                Runnable prog=()-> {
                    try {this.info();
                        this.out.writeBoolean(Boolean.TRUE);
                    }
                    catch(IOException e){
                        System.out.println("error");
                    }};
                Thread thread = new Thread(prog);
                thread.start();


            }
            else if (com.equals("save")) {
                Runnable prog=()-> {
                    try {this.save();
                        this.out.writeBoolean(Boolean.TRUE);
                    }
                    catch(IOException e){
                        System.out.println("error");
                    }};
                Thread thread = new Thread(prog);
                thread.start();


            }
            else {
                try {this.save();
                    this.out.writeBoolean(Boolean.FALSE);
                }
                catch(IOException e){
                    System.out.println("error");
                }
            }

        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("unknown command");
        }
    }
}
