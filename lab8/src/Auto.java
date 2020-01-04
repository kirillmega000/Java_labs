import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import java.util.Locale;
import java.util.ResourceBundle;


import javax.swing.*;

public class Auto{
    Locale locale;
    ResourceBundle resourceBundle=ResourceBundle.getBundle("resources");
    JLabel l1, l2, l3;
    JTextField tf1;
    JButton btn1, btn2;
    JPasswordField p1;
    JButton rus,prt,hu,sp;
    start neo=new start();
    Auto(ObjectInputStream in,ObjectOutputStream out) {

        JFrame frame = new JFrame("Login Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.cyan);
        l1 = new JLabel(resourceBundle.getString("auth"));
        l1.setForeground(Color.blue);
        l1.setFont(new Font("Serif", Font.BOLD, 20));
        l2 = new JLabel(resourceBundle.getString("login"));
        l3 = new JLabel(resourceBundle.getString("pass"));
        tf1 = new JTextField();
        p1 = new JPasswordField();
        btn1 = new JButton(resourceBundle.getString("login"));
        btn2 = new JButton(resourceBundle.getString("reg"));
        rus = new JButton("Rus");
        prt = new JButton("Prt");
        hu = new JButton("Hu");
        sp = new JButton("Sp");
        l1.setBounds(100, 30, 400, 30);
        l2.setBounds(80, 70, 200, 30);
        l3.setBounds(80, 110, 200, 30);
        tf1.setBounds(300, 70, 200, 30);
        p1.setBounds(300, 110, 200, 30);
        btn1.setBounds(150, 160, 100, 30);
        btn2.setBounds(260,160,130,30);
        rus.setBounds(350,200,130,30);
        prt.setBounds(350,250,130,30);
        hu.setBounds(350,300,130,30);
        sp.setBounds(350,350,130,30);
        frame.add(l1);
        frame.add(l2);
        frame.add(tf1);
        frame.add(l3);
        frame.add(p1);
        frame.add(btn1);
        frame.add(btn2);
        frame.add(rus);
        frame.add(prt);
        frame.add(hu);
        frame.add(sp);
        frame.setSize(600, 600);
        frame.setLayout(null);
        frame.setVisible(true);
        rus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                locale = new Locale("ru","RU");
                resourceBundle = ResourceBundle.getBundle("resources",locale, new UTF8Control());
                l1.setText(resourceBundle.getString("auth"));
                l2.setText(resourceBundle.getString("login"));
                l3.setText(resourceBundle.getString("pass"));
                btn1.setText(resourceBundle.getString("login"));
                btn2.setText(resourceBundle.getString("reg"));
                SwingUtilities.updateComponentTreeUI(frame);
                frame.invalidate();
                frame.validate();
                frame.repaint();
            }
        });
        prt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                locale = new Locale("pt","PRT");
                resourceBundle = ResourceBundle.getBundle("resources",locale);
                l1.setText(resourceBundle.getString("auth"));
                l2.setText(resourceBundle.getString("login"));
                l3.setText(resourceBundle.getString("pass"));
                btn1.setText(resourceBundle.getString("login"));
                btn2.setText(resourceBundle.getString("reg"));
                SwingUtilities.updateComponentTreeUI(frame);
                frame.invalidate();
                frame.validate();
                frame.repaint();
            }
        });
        hu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                locale = new Locale("hu","HU");
                resourceBundle = ResourceBundle.getBundle("resources",locale);
                l1.setText(resourceBundle.getString("auth"));
                l2.setText(resourceBundle.getString("login"));
                l3.setText(resourceBundle.getString("pass"));
                btn1.setText(resourceBundle.getString("login"));
                btn2.setText(resourceBundle.getString("reg"));
                SwingUtilities.updateComponentTreeUI(frame);
                frame.invalidate();
                frame.validate();
                frame.repaint();
            }
        });
        sp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                locale = new Locale("sp","SP");
                resourceBundle = ResourceBundle.getBundle("resources",locale);
                l1.setText(resourceBundle.getString("auth"));
                l2.setText(resourceBundle.getString("login"));
                l3.setText(resourceBundle.getString("pass"));
                btn1.setText(resourceBundle.getString("login"));
                btn2.setText(resourceBundle.getString("reg"));
                SwingUtilities.updateComponentTreeUI(frame);
                frame.invalidate();
                frame.validate();
                frame.repaint();
            }
        });
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                neo.login=tf1.getText();
                try {
                    neo.cho = 2;
                    neo.login=tf1.getText();
                    neo.pass=p1.getText();
                    out.writeObject(neo);
                    out.reset();
                    String g = (String) in.readObject();
                    if (g.equals("Wro"))
                        JOptionPane.showMessageDialog(null, "Wrong email or pass", "Упс!", JOptionPane.ERROR_MESSAGE);
                    else {
                        JOptionPane.showMessageDialog(null, "Successful enter");
                        JTableExample.main(in,out,neo.login,resourceBundle);
                        frame.setVisible(false);
                        frame.dispose();
                    }
                    }catch (Exception f){
                    f.printStackTrace();
                }
            }
        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             new Registration(out,in);
            }
        });
    }


}