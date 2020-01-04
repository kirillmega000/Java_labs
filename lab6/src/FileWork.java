/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
import java.io.*;
import java.util.concurrent.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 *
 * @author Artem
 */
public class FileWork{
static String s[]=new String[100];
    public static Boolean ReadFile (CopyOnWriteArrayList<Person> Her,String path )throws FileNotFoundException,IOException{
        Person neo=new Person();
        String a=new String();
        File file=null;
        InputStreamReader inputStreamReader=null;
        BufferedReader bufferedReader;
           int n=0;
           try {
             file = new File(path);
             inputStreamReader = new InputStreamReader(new FileInputStream(file));
             bufferedReader = new BufferedReader(inputStreamReader);
        }
        catch(FileNotFoundException e){
               return Boolean.FALSE;
        }

    while ((a=bufferedReader.readLine())!=null){
           
           s[n]=a;
         
           n+=1;
    
        
    }
 for(int i=0;i<n;i++){
     if (s[i].contains("\"")){
         String[] red =s[i].split("\"");

         if(red[1].equals("Name")){
             neo.Name=red[3];
         }
         if(red[1].equals("size")){
             neo.size=Integer.parseInt(red[3]);
         }
         if(red[1].equals("place")){
             neo.place=red[3];         }
         if(red[1].equals("dateofbirth")){
             neo.dateofbirth=red[3];         }
         if (s[i].contains("}")){
             Her.add(neo);
             neo.Name=null;
             neo.size=0;
             neo.place=null;
             neo.dateofbirth=null;
         }

     }
 }
     bufferedReader.close();
     return Boolean.TRUE;
}
    public static void WriteFile(CopyOnWriteArrayList<Person> Her,String path )throws IOException{
        File file = new File(path);
FileWriter filewriter = new FileWriter(file); // поток который подключается к текстовому файлу
    BufferedWriter bufferedReader = new BufferedWriter(filewriter);
    bufferedReader.write("[");
    bufferedReader.newLine();
    for(int i=0;i<Her.size();i++){


           bufferedReader.write("{");
    bufferedReader.newLine();
            bufferedReader.write("\"Name\":\""+Her.get(i).Name+"\""+",");
            bufferedReader.newLine();
            bufferedReader.write("\"size\":\""+Her.get(i).size+"\""+",");
            bufferedReader.newLine();
            bufferedReader.write("\"place\":\""+Her.get(i).place+"\""+",");
            bufferedReader.newLine();
            bufferedReader.write("\"dateofbirth\":\""+Her.get(i).dateofbirth+"\"");
            bufferedReader.newLine();
        if (i==Her.size()-1)
       bufferedReader.write("}");
        else
            bufferedReader.write("},");
           bufferedReader.newLine();




    }
    bufferedReader.write("]");
    bufferedReader.close();
    }
    
}
