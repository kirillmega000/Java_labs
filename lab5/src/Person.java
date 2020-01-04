/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kiril
 */
public class Person extends MHeroes implements Dialog, Shotter {
    public Person(String name){
        super(name);
    }
    protected String nosik = "Обычный нос";
    public Person(String name, String nosik){
        super(name);
        this.nosik=nosik;}
    public String getname(){
        return Name;
    }
    @Override
    public void speak(String msg){
        System.out.println(this.Name + " говорит: " + msg);
    }
    @Override
    public void doAction(String act){
        System.out.println(this.Name + " " +act);
    }
    public void upset(){
        System.out.print(this.Name + " Горькое действие ");

    }
    @Override
    public  void dial(int a){
        fall:{
            while (true){
                switch(a){
                    case 1: System.out.println(this.Name + ": Да, пожалуй есть!"); a = a+1;
                    case 2: System.out.println(this.Name + ": Вы кажется её знаете"); break fall;
                }
            }
        }
    }
    public void equalnos(String a, String b){
        if ((a).equals(b)){
            this.speak("Такой же прелестный носик, как у меня");

        } else{
            this.doAction(Actions.Action.кивнула.toString());
        }
    }
    public static class behaviour{
        public void dobehaviour (int a){
            class b1{
                String f ="Фрекен Бок подпрыгнула на своем стуле";
                void show(){
                    System.out.println(f);
                }
            }
            class b2{
                String f ="Глаза фрекен Бок прямо на лоб полезли";
                void show (){
                    System.out.println(f);
                }
            }

            if (a==1){
                b1 beh1 = new b1();
                beh1.show();
            }
            if (a==2){
                b2 beh2 = new b2();
                beh2.show();
            }
            if (a==3){
                b1 beh1 = new b1();
                beh1.show();
                b2 beh2 = new b2();
                beh2.show();
            }
        }
    }
    public class speech {
        String sp="Фрекен Бок крикнула вслед: После ночи с Филле и Рулле Карлсон стал задаваться еще больше, чем прежде.";
        public void dospeech ()
        {
            System.out.println(sp);
        }

    }
    @Override
    public String toString(){
        return "История начинается";
    }
    @Override
    public void shoot(){
        System.out.println("PEW PEW PEW");
    }

}
