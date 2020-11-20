public class ClassExt extends SuperClass {
   private String str="hello";
   @Override
    public String getstr(){
        return this.str;
    }
    @Override
    public void setStr(String str){
        super.str=str;
    }
    public String getoldstr(){
        return super.str;
    }
    public static void main(String [] args){
       SuperClass sup=new SuperClass();
       System.out.println(sup.getstr());
       ClassExt ext=new ClassExt();
       System.out.println(ext.getstr());
       ext.setStr("23");
        System.out.println(ext.getoldstr());

   }
}
