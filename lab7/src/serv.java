import java.util.Scanner;

public class serv     {
    public void dovn(){
        String mas[]=new String[5];
        command neo=new command();
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            mas[i] = sc.nextLine();

        }while(true) {
            if (mas[0].split("\"")[1].equals("Name") || mas[0].split("\"")[2].equals(":"))
                neo.s.Name = mas[0].split("\"")[3];
            else break;
            if (mas[1].split("\"")[1].equals("size") || mas[1].split("\"")[2].equals(":"))
                neo.s.size = Integer.parseInt(mas[1].split("\"")[3]);
            else break;
            if (mas[2].split("\"")[1].equals("place") || mas[2].split("\"")[2].equals(":"))
                neo.s.place = mas[2].split("\"")[3];
            else break;
            if (mas[3].split("\"")[1].equals("place") || mas[3].split("\"")[2].equals(":"))
                neo.s.dateofbirth = mas[3].split("\"")[3];
            else break;
        }
    }
}
