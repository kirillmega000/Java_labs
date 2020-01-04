import java.awt.*;
import java.awt.event.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.sql.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Vector;
import java.util.regex.PatternSyntaxException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class JTableExample {

    //Массив содержащий заголоки таблицы
    Object[] headers = { "id","Name", "size", "place","dateofbirth","user" };
    static ResultSet rs;
    static String user;
    static String prev;
    static ArrayList<Color> Colors=new ArrayList<Color>();
    static ObjectInputStream in;
    static ObjectOutputStream out;
    static ResourceBundle resourceBundle;
    //Массив содержащий информацию для таблицы
    static Object[][] data ;
    static String[]users;
    static int nu;
    //Объект таблицы
    JTable jTabPeople;
    JPanel center=new JPanel();
    JPanel anim=new JPanel();
    ArrayList<Jcom> obb=new ArrayList<Jcom>();
    JFrame jfrm;
    TableModel mod;
    JTableExample() throws SQLException,InterruptedException {
//Создаем новый контейнер JFrame 
         jfrm = new JFrame("JTableExample");

        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.getContentPane().setBackground(Color.yellow);
        jfrm.setVisible(true);
        jfrm.setLayout(null);
        JButton btn1 = new JButton((resourceBundle.getString("add")));
        JButton btn2 = new JButton((resourceBundle.getString("remove")));
        JButton btn3 = new JButton((resourceBundle.getString("filter")));
        JTextField tf1=new JTextField("Name");
        JTextField tf2=new JTextField("size");
        JTextField tf3=new JTextField("place");
        JTextField tf4=new JTextField();
        JTextField tf5=new JTextField("row");
        JLabel tfu=new JLabel("Current user:"+user);
        tf1.setName("Name");
         mod=new DefaultTableModel(data,headers){

            @Override
            public boolean isCellEditable(int row, int column) {
//all cells false
                return !(column==5)&&!(column==4)&&(jTabPeople.getModel().getValueAt(row, 5).toString().equals(user));
            }
        };
        jTabPeople = new JTable();
        jTabPeople.setModel(mod);



        center.setLayout(null);
        circles();
        center.setBackground(jfrm.getBackground());
        anim.setLayout(null);
        anim.setBounds(115,400,200,50);

        anim.setBackground(new Color(255,255,255));

        jfrm.add(anim);
        JScrollPane spane = new JScrollPane();
        spane.setBounds(500,160,360,600);
        spane.setViewportView(center);
        jfrm.add(spane);


        JTextField tf6=new JTextField();
//Устанавливаем диспетчер компоновки
        jfrm.setLocationRelativeTo(null);
        jfrm.getContentPane().setLayout(new BorderLayout());
//Устанавливаем размер окна
        jfrm.setSize(1000, 500);
        btn1.setBounds(50, 160, 130, 30);
        btn2.setBounds(200,160,130,30);
        btn3.setBounds(350,160,130,30);
        tf1.setBounds(50, 200, 130, 30);
        tf2.setBounds(50, 240, 130, 30);
        tf3.setBounds(50, 280, 130, 30);
        tf4.setBounds(50, 320, 130, 30);
        tf5.setBounds(200,200,130,30);
        tfu.setBounds(200,240,260,30);
        tf6.setBounds(350,200,130,30);
//Устанавливаем завершение программы при закрытии окна 

//Создаем новую таблицу на основе двумерного массива данных и заголовков 

        RowSorter<TableModel> sorter = new TableRowSorter<>(mod);
        jTabPeople.setRowSorter(sorter);
//Создаем панель прокрутки и включаем в ее состав нашу таблицу 
        JScrollPane jscrlp = new JScrollPane(jTabPeople);
//Устаналиваем размеры прокручиваемой области 
        jTabPeople.setPreferredScrollableViewportSize(new Dimension(100, 120));
        jTabPeople.setMaximumSize(new Dimension(400, 120));
//Добавляем в контейнер нашу панель прокрути и таблицу вместе с ней 
        jfrm.getContentPane().add(jscrlp, BorderLayout.NORTH);
        btn1.setToolTipText("asd");
        jfrm.add(btn1);
        jfrm.add(btn2);
        jfrm.add(btn3);
        jfrm.add(tf1);
        jfrm.add(tf2);
        jfrm.add(tf3);
        jfrm.add(tf5);
        jfrm.add(tf6);
        jfrm.add(tfu);
        jfrm.add(tf4);
//Отображаем контейнер 
        jfrm.setVisible(true);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               try {
                   Vector<String> v = new Vector<String>(6);
                   command neo=new command();
                   Person neo2 = new Person();
                   neo.com = "add";
                   neo2.Name = tf1.getText();
                   neo2.size = Integer.parseInt(tf2.getText());
                   neo2.place = tf3.getText();
                   neo.s=neo2;
                   out.writeObject(neo);
                   out.reset();

                   Integer a = mod.getRowCount();
                   v.add(a.toString());
                   v.add(tf1.getText());
                   v.add(tf2.getText());
                   v.add(tf3.getText());
                   v.add(time.gettime());
                   v.add(user);
                   ((DefaultTableModel) mod).addRow(v);
                   circles();
                   new Thread(new Runnable() {
                       @Override
                       public void run(){
                           try {
                               Janim ja = new Janim();
                               ja.setcol(Color.BLUE);

                               ja.setBounds(0, 0, 360, 600);
                               anim.add(ja);
                               anim.repaint();
                               Thread.currentThread().sleep(1000);
                               anim.removeAll();
                               anim.repaint();
                               Thread.currentThread().sleep(1000);
                               ja.setcol(Color.RED);
                               anim.add(ja);
                               anim.repaint();
                               Thread.currentThread().sleep(1000);
                               anim.removeAll();
                               anim.repaint();
                           }catch (Exception f){
                               f.printStackTrace();
                           }
                       }
                   }).start();
               }catch(Exception f){
                   JOptionPane.showMessageDialog(null, "Bad format", "Exception", JOptionPane.ERROR_MESSAGE);

               }

            }
        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

try {
    int n=Integer.parseInt(tf5.getText());
    if(jTabPeople.getValueAt(n, 5).toString().equals(user)) {
        for (int i = n; i < mod.getRowCount(); i++) {
            Object ob = mod.getValueAt(i, 0);
            int s = Integer.parseInt(ob.toString()) - 1;
            jTabPeople.setValueAt(s, i, 0);
        }
        command neo = new command();
        Person neo2 = new Person();
        neo.com = "remove";
        neo2.Name = mod.getValueAt(n, 1).toString();
        neo2.size = Integer.parseInt(mod.getValueAt(n, 2).toString());
        neo2.place = mod.getValueAt(n, 3).toString();
        neo.s = neo2;
        out.writeObject(neo);
        out.reset();
        ((DefaultTableModel) mod).removeRow(Integer.parseInt(tf5.getText()));
        circles();
    }else  JOptionPane.showMessageDialog(null, "Not your object", "Exception", JOptionPane.ERROR_MESSAGE);
}catch (Exception f){
    JOptionPane.showMessageDialog(null, "Bad format", "Exception", JOptionPane.ERROR_MESSAGE);
}

            }
        });
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = tf6.getText();
                if (text.length() == 0) {
                    ((TableRowSorter<TableModel>) sorter).setRowFilter(null);
                } else {
                    try {
                        ((TableRowSorter<TableModel>) sorter)
                                .setRowFilter(RowFilter
                                        .regexFilter(text));
                        circles();
                    } catch (PatternSyntaxException pse) {
                        System.err.println("Bad regex pattern");
                    }
                }
            }
        });
        jTabPeople.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int col = jTabPeople.columnAtPoint(e.getPoint());
                int row = jTabPeople.rowAtPoint(e.getPoint());
                prev= (String)jTabPeople.getValueAt(row, col);
            }
        });
       jTabPeople.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                try {int row = jTabPeople.getSelectedRow();
                    int col = jTabPeople.getSelectedColumn();
                    command neo = new command();
                    Person neo2 = new Person();
                    neo2.size = Integer.parseInt(mod.getValueAt(row, 2).toString());
                    Object ob = mod.getValueAt(row, col);
                    jTabPeople.setValueAt(ob, row, col);
                    neo.com = "change";
                    neo2.Name = mod.getValueAt(row, 1).toString();
                    neo2.place = mod.getValueAt(row, 3).toString();
                    neo.s = neo2;
                    out.writeObject(neo);
                    out.reset();
                    out.writeInt(col);
                    out.reset();
                    circles();
                }catch (Exception f){
                    int row = jTabPeople.getSelectedRow();
                    int col = jTabPeople.getSelectedColumn();
                    mod.setValueAt(prev, row, col);
                    JOptionPane.showMessageDialog(null, "Bad format", "Exception", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
/* v=mod.getDataVector(); 
ArrayList <String> numdata = new ArrayList<String>(); 

for(int count = 0; count < mod.getRowCount(); count++){ 
numdata.add(mod.getValueAt(count, 1).toString()); 

} 
System.out.println(numdata);*/
    }
   public void circles(){

       center.removeAll();
       obb.clear();
       center.setPreferredSize(new Dimension(360, mod.getRowCount()/3*120));
for(int i=0;i<mod.getRowCount();i++){
    Jcom j1=new Jcom();
    int x=i%3*120;
    int y=i/3*120;
    int size=Integer.parseInt(mod.getValueAt(i,2).toString());
    if(size>100) size=100;
    for(int j=0;j<nu;j++){
        if (users[j].equals(jTabPeople.getModel().getValueAt(i, 5).toString())){
            j1.setcol(Colors.get(j));
        }
    }
    j1.setr(x,y,size);
    j1.setToolTipText( "<html>" + jTabPeople.getModel().getValueAt(i, 1).toString() +"<br>" +
            jTabPeople.getModel().getValueAt(i, 2).toString() +"<br>" +
            jTabPeople.getModel().getValueAt(i, 3).toString() +"<br>" +
            jTabPeople.getModel().getValueAt(i, 4).toString() +"<br>" +
            jTabPeople.getModel().getValueAt(i, 5).toString() +"<br>" +"</html>" );
    obb.add(i,j1);
    center.add(obb.get(i));
    SwingUtilities.updateComponentTreeUI(jfrm);
    center.revalidate();
    center.repaint();
} }





    //Функция main, запускающаяся при старте приложения
    public static void main(ObjectInputStream in, ObjectOutputStream out,String user,ResourceBundle res) {
//Создаем фрейм в потоке обработки событий 

                try{
                    resourceBundle=res;
                   JTableExample.in=in;
                    JTableExample.out=out;
                    JTableExample.user=user;
                    command neo2=new command();
                    neo2.com="show";
                   out.writeObject(neo2);
                   out.reset();
                   int n=in.readInt();
                    data=new Object[n][6];
                    String s[][]=(String[][])in.readObject();
                    for(int i=0;i<n;i++){
                        data[i][0]=i;
                        for(int j=1;j<6;j++) data[i][j]=(Object)s[i][j-1];
                    }
                    neo2.com="us";
                    out.writeObject(neo2);
                    nu=in.readInt();
                    users=(String[])in.readObject();
                    for(int i=0;i<nu;i++){
                        int r=(int)(Math.random()*255);
                        int g=(int)(Math.random()*255);
                        int b=(int)(Math.random()*255);
                        Colors.add(new Color(r,g,b));
                    }

                    new JTableExample();

                }
                catch(Exception e){
                    e.printStackTrace();

                }

            }


}