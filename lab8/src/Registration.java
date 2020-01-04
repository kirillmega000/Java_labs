import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Registration {
    JLabel l1, l2;
    JTextField tf1;
    JButton btn1, btn2;
    Registration(ObjectOutputStream out, ObjectInputStream in){
        start neo = new start();
        JFrame frame = new JFrame("Login Form");
        frame.setVisible(true);
        frame.setSize(700, 700);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Registration Form in Java");
        l1 = new JLabel("Registration Form in Windows Form:");
        l1.setForeground(Color.blue);
        l1.setFont(new Font("Serif", Font.BOLD, 20));
        l2 = new JLabel("Email-ID:");
        tf1 = new JTextField();
        btn1 = new JButton("Submit");
        btn2 = new JButton("Back");
        l1.setBounds(100, 30, 400, 30);
        l2.setBounds(80, 70, 200, 30);
        tf1.setBounds(300, 70, 200, 30);
        btn1.setBounds(50, 350, 100, 30);
        btn2.setBounds(170, 350, 100, 30);
        frame.add(btn1);
        frame.add(btn2);
        frame.add(l1);
        frame.add(l2);
        frame.add(tf1);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String g = tf1.getText();
                    neo.cho = 1;
                    neo.login = g;
                    out.writeObject(neo);
                    out.reset();
                    g = (String) in.readObject();
                    if (g.equals("Ex"))
                        JOptionPane.showMessageDialog(null, "Login already exists", "Ошибка", JOptionPane.ERROR_MESSAGE);
                    else if (g.equals("Un"))
                        JOptionPane.showMessageDialog(null, "Uncorrect email", "Ошибка", JOptionPane.ERROR_MESSAGE);
                    else {
                        JOptionPane.showMessageDialog(null, "Password send.Check your EMail.");
                        frame.setVisible(false);
                        frame.dispose();
                    }
                }catch(Exception f){
                    f.printStackTrace();
                }
            }
        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.dispose();
            }
        });
    }
}
