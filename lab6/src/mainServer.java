import org.omg.CORBA.IRObjectOperations;

import java.io.*;

import java.net.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class mainServer {
    static CopyOnWriteArrayList<Person> Heroes=new CopyOnWriteArrayList<Person>();
    public static void main(String[] args) throws IOException,ClassNotFoundException {
        start neo=null;
        Runnable shut=null;
        OutputStream os=null;
        InputStream o=null;
        try {ServerSocket ss=new ServerSocket(6789);
            Socket s=ss.accept();
             os=s.getOutputStream();
            o=s.getInputStream();

        } catch (IOException e) {
            System.out.println("Не удалось установить соеденение.");
            System.exit(-1);
        }
        ObjectInputStream a = new ObjectInputStream(o);
        ObjectOutputStream oos=new ObjectOutputStream(os);
        LinkServer lk=new LinkServer(Heroes,oos,a);
        String path=neo.path;
        while(true) {
            neo=(start)a.readObject();
            if (neo.cho == 1) {
                lk.Heroes = neo.Heroes;

                shut = () -> {
                    try {
                        oos.writeObject(lk.Heroes);
                    } catch (IOException e) {
                        System.out.println("Error");
                    }
                };
                break;
            } else if (neo.cho == 2) {
                boolean b=FileWork.ReadFile(lk.Heroes, neo.path);
                oos.writeBoolean(b);
                shut = () -> {
                    try {
                        FileWork.WriteFile(lk.Heroes, path);
                    } catch (IOException e) {
                        System.out.println("Error");
                    }
                };
                if(b) break;
            }
        }
        lk.st=neo;
        Thread thread=new Thread(shut);
        Runtime.getRuntime().addShutdownHook(thread);
         lk.start();
    }
}