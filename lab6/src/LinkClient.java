import com.sun.org.apache.xpath.internal.functions.FuncFalse;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

public class LinkClient {
    Scanner sc = new Scanner(System.in);
    ObjectInputStream in;
    ObjectOutputStream out;
    command neo;
    start st;
    public LinkClient( ObjectOutputStream out, ObjectInputStream in) {
        this.out = out;
        this.in = in;
    }

    public void start() throws IOException, ClassNotFoundException {
        String s;
        boolean b = Boolean.FALSE;


        while (true) {
            s = sc.nextLine();
            try {
                if ((s.contains("add")) || (s.contains("add_if_max"))) {
                    String[] mas = null;
                    String ch;
                    for (int i = 0; i < 4; i++) {
                        mas[i] = sc.nextLine();
                        ch = mas[i].split("\"")[3];
                        mas[i] = ch;
                    }
                    neo.s.Name = mas[0];
                    neo.s.size = Integer.parseInt(mas[1]);
                    neo.s.place = mas[2];
                    neo.s.dateofbirth = mas[3];

                }
                neo.com = s;
                out.writeObject(neo);
                if (neo.com.equals("exit")) {

                    return;
                }
                if (neo.com.equals("show")) {
                    CopyOnWriteArrayList<Person> Heroes = (CopyOnWriteArrayList<Person>) in.readObject();
                    for (int i = 0; i < Heroes.size(); i++) {
                        System.out.println(Heroes.get(i).Name + '\n' + Heroes.get(i).size + '\n' + Heroes.get(i).place + '\n' + Heroes.get(i).dateofbirth);
                    }


                }
                if (neo.com.equals("info")) {
                    System.out.println(in.readObject());
                }
                if (neo.com.equals("save") && st.cho == 1) {
                    FileWork.WriteFile((CopyOnWriteArrayList<Person>) in.readObject(), st.path);
                }
                b = in.readBoolean();
                if (b == Boolean.FALSE) System.out.println("Unknown command");
            }
            catch(Exception e){
                System.out.println("Unknown command");
            }
        }
    }
}