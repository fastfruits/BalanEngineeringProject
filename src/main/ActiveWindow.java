package main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ActiveWindow implements ActionListener{
    public static JFrame window;

    public JLabel results;
    public JButton next=new JButton("Go Back");
    public boolean canGoBack=true;
    public static JPanel btnPanel;
    public static String[] scriptsOne = new String[] {"This is a PlaceHolder SCRIPT", "This is the second PlaceHolder SCRIPT"};
    public static String[] questionsOne = new String[] {"This is a PlaceHolder QUESTION, the  answer is 4", "1","2","3","4","4","This is the second PlaceHolder QUESTION, the answer is 1","1","2","3","4","1", "This is the third PlaceHolder QUESTION, the answer is 3","1","2","3","4","3"};
    public static String[] scriptsTwo = new String[] {"This is a PlaceHolder SCRIPT", "This is the second PlaceHolder SCRIPT", "This is the third placeHolder SCRIPT"};
    public static String[] questionsTwo = new String[] {"This is a PlaceHolder QUESTION, the  answer is 4", "1","2","3","4","4","This is the second PlaceHolder QUESTION, the answer is 1","1","2","3","4","1"};
    public static String[] scriptsThree = new String[] {"This is a PlaceHolder SCRIPT"};
    public static String[] questionsThree = new String[] {"This is a PlaceHolder QUESTION, the  answer is 4", "1","2","3","4","4"};
    public static String[] scriptsFour = new String[]{"You are about to begin the quiz. Press 'next' to continue"};
    public static String[] questionsFour = new String[] {"This is a PlaceHolder QUESTION, the  answer is 4", "1","2","3","4","4","This is the second PlaceHolder QUESTION, the answer is 1","1","2","3","4","1"};
    LessonManager lessonOne = new LessonManager(scriptsOne,questionsOne);
    LessonManager lessonTwo = new LessonManager(scriptsTwo,questionsTwo);
    LessonManager lessonThree = new LessonManager(scriptsThree,questionsThree);
    LessonManager quiz =new LessonManager(scriptsFour, questionsFour);
    LessonManager lesson;
    public JLabel title = new JLabel("Choose a lesson");
    public static JLabel answerQuestion = new JLabel("Answer the question below");

    public static JButton lesson1 = new JButton("<html>   Lesson 1\n(Variables)</html>");
    public static JButton lesson2 = new JButton("<html>   Lesson 2\n(Conditionals)</html>");
    public static JButton lesson3 = new JButton("<html>   Lesson 3\n(Loops)</html>");
    public static JButton lesson4 = new JButton("<html> Quiz</html>");

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
        window.setExtendedState(JFrame.MAXIMIZED_BOTH); 
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
        lesson4.setPreferredSize(new Dimension(150,100));

        btnPanel.setLayout(new FlowLayout());
        btnPanel.setSize(new Dimension(600,400));
        btnPanel.setVisible(true);

        window.add(title,titlePos);
        btnPanel.add(lesson1);
        btnPanel.add(lesson2);
        btnPanel.add(lesson3);
        btnPanel.add(lesson4);

        window.add(btnPanel, buttonsPos);
        window.pack();

        lesson1.addActionListener(this);
        lesson2.addActionListener(this);
        lesson3.addActionListener(this);
        lesson4.addActionListener(this);
    }

    public static void setMinSize(Dimension minSize) {
        ActiveWindow.minSize = minSize;
    }


    public static Dimension getSize() {
        return minSize;
    }
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().contains("Lesson")||e.getActionCommand().contains("Quiz")){
            if(e.getActionCommand().contains("1")){
                lesson = lessonOne;
            }
            else if(e.getActionCommand().contains("2")){
                lesson=lessonTwo;
            }
            else if(e.getActionCommand().contains("3")){
                lesson=lessonThree;
            }
            else{
                lesson = quiz;
                canGoBack=false;    
            }
            window.setTitle(e.getActionCommand().substring(6, 17)); 
            btnPanel.setVisible(false);
            title.setVisible(false);
            window.validate();
            }
        if(lesson.getCurrentScriptPos()<lesson.getScriptLength()){
            if(lesson.getCurrentScriptPos()>0){
                lesson.getLastScript().setVisible(false);
            }
            lesson.getNextScript().setVisible(true);
            window.add(lesson.getNextScript());
            window.validate();
            lesson.getScriptButton().addActionListener(this);
            lesson.getScriptButton().addActionListener(lesson);
        }
        else if(lesson.getCurrentQuestionPos()<lesson.getQuestionLength()){
            if(lesson.getCurrentQuestionPos()>0){
                lesson.getLastQuestion().setVisible(false);
            }
            else{
                lesson.getLastScript().setVisible(false);
            }
            lesson.getNextQuestion().setVisible(true);
            window.add(lesson.getNextQuestion());
            window.validate();
            lesson.getQuestionButton(0, lesson.getCurrentQuestionPos()).addActionListener(this);
            lesson.getQuestionButton(1, lesson.getCurrentQuestionPos()).addActionListener(this);
            lesson.getQuestionButton(2, lesson.getCurrentQuestionPos()).addActionListener(this);
            lesson.getQuestionButton(3, lesson.getCurrentQuestionPos()).addActionListener(this);
            lesson.getQuestionButton(0, lesson.getCurrentQuestionPos()).addActionListener(lesson);
            lesson.getQuestionButton(1, lesson.getCurrentQuestionPos()).addActionListener(lesson);
            lesson.getQuestionButton(2, lesson.getCurrentQuestionPos()).addActionListener(lesson);
            lesson.getQuestionButton(3, lesson.getCurrentQuestionPos()).addActionListener(lesson);
        }
        else if(lesson.getCurrentQuestionPos()==lesson.getQuestionLength()){
            lesson.getLastQuestion().setVisible(false);
            if(canGoBack){
                next.setVisible(true);
            }
            results= new JLabel("You got "+lesson.getCorrect()+"/"+lesson.getQuestionLength()+" correct!");
            window.add(results);
            window.add(next);
            next.addActionListener(this);
            next.addActionListener(lesson);
        }
        else{
            results.setVisible(false);
            next.setVisible(false);
            next.removeActionListener(this);
            next.removeActionListener(lesson);
            lesson.reset();
            for(int i = 0; i<lesson.getScriptLength();i++){
                lesson.getScriptButton(i).removeActionListener(this);
                lesson.getScriptButton(i).removeActionListener(lesson);
            }
            for(int i =0;i<lesson.getQuestionLength();i++){
                lesson.getQuestionButton(0, i).removeActionListener(this);
                lesson.getQuestionButton(1, i).removeActionListener(this);
                lesson.getQuestionButton(2, i).removeActionListener(this);
                lesson.getQuestionButton(3, i).removeActionListener(this);
                lesson.getQuestionButton(0, i).removeActionListener(lesson);
                lesson.getQuestionButton(1, i).removeActionListener(lesson);
                lesson.getQuestionButton(2, i).removeActionListener(lesson);
                lesson.getQuestionButton(3, i).removeActionListener(lesson);
            }
            title.setVisible(true);
            btnPanel.setVisible(true);
            window.setTitle("Programmer Professional");
            window.validate();
        }


    }
    
}