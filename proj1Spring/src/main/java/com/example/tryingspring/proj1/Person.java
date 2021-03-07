package com.example.tryingspring.proj1;

public class Person {
    private String name;
    private int size;
    private String place;

    public Person(String name,int size,String place){
        this.name=name;
        this.size=size;
        this.place=place;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
