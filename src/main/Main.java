package main;
import java.awt.*;

public class Main {
    public static Component component= new Component(){

    };

    public static Dimension minSize = new Dimension(800,600);

    public static void main(String[] args) throws Exception {
        System.out.println("Running...");
        //Sets up the main window JFrame used throughout the program for now.
        ActiveWindow window = new ActiveWindow(component, minSize);
    }

}