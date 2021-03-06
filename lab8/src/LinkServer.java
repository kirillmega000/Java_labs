import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Comparator;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;
public class LinkServer {
       public LinkServer(ObjectOutputStream out,ObjectInputStream in){
           this.out=out;
           this.in=in;
       }
    static  ObjectOutputStream out;
    static  ObjectInputStream in;
      command neo;
      Connection con;
      String user;
    public void start()throws IOException,ClassNotFoundException,SQLException {
        while(true){
            neo=(command)in.readObject();
            System.out.println(neo.com);
            if(neo.com.equals("exit")){
                System.exit(-1);
            }
            else { this.read(neo.com); } } }
    public void addel(Person neo) throws SQLException {
      String  sql = "INSERT INTO PERSON (NAME,SIZE,PLACE,DATEOFBIRTH,USERN)VALUES (?,?,?,?,?);";
      PreparedStatement  stmt = con.prepareStatement(sql);
        stmt.setString(1, neo.Name);
        stmt.setString(2, neo.size.toString());
        stmt.setString(3, neo.place);
        stmt.setString(4, time.gettime());
        stmt.setString(5, user);
        stmt.executeUpdate();
    }
    public void show() throws IOException,SQLException{
        String  sql = "SELECT  * FROM    PERSON";
        PreparedStatement  stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        int n=0;
        String [][] s=new String[100][5];
        while(rs.next()){
            s[n][0]=rs.getString(2);
            s[n][1]=rs.getString(3);
            s[n][2]=rs.getString(4);
            s[n][3]=rs.getString(5);
            s[n][4]=rs.getString(6);
            n+=1;
        }
        out.writeInt(n);
        out.reset();
        out.writeObject(s);
        out.reset();
    }
    public void remove(String name) throws SQLException{
        String  sql = "DELETE FROM PERSON WHERE ((USERN = '" + user + "') AND (NAME='"+ name + "'))";
        PreparedStatement  stmt = con.prepareStatement(sql);
        stmt.executeUpdate();
    }
    public void info() throws IOException{
        String s="Тип Person"+'\n'+"Дата инициализации 12.02.19";
        out.writeObject(s);
        out.reset();
    }
    public void us()throws  SQLException,IOException{
        String  sql = "SELECT  * FROM USERS";
        PreparedStatement  stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        int n=0;
        String [] s=new String[10];
        while(rs.next()){
            s[n]=rs.getString(2);

            n+=1;
        }
        out.writeInt(n);
        out.reset();
        out.writeObject(s);
        out.reset();



    }
    public void change(Person s) throws IOException,SQLException{
        int n=in.readInt();
        System.out.println(n);
        String  sql="f";
        if (n==1){  sql = "UPDATE  PERSON SET NAME='"+s.Name+"' WHERE ((USERN = '" + user + "') AND (SIZE ='"+ s.size+ "') AND (PlACE='"+s.place+"'))";

        }
        if (n==2){  sql = "UPDATE  PERSON SET SIZE ='"+s.size+"' WHERE ((USERN = '" + user + "') AND (NAME ='"+ s.Name+ "') AND (PlACE='"+s.place+"'))";

        }
        if (n==3){  sql = "UPDATE  PERSON SET PLACE ='"+s.place+"' WHERE ((USERN = '" + user + "') AND (NAME ='"+ s.Name+ "') AND (SIZE='"+s.size+"'))";

        }
        PreparedStatement  stmt = con.prepareStatement(sql);
        stmt.executeUpdate();

    }
    public void read(String com) throws ArrayIndexOutOfBoundsException,IOException,SQLException{
        try {
             if (com.contains("remove")) {
               this.remove(neo.s.Name);
            } else if (com.equals("show")) {
                 this.show();
            }  else if (com.equals("us")) {
                 this.us();
             }else if (com.equals("change")) {
                 this.change(neo.s);
             }else if (com.contains("add")) {
               this.addel(neo.s);
            } else if (com.contains("info")) {
                        this.info(); } }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("unknown command");
        }
   }
}
