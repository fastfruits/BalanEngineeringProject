package main;

import javax.swing.*;

public class QuestionCreator {

    public static JLabel question;
    
    public static JButton ans1;
    public static JButton ans2;
    public static JButton ans3;
    public static JButton ans4;
    
    public static JPanel questionCreator(String q, String a1, String a2, String a3, String a4){
        question= new JLabel(q);
        ans1=new JButton(a1);
        ans2=new JButton(a2);
        ans3=new JButton(a3);
        ans4=new JButton(a4);
        JPanel ret = new JPanel();
        ret.setLayout(new BoxLayout(ret, BoxLayout.PAGE_AXIS));
        ret.add(question);
        ret.add(ans1);
        ret.add(ans2);
        ret.add(ans3);
        ret.add(ans4);
        return ret;
    }

}
