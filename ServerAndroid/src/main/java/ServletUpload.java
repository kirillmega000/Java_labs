import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.eclipse.jetty.server.Request;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.Charset;


public class ServletUpload extends HttpServlet{

    private int bytesRead, bytesAvailable, bufferSize;
    private byte[] buffer;
    private int maxBufferSize = 1*1024*1024;
            @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MultipartConfigElement multipartConfigElement = new MultipartConfigElement((String)null);
        req.setAttribute(Request.__MULTIPART_CONFIG_ELEMENT, multipartConfigElement);
        System.out.println("Olla");
        String file=req.getPart("file1").getSubmittedFileName().split("/")[req.getPart("file1").getSubmittedFileName().split("/").length-1];
        System.out.println(file);
        FileUtils.writeByteArrayToFile(new File("sounds/"+file),IOUtils.toByteArray(req.getPart("file1").getInputStream()));
      byte [] b= IOUtils.toByteArray(req.getPart("description").getInputStream());
      System.out.println(new String(b,"UTF-8"));
    /*    DataInputStream in=new DataInputStream(req.getPart("file1").getInputStream());
        FileOutputStream out=new FileOutputStream(new File("sounds/"+file));
                bytesAvailable = in.available();
                bufferSize = Math.min(bytesAvailable, maxBufferSize);
                buffer = new byte[bufferSize];

                // Считывание файла в оперативную память и запись его в соединение
                bytesRead = in.read(buffer, 0, bufferSize);

                while (bytesRead > 0) {
                    out.write(buffer, 0, bufferSize);
                    bytesAvailable = in.available();
                    bufferSize = Math.min(bytesAvailable, maxBufferSize);
                    bytesRead = in.read(buffer, 0, bufferSize);
                }


        out.flush();
        out.close();
        in.close();*/

    }
}
