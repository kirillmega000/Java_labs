import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.SocketException;
import java.sql.ResultSet;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;
public class LinkClient {
    Scanner sc = new Scanner(System.in);
    ObjectInputStream in;
    ObjectOutputStream out;
    command neo = new command();
    String s = new String();
    CopyOnWriteArrayList<Person> Heroes = new CopyOnWriteArrayList<Person>();
    public LinkClient(ObjectOutputStream out, ObjectInputStream in) {
        this.out = out;
        this.in = in; }
    public void start() throws  ClassNotFoundException, InterruptedException {
        boolean b = Boolean.FALSE;
        Person neo2 = new Person();
        while (true) {
            try {
                s = sc.nextLine();
                if (s.equals("info")  || s.contains("remove") || s.equals("show") || s.contains("add") || s.equals("exit")) {
                    if ((s.contains("add")) ||  (s.contains("remove"))) {
                        String[] mas = new String[6];
                        for (int i = 0; i < 3; i++) {
                            mas[i] = sc.nextLine();
                        }
                        if (mas[0].split("\"")[1].equals("Name") || mas[0].split("\"")[2].equals(":"))
                            neo2.Name = mas[0].split("\"")[3];
                        else break;
                        if (mas[1].split("\"")[1].equals("size") || mas[1].split("\"")[2].equals(":"))
                            neo2.size = Integer.parseInt(mas[1].split("\"")[3]);
                        else break;
                        if (mas[2].split("\"")[1].equals("place") || mas[2].split("\"")[2].equals(":"))
                            neo2.place = mas[2].split("\"")[3];
                        else break;
                        neo.s = neo2;
                    }
                    neo.com = s;
                    out.writeObject(neo);
                    out.reset();
                    if (neo.com.equals("exit")) {
                        System.exit(-1);
                    }
                    if (neo.com.equals("show")) {
                        String s[] =(String[])in.readObject();
                        for(int i=0;i<s.length;i++){if(!(s[i]==null))
                            System.out.println(s[i]);
                        }
                    }
                    if (neo.com.equals("info")) {
                        System.out.println(in.readObject());
                    }
                } else System.out.println("unknown command");
            } catch (SocketException e) {
                System.out.println("Соеденение прервано");
                break;
            } catch (Exception e) {
                System.out.println("Bad command");
            } } }}