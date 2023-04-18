package ui_package;

import question_package.desc.DescQuestionManager;
import question_package.mcq.McqQuestionManager;
import question_package.mcq.McqType;

import javax.swing.*;
import javax.swing.plaf.basic.BasicRadioButtonMenuItemUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static ui_package.SubmitListener.currentQuestionNumber;
import static ui_package.SubmitListener.getScore;

public class Cards extends JFrame implements ActionListener {
    private JPanel panel1;
    private JPanel descPanel;
    private JTextField answerField;
    private JProgressBar progressBar1;
    private JLabel question;
    private JLabel scoreLabel;
    private JButton submitButton;
    private JPanel mcqPanel;
    private JRadioButton dRadioButton;
    private JRadioButton cRadioButton;
    private JRadioButton bRadioButton;
    private JRadioButton aRadioButton;
    private JLabel questionMcq;
    private JButton submitMcq;
    JLabel mcqScore;
    private JLabel selectedOption;
    private JPanel startPanel;
    private JLabel StartHeading;
    private JTextField NameSubmission;
    private JLabel nameLabel;
    private JButton nameSubmit;
    private JPanel endPanel;
    private JPanel intPanel;
    JProgressBar mcqProgress;
    private JLabel finalscore;
    private static int choice = -1;


    public Cards() {
        progressBar1.setMinimum(0);
        progressBar1.setMaximum(new DescQuestionManager().getNumberOfQuestions());
        progressBar1.setValue(1);

        mcqProgress.setMinimum(0);
        mcqProgress.setMaximum(new McqQuestionManager().getNumQuestions());
        mcqProgress.setValue(1);

        panel1.setLayout(new CardLayout());

        panel1.add(startPanel, "card1");
        panel1.add(descPanel, "card2");
        panel1.add(mcqPanel, "card3");
        panel1.add(endPanel,"card4");

        ButtonGroup mcqButtonGroup = new ButtonGroup();
        mcqButtonGroup.add(aRadioButton);
        mcqButtonGroup.add(bRadioButton);
        mcqButtonGroup.add(cRadioButton);
        mcqButtonGroup.add(dRadioButton);

        CardLayout cardLayout = (CardLayout) panel1.getLayout();
        cardLayout.show(panel1, "card1");


        this.add(panel1);
        setSize(1200, 600);

        aRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle A button click
                int choice = getChoice();
            }
        });

        bRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle B button click
                int choice = getChoice();
            }
        });

        cRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle C button click
                int choice = getChoice();
            }
        });

        dRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle D button click
                int choice = getChoice();
            }
        });

        nameSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = NameSubmission.getText();
                if (name.length() > 0) {
                    CardLayout cardLayout = (CardLayout) panel1.getLayout();
                    JOptionPane.showMessageDialog(panel1, "Welcome " + name + "!");
                    cardLayout.show(panel1, "card2");
                } else {
                    JOptionPane.showMessageDialog(panel1, "Please enter your name");
                }
            }
        });

        submitMcq.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get selected choice
                int selectedChoice = getChoice();
                McqQuestionManager mcq_questions = new McqQuestionManager();

                // Get current question
                McqType currentQuestion = mcq_questions.getQuestion(currentQuestionNumber[0]);

                // Compare selected choice with correct answer
                int score = getScore();
                if (selectedChoice == currentQuestion.getCorrectAnswerIndex()) {
                    SubmitListener.setScore(score + 1);
                }
                mcqScore.setText("Score: " + getScore());

                // Update progress bar
                mcqProgress.setValue(currentQuestionNumber[0] + 2);

                // Move to next question if available
                if (currentQuestionNumber[0] < McqQuestionManager.getNumberOfQuestions()-1){
                    currentQuestionNumber[0]++;
                    setQuestionMcq(mcq_questions.getQuestion(currentQuestionNumber[0]).getQuestion(), currentQuestionNumber[0]);
                    getAButton().setText(mcq_questions.getQuestion(currentQuestionNumber[0]).getAnswerOptions()[0]);
                    getBButton().setText(mcq_questions.getQuestion(currentQuestionNumber[0]).getAnswerOptions()[1]);
                    getCButton().setText(mcq_questions.getQuestion(currentQuestionNumber[0]).getAnswerOptions()[2]);
                    getDButton().setText(mcq_questions.getQuestion(currentQuestionNumber[0]).getAnswerOptions()[3]);
                    clearSelection();
                    getChoice();

                } else {
                    // All questions answered, disable radio buttons and submit button
                    nextCard();
                    finalscore.setText(String.valueOf(getScore()));
                    submitMcq.setEnabled(false);
                    disableRadioButtons();

                }

            }
        });
    }

    private void disableRadioButtons() {
        aRadioButton.setEnabled(false);
        bRadioButton.setEnabled(false);
        cRadioButton.setEnabled(false);
        dRadioButton.setEnabled(false);
    }

    private void clearSelection() {
        aRadioButton.setSelected(false);
        bRadioButton.setSelected(false);
        cRadioButton.setSelected(false);
        dRadioButton.setSelected(false);
    }

    int getChoice() {
        if (aRadioButton.isSelected()) {
            choice = 0;
            selectedOption.setText("Selected Option: " + aRadioButton.getText());
            //System.out.println("Choice: " + choice);
        } else if (bRadioButton.isSelected()) {
            choice = 1;
            selectedOption.setText("Selected Option: " + bRadioButton.getText());
            //System.out.println("Choice: " + choice);
        } else if (cRadioButton.isSelected()) {
            choice = 2;
            selectedOption.setText("Selected Option: " + cRadioButton.getText());
            //System.out.println("Choice: " + choice);
        } else if (dRadioButton.isSelected()) {
            choice = 3;
            selectedOption.setText("Selected Option: " + dRadioButton.getText());
            //System.out.println("Choice: " + choice);
        }
        return choice;
    }


    public static void main(String[] args) {

    }

    public void nextCard() {
        CardLayout cardLayout = (CardLayout) panel1.getLayout();
        cardLayout.next(panel1);
    }
    public void setQuestion(String question, int qno) {
        this.question.setText("Question " + (qno + 1) + ": " + question);
    }

    public JButton getSubmit() {
        return submitButton;
    }

    public Object getProgressBar() {
        return progressBar1;
    }
    public void setQuestionMcq(String s, int qno)
    {
        questionMcq.setText("Question " + (qno + 1) + ": " + s);
    }


    public String getUserAnswer() {
        return answerField.getText();
    }

    public void updateScore(int score) {
        scoreLabel.setText("Score: " + score);
    }

    public void clearAnswer() {
        answerField.setText("");
    }

    public JRadioButton getAButton() {
        return aRadioButton;
    }

    public JRadioButton getBButton() {
        return bRadioButton;
    }
    public JRadioButton getCButton() {
        return cRadioButton;
    }

    public JRadioButton getDButton() {
        return dRadioButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

