package sample.model;

import java.io.Serializable;

abstract public class  Person implements Serializable {
    private String name;
    private String surName;
    private String age;

    public Person(String name, String surName, String age){
        this.name = name;
        this.surName = surName;
        this.age = age;
    }

    public void setAge(String age) { this.age = age; }
    public void setName(String name) { this.name = name; }
    public void setSurName(String surName) { this.surName = surName; }

    public String getAge() { return age;}
    public String getName() { return name;}
    public String getSurName() { return surName;}
}
