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
      String  sql = "INSERT INTO PERSON (NAME,PLACE,SIZE,DATEOFBIRTH,USERN)VALUES (?,?,?,?,?);";
      PreparedStatement  stmt = con.prepareStatement(sql);
        stmt.setString(1, neo.Name);
        stmt.setString(2, neo.size.toString());
        stmt.setString(3, neo.place);
        stmt.setString(4, neo.dateofbirth);
        stmt.setString(5, user);
        stmt.executeUpdate();
    }
    public void show() throws IOException,SQLException{
        String  sql = "SELECT  * FROM PERSON WHERE USERN = '" + user + "'";
        PreparedStatement  stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        String s[]=new String[50];
        int n=0;
        while (rs.next()) {
            s[n]=rs.getString(2)+"|"+rs.getString(3)+"|"+rs.getString(4)+"|"+rs.getString(5)+"|";
            n+=1;
        }
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
    public void read(String com) throws ArrayIndexOutOfBoundsException,IOException,SQLException{
        try {
             if (com.contains("remove")) {
               this.remove(neo.s.Name);
            } else if (com.equals("show")) {
                 this.show();
            } else if (com.contains("add")) {
               this.addel(neo.s);
            } else if (com.contains("info")) {
                        this.info(); } }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("unknown command");
        }
   }
}
