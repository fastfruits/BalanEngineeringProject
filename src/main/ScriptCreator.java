package main;

import java.awt.*;
import javax.swing.*;


public class ScriptCreator {
    public static JPanel[] scripts;
    public static JButton[] buttons;

    public ScriptCreator(String[] arr) {
        scripts = new JPanel[arr.length];
        buttons = new JButton[arr.length];
        for(int i = 0; i<arr.length;i++){
            scripts[i]=new JPanel(new GridBagLayout());
            buttons[i]=new JButton("Next");
            GridBagConstraints textPos=new GridBagConstraints();
            textPos.gridx=1;
            textPos.gridy=1;
            GridBagConstraints nextPos = new GridBagConstraints();
            nextPos.gridx=2;
            nextPos.gridy=2;
            nextPos.anchor=GridBagConstraints.PAGE_END;
            scripts[i].add(new JLabel(arr[i]),textPos);
            scripts[i].add(buttons[i],nextPos);
        }
    }
    public JPanel getScript(int i){
        System.out.println(i);
        return scripts[i];
    }
    public JButton getButton(int i){
        return buttons[i];
    }
    public int getLength(){
        return scripts.length;
    }

    
}
