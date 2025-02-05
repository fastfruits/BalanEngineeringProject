package main;

import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JFrame;

public class ActiveWindow{
    public static JFrame window;
    public static Component activeWindow= new Component() {

    };
    public static Dimension minSize;
    //Constructs the main window currently used throughout the program
    public ActiveWindow(Component c, Dimension d){
        minSize=d;
        activeWindow=c;
        window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true);
        window.setMinimumSize(minSize);
        window.setTitle("Programmer Professional");
        window.add(activeWindow);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    public static void setActiveWindow(Component activeWindow) {
        ActiveWindow.activeWindow = activeWindow;
    }
    public static void setMinSize(Dimension minSize) {
        ActiveWindow.minSize = minSize;
    }

    public static Component getActiveWindow() {
        return activeWindow;
    }

    public static Dimension getMinSize() {
        return minSize;
    }
    

}