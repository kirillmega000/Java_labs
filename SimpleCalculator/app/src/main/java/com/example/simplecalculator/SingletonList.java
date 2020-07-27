package com.example.simplecalculator;

import java.util.ArrayList;

public class SingletonList extends ArrayList<String>{
    private static SingletonList instance;
    public static SingletonList getInstance(){
        if(instance==null)
            instance=new SingletonList();
        return instance;
    }
}
