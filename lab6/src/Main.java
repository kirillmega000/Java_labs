
    import java.io.*;
    /**
     *
     * @author Arilon
     */
    public class Main {
        static  Link lk = new Link();
        static class Shut extends Thread {
            public void run() {
                try {
                    FileWork.WriteFile(lk.Heroes);
                    System.out.println("Bye.");
                } catch (IOException e) {
                    System.out.println("Error");
                }
            }
        }
        public static void main(String[] args) throws IOException{
            Runtime.getRuntime().addShutdownHook(new Shut());
            lk.start();

       /* Storyteller storyone = new Storyteller(){
             @Override
             public void story() {
    Person ph = new Person("Филле","Прелестный носик");

        Person fk = new Person("Фрекен Бок","Прелестный носик");
        Person.behaviour beha = new Person.behaviour();
            Person.speech say =  fk. new speech ();
            Person ru = new Person("Рулле");
        Person fr = new Person("Фрейгатен");
        Person kr = new Person("Каролосон");
        Person jl = new Person("Дядя Джулиус");
       fr.speak(fr.toString());
       beha.dobehaviour(3);
       if ((int)(Math.random()*10) <= 5) {
           ph.doAction(Actions.Action.Растерялся.toString());
           fk.doAction(Actions.Action.кивнула.toString());
        } else {
           ph.doAction(Actions.Action.Поражен.toString());
           fk.doAction(Actions.Action.кивнула.toString());
           fk.upset();
        }

       fk.dial(1);
       fr.speak("...");
       fk.equalnos(ph.nosik, fk.nosik);
       ph.doAction(Actions.Action.Отчаился.toString());
       ph.doAction(Actions.Action.Сваливает.toString());
       kr.doAction(Actions.Action.Стоит.toString());
       jl.shoot();
       jl.doAction(Actions.Action.Стреляет.toString());
       ph.doAction(Actions.Action.подскочил.toString());
       ru.doAction(Actions.Action.подскочил.toString());
       ph.doAction(Actions.Action.Роется.toString());
       ru.doAction(Actions.Action.Роется.toString());
       Thing t1;
       Thing t2;
       Thing t3;

       if ((int)(Math.random()*10) <= 5) {
        t1 = new Thing("кошель", 20);
        t2 = new Thing("кошель", 20);
        t3 = new Thing("часы", 10);
       }else{
            t1 = new Thing("часы", 10);
            t2 = new Thing("кошель", 10);
            t3 = new Thing("часы", 20);
       }
       if(t1.equals(t3)) {
           t1.stay();
       }
       else{
           t1.stay2();
       }
       say.dospeech();
    }
};

        try{
            go_on.go();
          storyone.story();

        }
          catch(matexp e){
             System.out.println(e.getMessage());

          }
         */
        }
}
