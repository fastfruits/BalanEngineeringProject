package main;
import java.awt.*;

public class Main {

    public static Dimension minSize = new Dimension(400,400);

    public static void main(String[] args) throws Exception {
        System.out.println("Running...");
        //Sets up the main window JFrame used throughout the program for now.
        ActiveWindow window = new ActiveWindow(minSize);
    }

}