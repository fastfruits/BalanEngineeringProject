package main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ActiveWindow implements ActionListener{
    public static JFrame window;

    public JPanel currentFrame;
    public static JPanel btnPanel;
    public static String[] scripts = new String[] {"This is a PlaceHolder SCRIPT", "This is the second PlaceHolder SCRIPT"};
    public static String[] questions = new String[] {"This is a PlaceHolder QUESTION, the  answer is 4", "1","2","3","4","4","This is the second PlaceHolder QUESTION, the answer is 1","1","2","3","4","1"};
    LessonManager lesson = new LessonManager(scripts,questions);
    public JLabel title = new JLabel("Choose a lesson");
    public static JLabel answerQuestion = new JLabel("Answer the question below");

    public static JButton lesson1 = new JButton("<html>   Lesson 1\n(Variables)</html>");
    public static JButton lesson2 = new JButton("<html>   Lesson 2\n(Conditionals)</html>");
    public static JButton lesson3 = new JButton("<html>   Lesson 3\n(Loops)</html>");

    public static GridBagConstraints titlePos=new GridBagConstraints();
    public static GridBagConstraints buttonsPos=new GridBagConstraints();
    

    public static Dimension minSize;
    //Constructs the main window currently used throughout the program
    public ActiveWindow(Dimension d){
        minSize = d;
        window = new JFrame();
        btnPanel = new JPanel();

        window.setLayout(new GridBagLayout());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true);
        window.setMinimumSize(d);
        window.setTitle("Programmer Professional");
        window.setBackground(Color.ORANGE);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        titlePos.gridx=1;
        titlePos.gridy=0;
        titlePos.anchor=GridBagConstraints.PAGE_START;
        titlePos.insets=new Insets(0, 50, 50, 50);
        buttonsPos.gridx=1;
        buttonsPos.gridy=1;
        buttonsPos.anchor=GridBagConstraints.CENTER;
        lesson1.setPreferredSize(new Dimension(150, 100));
        lesson2.setPreferredSize(new Dimension(150, 100));
        lesson3.setPreferredSize(new Dimension(150, 100));

        btnPanel.setLayout(new FlowLayout());
        btnPanel.setSize(new Dimension(600,400));
        btnPanel.setVisible(true);

        window.add(title,titlePos);
        btnPanel.add(lesson1);
        btnPanel.add(lesson2);
        btnPanel.add(lesson3);

        window.add(btnPanel, buttonsPos);
        window.pack();

        lesson1.addActionListener(this);
        lesson2.addActionListener(this);
        lesson3.addActionListener(this);

    }

    public static void setMinSize(Dimension minSize) {
        ActiveWindow.minSize = minSize;
    }


    public static Dimension getSize() {
        return minSize;
    }
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().contains("Lesson")){
            window.setTitle(e.getActionCommand().substring(6, 17));
            window.remove(btnPanel);
            window.remove(title);
            currentFrame = lesson.getNextScript();
            window.pack();
        }
        if(lesson.getCurrentScriptPos()<scripts.length){
            window.remove(currentFrame);
            currentFrame = lesson.getNextScript();
            System.out.println(currentFrame.toString());
            window.add(currentFrame);
            window.pack();
            lesson.getScriptButton().addActionListener(this);
            lesson.getScriptButton().addActionListener(lesson);
        }
        else if(lesson.getCurrentQuestionPos()<questions.length/6){
            window.remove(currentFrame);
            currentFrame= lesson.getNextQuestion();
            window.add(currentFrame);
            window.pack();
            lesson.getQuestionButton(0, lesson.getCurrentQuestionPos()).addActionListener(this);
            lesson.getQuestionButton(1, lesson.getCurrentQuestionPos()).addActionListener(this);
            lesson.getQuestionButton(2, lesson.getCurrentQuestionPos()).addActionListener(this);
            lesson.getQuestionButton(3, lesson.getCurrentQuestionPos()).addActionListener(this);
            lesson.getQuestionButton(0, lesson.getCurrentQuestionPos()).addActionListener(lesson);
            lesson.getQuestionButton(1, lesson.getCurrentQuestionPos()).addActionListener(lesson);
            lesson.getQuestionButton(2, lesson.getCurrentQuestionPos()).addActionListener(lesson);
            lesson.getQuestionButton(3, lesson.getCurrentQuestionPos()).addActionListener(lesson);
        }
        else{
            lesson.reset();
            for(int i = 0; i<scripts.length;i++){
                lesson.getScriptButton(i).removeActionListener(this);
                lesson.getScriptButton(i).removeActionListener(lesson);
            }
            for(int i =0;i<questions.length/6;i++){
                lesson.getQuestionButton(0, i).removeActionListener(this);
                lesson.getQuestionButton(1, i).removeActionListener(this);
                lesson.getQuestionButton(2, i).removeActionListener(this);
                lesson.getQuestionButton(3, i).removeActionListener(this);
                lesson.getQuestionButton(0, i).removeActionListener(lesson);
                lesson.getQuestionButton(1, i).removeActionListener(lesson);
                lesson.getQuestionButton(2, i).removeActionListener(lesson);
                lesson.getQuestionButton(3, i).removeActionListener(lesson);
            }
            window.remove(currentFrame);
            window.add(btnPanel,buttonsPos);
            window.add(title, titlePos);
            window.setTitle("Programmer Professional");
            window.validate();
            window.pack();
        }


    }
    
}