/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Arilon
 */
abstract  class MHeroes {
    public abstract void speak(String msg);
    protected String Name;
    public abstract void doAction(String act);
    public MHeroes(String name){
     
        this.Name=name;
    }
    
    
}
