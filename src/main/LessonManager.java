package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class LessonManager implements ActionListener{
    public static QuestionCreator q;
    public static ScriptCreator s;
    public static int currentScriptPos=0;
    public static int currentQuestionPos=0;

    public LessonManager(String[] arrS, String[] arrQ){
        q = new QuestionCreator(arrQ);
        s = new ScriptCreator(arrS);
    }
    public JButton getScriptButton(){
        return s.getButton(currentScriptPos);
    }
    public JButton getQuestionButton(int i, int qNum){
        return q.getAns(i, qNum);
    }
    public JButton getScriptButton(int i){
        return s.getButton(i);
    }
    public static JPanel getNextScript(){
        return s.getScript(currentScriptPos);

    }
    public static JPanel getNextQuestion(){
        return q.getQuestion(currentQuestionPos);
    }
    public int getCurrentScriptPos(){
        return currentScriptPos;
    }
    public int getCurrentQuestionPos(){
        return currentQuestionPos;
    }
    public void actionPerformed(ActionEvent e){
        if(currentScriptPos<s.getLength()){
            currentScriptPos++;
            System.out.println(s.getLength());
            System.out.println(currentScriptPos);
            System.out.println(q.getLength());
        }
        else if(currentQuestionPos<q.getLength()){
            currentQuestionPos++;
            System.out.println(q.getLength());
        }
        else{
            currentQuestionPos=0;
            currentScriptPos=0;
            System.out.println("reset!");
        }

    }
    public void reset(){
        currentQuestionPos=0;
        currentScriptPos=0;
        System.out.println("reset!");
    }
}