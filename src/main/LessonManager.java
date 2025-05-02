package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class LessonManager implements ActionListener{
    public QuestionCreator q;
    public ScriptCreator s;
    public int currentScriptPos=0;
    public int currentQuestionPos=0;

    public LessonManager(String[] arrS, String[] arrQ){
        q = new QuestionCreator(arrQ);
        s = new ScriptCreator(arrS);
    }
    public int getScriptLength(){
        System.out.println(s.getLength());
        return s.getLength();
    }
    public int getQuestionLength(){
        return q.getLength();
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
    public JPanel getNextScript(){
        return s.getScript(currentScriptPos);

    }
    public JPanel getLastScript(){
        System.out.println("Removed!");
        return s.getScript(currentScriptPos-1);

    }
    public JPanel getNextQuestion(){
        return q.getQuestion(currentQuestionPos);
    }
    public JPanel getLastQuestion(){
        System.out.println("Removed!");
        return q.getQuestion(currentQuestionPos-1);
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
        }
        else if(currentQuestionPos<q.getLength()){
            currentQuestionPos++;
        }

    }
    public JPanel getScript(int i){
        return s.getScript(i);
    }
    public JPanel getQuestion(int i){
        return q.getQuestion(i);
    }
    public void reset(){
        currentQuestionPos=0;
        currentScriptPos=0;
        System.out.println("reset!");
    }
}