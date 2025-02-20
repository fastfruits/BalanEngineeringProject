package main;


import javax.swing.*;

public class QuestionCreator{

    public static JLabel question;
    public static JPanel[] qArr;
    public static String[] ansKey;
    public static JButton[] buttons;


    public QuestionCreator(String[] arr){
        qArr= new JPanel[arr.length/6];
        ansKey=new String[arr.length/6];
        buttons = new JButton[(arr.length/6)*4];
        int cnt =0;
        for(int i =0;i<arr.length;i+=6){
            JPanel add = new JPanel();
            add.setLayout(new BoxLayout(add, BoxLayout.PAGE_AXIS));
            add.add(new JLabel(arr[i]));
            JButton ans1=new JButton(arr[i+1]);
            JButton ans2=new JButton(arr[i+2]);
            JButton ans3=new JButton(arr[i+3]);
            JButton ans4=new JButton(arr[i+4]);
            add.add(ans1);
            add.add(ans2);
            add.add(ans3);
            add.add(ans4);
            buttons[4*cnt]=ans1;
            buttons[4*cnt+1]=ans2;
            buttons[4*cnt+2]=ans3;
            buttons[4*cnt+3]=ans4;
            qArr[cnt]=add;
            ansKey[cnt]=arr[i+5];

            cnt++;
        }
    }
    
    public JPanel getQuestion(int i){
        return qArr[i];
    }
    public JButton getAns(int i, int qNum){
        return buttons[4*qNum+i];
    }
    public String getAnsString(int i, int qNum){
        return buttons[4*qNum+i].getActionCommand();
    }
    public boolean cmprAns(String s, int i){
        return s.substring(0,1).equals(ansKey[i].substring(0, 1));
    }
    public int getLength(){
        return qArr.length;
    }

}
