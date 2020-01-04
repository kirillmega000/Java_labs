import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

public  class mainClient {


    static CopyOnWriteArrayList Her=new CopyOnWriteArrayList();


    private static Socket ss;
    private static ObjectInputStream in;
    private static ObjectOutputStream out;

    public static void main(String [] args) throws IOException,ClassNotFoundException,InterruptedException {
        Scanner sc = new Scanner(System.in);
        start neo=new start();
while(true){
        try {
            ss = new Socket("localhost", 4005);
            System.out.println("соединение установлено");
            in=new ObjectInputStream(ss.getInputStream());
            out=new ObjectOutputStream(ss.getOutputStream());

            String g=new String();
            while(true){
                g=sc.nextLine();
              if(g.equals("registrate")){
                  System.out.println("Write your email");
                  g=sc.nextLine();
                  neo.cho=1;
                  neo.login=g;
                  out.writeObject(neo);
                  out.reset();
                  g=(String)in.readObject();
                  System.out.println(g);
                  if(g.equals("Ex")) System.out.println("Login already exists");
                 else if(g.equals("Un")) System.out.println("Uncorrect email");
                 else {
                     System.out.println("Successful registration");
                     break;
                  }
              }
                if(g.equals("enter")){
                    System.out.println("Write your email");
                    g=sc.nextLine();
                    neo.login=g;
                    System.out.println("Pass");
                    g=sc.nextLine();
                    neo.pass=g;
                    neo.cho=2;

                    out.writeObject(neo);
                    out.reset();
                    g=(String)in.readObject();
                    if(g.equals("Wro")) System.out.println("Wrong email or pass");
                    else {
                        System.out.println("Successful enter");
                        break;
                    } } }
            LinkClient lk=new LinkClient(out,in);
            lk.start();
        } catch (IOException e) {

        }
    }
}
}
