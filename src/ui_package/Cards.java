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
    private static int choice = -1;


    public Cards() {
        progressBar1.setMinimum(0);
        progressBar1.setMaximum(9);
        progressBar1.setValue(0);

        panel1.setLayout(new CardLayout());

        panel1.add(startPanel, "card1");
        panel1.add(descPanel, "card2");
        panel1.add(mcqPanel, "card3");

        CardLayout cardLayout = (CardLayout) panel1.getLayout();
        cardLayout.show(panel1, "card1");

//        question.setFont(new Font("Helvetica", Font.PLAIN, 12));
//        scoreLabel.setFont(new Font("Helvetica", Font.PLAIN, 12));
//        questionMcq.setFont(new Font("Helvetica", Font.PLAIN, 12));
//        mcqScore.setFont(new Font("Helvetica", Font.PLAIN, 12));
//        StartHeading.setFont(new Font("Helvetica", Font.BOLD, 18));
//        nameLabel.setFont(new Font("Helvetica", Font.PLAIN, 12));
//        selectedOption.setFont(new Font("Helvetica", Font.PLAIN, 12));


        this.add(panel1);

        aRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle A button click
                int choice = getChoice();
                System.out.println(choice);
            }
        });

        bRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle B button click
                int choice = getChoice();
                System.out.println(choice);
            }
        });

        cRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle C button click
                int choice = getChoice();
                System.out.println(choice);
            }
        });

        dRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle D button click
                int choice = getChoice();
                System.out.println(choice);
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
                if (selectedChoice == currentQuestion.getCorrectAnswerIndex()) {
                    System.out.println("Correct");
                    int score = getScore();
                    SubmitListener.setScore(score + 1);
                    mcqScore.setText("Score: " + getScore());
                } else {
                    System.out.println("Incorrect");
                    System.out.println("Question: " + currentQuestion.getQuestion());
                    System.out.println("Correct answer: " + currentQuestion.getAnswerOptions()[currentQuestion.getCorrectAnswerIndex()]);
                    int score = getScore();
                    mcqScore.setText("Score: " + getScore());
                }

                // Update progress bar
                progressBar1.setValue(progressBar1.getValue() + 1);

                System.out.println(currentQuestionNumber[0] < (new DescQuestionManager().getNumberOfQuestions()) + McqQuestionManager.getNumberOfQuestions());

                // Move to next question if available
                if (currentQuestionNumber[0] < (new DescQuestionManager().getNumberOfQuestions()) + McqQuestionManager.getNumberOfQuestions()) {
                    System.out.println("Next question");
                    currentQuestionNumber[0]++;
                    setQuestionMcq(mcq_questions.getQuestion(currentQuestionNumber[0]).getQuestion(), currentQuestionNumber[0]);
                    getAButton().setText(mcq_questions.getQuestion(currentQuestionNumber[0]).getAnswerOptions()[0]);
                    getBButton().setText(mcq_questions.getQuestion(currentQuestionNumber[0]).getAnswerOptions()[1]);
                    getCButton().setText(mcq_questions.getQuestion(currentQuestionNumber[0]).getAnswerOptions()[2]);
                    getDButton().setText(mcq_questions.getQuestion(currentQuestionNumber[0]).getAnswerOptions()[3]);
                    clearSelection();

                } else {
                    // All questions answered, disable radio buttons and submit button
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
        Cards cards = new Cards();
        cards.setVisible(true);

        // Show option dialog for card selection
        String[] options = {"Card 1", "Card 3"};
        int oChoice = JOptionPane.showOptionDialog(cards, "Choose a card to show", "Card Selection",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        // Update CardLayout based on user's choice
        CardLayout cardLayout = (CardLayout) cards.panel1.getLayout();
        if (oChoice == 0) {
            cardLayout.show(cards.panel1, "card1");
        } else if (oChoice == 1) {
            cardLayout.show(cards.panel1, "card3");
        }

        McqQuestionManager mcq_questions = new McqQuestionManager();
        for(int i=0;i<mcq_questions.getNumQuestions();i++)
        {
            System.out.println("Question: " + mcq_questions.getQuestion(i).getQuestion());
            System.out.println("Option A:" + mcq_questions.getQuestion(i).getAnswerA());
            System.out.println("Option B:" + mcq_questions.getQuestion(i).getAnswerB());
            System.out.println("Option C:" + mcq_questions.getQuestion(i).getAnswerC());
            System.out.println("Option D:" + mcq_questions.getQuestion(i).getAnswerD());
            cards.selectedOption.setText("Selected Option: None");

            if (cards.getChoice() == mcq_questions.getQuestion(i).getCorrectAnswerIndex()) {
                System.out.println("Correct");
            } else {
                System.out.println("Incorrect");
                System.out.println("Correct Answer: " + mcq_questions.getQuestion(i).getCorrectAnswerIndex());
            }
        }


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

