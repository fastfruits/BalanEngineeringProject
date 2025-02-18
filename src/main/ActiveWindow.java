package main;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ActiveWindow{
    public static JFrame window;

    public static JPanel btnPanel;

    public static JLabel text = new JLabel("Answer the question below correctly");

    public static JButton lesson1 = new JButton("<html>   Lesson 1\n(Variables)</html>");
    public static JButton lesson2 = new JButton("<html>   Lesson 2\n(Conditionals)</html>");
    public static JButton lesson3 = new JButton("<html>   Lesson 3\n(Loops)</html>");

    public static Component activeWindow = new Component() {};

    public static Dimension minSize;
    //Constructs the main window currently used throughout the program
    public ActiveWindow(Component c, Dimension d){
        minSize = d;
        activeWindow = c;
        window = new JFrame();
        btnPanel = new JPanel();

        window.setLayout(new BorderLayout());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true);
        window.setMinimumSize(d);
        window.setTitle("Programmer Professional");
        window.add(activeWindow);
        window.setBackground(Color.ORANGE);
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        lesson1.setPreferredSize(new Dimension(150, 100));
        lesson2.setPreferredSize(new Dimension(150, 100));
        lesson3.setPreferredSize(new Dimension(150, 100));

        btnPanel.setLayout(new FlowLayout());
        btnPanel.setSize(new Dimension(600,400));
        btnPanel.setVisible(true);

        window.add(text, BorderLayout.NORTH);
        btnPanel.add(lesson1);
        btnPanel.add(lesson2);
        btnPanel.add(lesson3);

        window.add(btnPanel);
        window.pack();

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

    public static Dimension getSize() {
        return minSize;
    }
    

}