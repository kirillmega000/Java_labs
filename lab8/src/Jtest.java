import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class Jtest {
    public static void main(String [] args){
        JFrame frame = new JFrame("Testing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        Jcom j1=new Jcom(100,100,10);
        j1.setToolTipText("<html>" + "Line One" +"<br>" + "Line 2" + "</html>");
        frame.add(j1);
        frame.pack();
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        JButton btn1=new JButton("remobvre");
        btn1.setBounds(50, 160, 130, 30);

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                   j1.setr(50,50,10);
                   j1.repaint();
                }catch(Exception f){
                    JOptionPane.showMessageDialog(null, "Bad format", "Exception", JOptionPane.ERROR_MESSAGE);

                }

            }
        });

    }

}
