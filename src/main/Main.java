package main;

import javax.swing.JFrame;

public class Main {

    public static JFrame window;
    public ActiveWindow activeWindow = new ActiveWindow();

    public static void main(String[] args) throws Exception {
        System.out.println("Running...");
        setUpWindow();

    }

    //Sets up the main window JFrame used throughout the program for now.
    public void setUpWindow(){
        window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true);
        window.setTitle("Programmer Professional");
        window.add(activeWindow);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

}