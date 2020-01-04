import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

public class mainClient {
    Scanner sc = new Scanner(System.in);
    start neo=null;
    CopyOnWriteArrayList Her=new CopyOnWriteArrayList();
    Runnable shut=null;
    OutputStream os=null;
    InputStream o=null;
    public void main(String [] args) throws IOException,ClassNotFoundException {

        try {

            Socket ss = new Socket("localhost", 6789);
            os = ss.getOutputStream();
            o = ss.getInputStream();

        } catch (IOException e) {
            System.out.println("Не удалось установить соеденение.");
            System.exit(-1);
        }

        ObjectInputStream a = new ObjectInputStream(o);
        ObjectOutputStream oos = new ObjectOutputStream(os);
        LinkClient lk = new LinkClient(oos,a);
        while (true) {
            String s = sc.nextLine();
            String[] mas = s.split(" ");
            if ((mas[0].equals("import")) && (FileWork.ReadFile(Her, mas[1]))) {
                neo.path=mas[1];
                neo.cho = 1;
                neo.Heroes = Her;
                oos.writeObject(neo);
                shut = () -> {
                    try {
                       Her=(CopyOnWriteArrayList<Person>)a.readObject();
                        FileWork.WriteFile(Her,neo.path);
                    } catch (ClassNotFoundException e) {
                        System.out.println("Error");
                    }
                    catch(IOException e){
                        System.out.println("Error");
                    }
                    System.out.println("Bye");
                };
                break;
            } else if (mas[0].equals("load")) {
                neo.cho = 2;
                neo.path = mas[1];
                oos.writeObject(neo);
                boolean b = a.readBoolean();
                if (!b) {
                    System.out.println("File not found");
                }else {shut = () -> {


                    System.out.println("Bye");
                };
                    break;}
            } else System.out.println("file not found");
        }
        lk.st=neo;
        Thread thread=new Thread(shut);
        Runtime.getRuntime().addShutdownHook(thread);
        lk.start();
    }
}
