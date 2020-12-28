package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.model.Device;
import sample.model.Manager;

import java.io.*;
import java.util.ArrayList;

import static sample.model.Shop.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("fxmlFile/main.fxml"));
        primaryStage.setTitle("Fiksyk Shop");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 700, 400));
        primaryStage.show();
    }

    public static void main(String[] args) {
        try (ObjectInputStream oisManager = new ObjectInputStream(new FileInputStream("managers.dat"));
             ObjectInputStream oisComputer = new ObjectInputStream(new FileInputStream("computers.dat"));
             ObjectInputStream oisAccessories = new ObjectInputStream(new FileInputStream("accessories.dat"))) {
            listManagers =(ArrayList<Manager>) oisManager.readObject();
            listComputers =(ArrayList<Device>) oisComputer.readObject();
            listAccessories =(ArrayList<Device>) oisAccessories.readObject();
        } catch (IOException | ClassNotFoundException e) { System.out.println(e.getMessage()); }
        launch(args);
//        addDevice(listAccessories, "moues", "UK", "good device", "200", 21);
//        addDevice(listAccessories, "keyBord", "USA", "import device", "200", 48);
//        addDevice(listComputers, "com1", "USA", "not bad computer", "12000", 8);
//        addDevice(listComputers, "com1", "RU", "bad device", "5000", 48);
//        addManager("Vlad", "Lisnenko", "18", "Manager", "0990717157",
//                "2000");
//        addManager("Vova", "Kolanod", "25", "Manager", "xx-xx-xx-xx-xx",
//                "3200");
        try (ObjectOutputStream oosManager = new ObjectOutputStream(new FileOutputStream("managers.dat"));
             ObjectOutputStream oosComputer = new ObjectOutputStream(new FileOutputStream("computers.dat"));
             ObjectOutputStream oosAccessories = new ObjectOutputStream(new FileOutputStream("accessories.dat"))) {
            oosManager.writeObject(listManagers);
            oosAccessories.writeObject(listAccessories);
            oosComputer.writeObject(listComputers);
        } catch (IOException e) { e.printStackTrace();}
    }
}



