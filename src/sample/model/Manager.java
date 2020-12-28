package sample.model;

import java.io.Serializable;

public class Manager extends Person implements Serializable {
    private String position;
    private String phoneNumber;
    private String salary;

    public Manager(String name, String surName, String age, String position, String phoneNumber, String salary){
        super(name, surName, age);
        this.phoneNumber = phoneNumber;
        this.position = position;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return getSurName() + " " + getName();
    }

    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setPosition(String position) { this.position = position; }
    public void setSalary(String salary) { this.salary = salary;}

    public String getSalary() { return salary; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getPosition() { return position; }
}
