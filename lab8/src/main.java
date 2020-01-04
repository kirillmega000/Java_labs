import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

public class main {
    public static void main(String[] args) throws UnknownHostException, IOException {

            try {
                Socket ss = new Socket("localhost", 2007);

                System.out.println("соединение установлено");
                ObjectInputStream in = new ObjectInputStream(ss.getInputStream());
                ObjectOutputStream out = new ObjectOutputStream(ss.getOutputStream());
                new Auto(in, out);
            } catch (ConnectException e) {
                JOptionPane.showMessageDialog(null, "Connection lost");
            }


    }
}