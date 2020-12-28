package sample.model;

import java.util.ArrayList;

public class Shop {
    public static ArrayList<Device> listAccessories = new ArrayList<>();
    public static ArrayList<Device> listComputers = new ArrayList<>();
    public static ArrayList<Manager> listManagers = new ArrayList<>();

    static public void addManager(String name, String surName,  String age, String position, String phoneNumber, String salary){
        Manager manager = new Manager(name, surName, age, position, phoneNumber, salary);
        listManagers.add(manager);
    }
    static public void removeManager(Manager manager){ listManagers.remove(manager); }
    static public void editManager(Manager manager, String name, String surName,  String age, String position, String phoneNumber, String salary){
        manager.setName(name);
        manager.setSurName(surName);
        manager.setAge(age);
        manager.setPosition(position);
        manager.setPhoneNumber(phoneNumber);
        manager.setSalary(salary);
    }
    static  public ArrayList<Manager> searchManager(String name){
        ArrayList<Manager> managerArrayList = new ArrayList<>();
        for (Manager manager: listManagers) {
            if((manager.getSurName() + " " + manager.getSurName()).equals(name)) managerArrayList.add(manager);
            if(manager.getName().equals(name)) managerArrayList.add(manager);
            if(manager.getSurName().equals(name)) managerArrayList.add(manager);
        }
        return  managerArrayList;
    }
    static public void addDevice(ArrayList<Device> list,String name, String countryOfManufacture,
                                   String characteristic, String price, int count){
        Device computer = new Device(name, countryOfManufacture, characteristic, price, count) {
        };
        list.add(computer);
    }
    static public void removeDevice(Device device, ArrayList<Device> list){ list.remove(device); }
    static public void editDevice(Device device,String name, String countryOfManufacture,
                                  String characteristic, String price, int count){
        device.setAvailability(count);
        device.setCharacteristic(characteristic);
        device.setName(name);
        device.setPrice(price);
        device.setCountryOfManufacture(countryOfManufacture);
    }
    static public int getCount(ArrayList<Device> devices){
        int count = 0;
        for (Device device: devices) {
            count += device.getCount();
        }
        return count;
    }

    static  public ArrayList<Device> searchDevice(ArrayList<Device> list, String str){
        ArrayList<Device> deviceArrayList = new ArrayList<>();
        for (Device device: list) {
            if(device.getName().equals(str)) deviceArrayList.add(device);
            if(device.getCountryOfManufacture().equals(str)) deviceArrayList.add(device);
        }
        return  deviceArrayList;
    }
}
