/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
import java.io.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 *
 * @author Artem
 */
public class FileWork{
static String s[]=new String[100];
    public static void ReadFile (LinkedList<Person> Her )throws FileNotFoundException,IOException{
        String a=new String();
           int n=0;
    File file = new File("Link.json");
InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file));
    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
    while ((a=bufferedReader.readLine())!=null){
           
           s[n]=a;
         
           n+=1;
    
        
    }
 for(int i=0;i<n;i++){
     if (s[i].contains("\"")){
         String[] red =s[i].split("\"");
         Person neo=new Person(red[3]);
         Her.add(neo);
     }
 }
     bufferedReader.close();
}
    public static void WriteFile(LinkedList<Person> Her )throws IOException{
        File file = new File("Link.json");
FileWriter filewriter = new FileWriter(file); // поток который подключается к текстовому файлу
    BufferedWriter bufferedReader = new BufferedWriter(filewriter);
    bufferedReader.write("[");
    bufferedReader.newLine();
    for(int i=0;i<Her.size();i++){
        if (i==Her.size()-1)
        {
           bufferedReader.write("{");
    bufferedReader.newLine();
     bufferedReader.write("\"Name\":\""+Her.get(i).Name+"\"");
      bufferedReader.newLine();
       bufferedReader.write("}");
           bufferedReader.newLine(); 
        }
        else{
        bufferedReader.write("{");
    bufferedReader.newLine();
     bufferedReader.write("\"Name\":\""+Her.get(i).Name+"\"");
      bufferedReader.newLine();
       bufferedReader.write("},");
           bufferedReader.newLine();
    }
    }
    bufferedReader.write("]");
    bufferedReader.close();
    }
    
}
