import org.omg.CORBA.IRObjectOperations;
import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.concurrent.CopyOnWriteArrayList;
public class mainServer {
    static CopyOnWriteArrayList<Person> Heroes=new CopyOnWriteArrayList<Person>();
    private static ServerSocket ss;
    private static Socket s;
    private static ObjectInputStream in;
    private static ObjectOutputStream out;
   static start neo=new start();
    static Runnable shut=null;
    public static void main(String[] args) throws IOException,ClassNotFoundException, SQLException {
        Runnable shut2 = null;
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/lab8";
        String login = "postgres";
        String password = "worldoftanks00";
        Connection con = DriverManager.getConnection(url, login, password);
        ss = new ServerSocket(4005);
        System.out.println("Сервер запущен!");
        while (true) {
            s = ss.accept();
            shut2 = () -> {
                try {
                    String user=new String();
                    out = new ObjectOutputStream(s.getOutputStream());
                    in = new ObjectInputStream(s.getInputStream());
                    while (true) {
                        neo = (start) in.readObject();
                        String sql = "SELECT  * FROM USERS  WHERE LOGIN = '" + neo.login + "'";
                        System.out.println(sql);
                        PreparedStatement stmt = con.prepareStatement(sql);
                        ResultSet rs = stmt.executeQuery();
                        if (neo.cho == 1) {
                            if (rs.next()) {
                                String str = rs.getString(2);
                                System.out.println(str);
                                if (str.equals(neo.login)) {
                                    out.writeObject("Ex");
                                    out.reset();
                                }
                            } else {
                                PasswordGenerator passwordGenerator = new PasswordGenerator.PasswordGeneratorBuilder()
                                        .useDigits(true)
                                        .useLower(true)
                                        .useUpper(true)
                                        .build();
                                String passw = passwordGenerator.generate(8);
                                boolean b = mail.sendmessage(neo.login, passw);
                                if (b) {
                                    sql = "INSERT INTO USERS (LOGIN,PASS)VALUES (?,?);";
                                    stmt = con.prepareStatement(sql);
                                    stmt.setString(1, neo.login);
                                    stmt.setString(2, passw);
                                    stmt.executeUpdate();
                                    user=neo.login;
                                    out.writeObject("Tr");
                                    out.reset();
                                    break;
                                } else {
                                    out.writeObject("Un");
                                    out.reset();
                                } } } else if (neo.cho == 2) {
                            if (rs.next()) {
                                String log = rs.getString(2);
                                System.out.println(log);
                                String pas = rs.getString(3);
                                if (neo.login.equals(log) && neo.pass.equals(pas)) {
                                    user=neo.login;
                                    out.writeObject("Tr");
                                    out.reset();
                                    break;
                                } else {
                                    out.writeObject("Wro");
                                    out.reset();
                                }
                            } else {
                                out.writeObject("Wro");
                                out.reset();
                            } } }
                    LinkServer lk=new LinkServer(out,in);
                    lk.user=user;
                    lk.con=con;
                    lk.start();
                } catch (Exception e) {
e.printStackTrace();
                } };
            Thread thread = new Thread(shut2);
            thread.start(); } }}