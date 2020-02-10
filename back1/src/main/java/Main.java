
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Main {
<<<<<<< HEAD:back/src/main/java/Main.java
    public static void main(String []args)throws Exception{
=======
    public static void main(String []args) throws Exception{
>>>>>>> PK:back1/src/main/java/Main.java
        Frontend frontend=new Frontend();
        Server server=new Server(8070);
        ServletContextHandler context=new ServletContextHandler(ServletContextHandler.SESSIONS);
        server.setHandler(context);
        context.addServlet(new ServletHolder(frontend),"/mirror");
        server.start();
<<<<<<< HEAD:back/src/main/java/Main.java
        java.util.logging.Logger.getGlobal().info("Server started");
=======
>>>>>>> PK:back1/src/main/java/Main.java
        server.join();
    }




}
