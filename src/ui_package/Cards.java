package ui_package;

import question_package.mcq.McqQuestionManager;
import question_package.mcq.McqType;

import javax.swing.*;
import javax.swing.plaf.basic.BasicRadioButtonMenuItemUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cards extends JFrame implements ActionListener {
    private JPanel panel1;
    private JPanel panelName;
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
    private JLabel questionmcq;
    private JButton submitMcq;
    private static int choice = -1;

    public Cards() {
        progressBar1.setMinimum(0);
        progressBar1.setMaximum(9);
        progressBar1.setValue(0);

        panel1.setLayout(new CardLayout());

        panel1.add(panelName, "card1");
        panel1.add(mcqPanel, "card2");

        CardLayout cardLayout = (CardLayout) panel1.getLayout();
        cardLayout.show(panel1, "card1");

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

        submitMcq.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get selected choice
                int selectedChoice = getChoice();
                McqQuestionManager mcq_questions = new McqQuestionManager();

                // Get current question
                McqType currentQuestion = mcq_questions.getQuestion(progressBar1.getValue());

                // Compare selected choice with correct answer
                if (selectedChoice == currentQuestion.getCorrectAnswerIndex()) {
                    System.out.println("Correct");
                } else {
                    System.out.println("Incorrect");
                }

                // Update progress bar
                progressBar1.setValue(progressBar1.getValue() + 1);

                // Move to next question if available
                if (progressBar1.getValue() < progressBar1.getMaximum()) {
                    setQuestionmcq(mcq_questions.getQuestion(progressBar1.getValue()).getQuestion());
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
            //System.out.println("Choice: " + choice);
        } else if (bRadioButton.isSelected()) {
            choice = 1;
            //System.out.println("Choice: " + choice);
        } else if (cRadioButton.isSelected()) {
            choice = 2;
            //System.out.println("Choice: " + choice);
        } else if (dRadioButton.isSelected()) {
            choice = 3;
            //System.out.println("Choice: " + choice);
        }
        return choice;
    }


    public static void main(String[] args) {
        Cards cards = new Cards();
        cards.setVisible(true);

        // Show option dialog for card selection
        String[] options = {"Card 1", "Card 2"};
        int oChoice = JOptionPane.showOptionDialog(cards, "Choose a card to show", "Card Selection",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        // Update CardLayout based on user's choice
        CardLayout cardLayout = (CardLayout) cards.panel1.getLayout();
        if (oChoice == 0) {
            cardLayout.show(cards.panel1, "card1");
        } else if (oChoice == 1) {
            cardLayout.show(cards.panel1, "card2");
        }

        McqQuestionManager mcq_questions = new McqQuestionManager();
        for(int i=0;i<mcq_questions.getNumQuestions();i++)
        {
            cards.setQuestionmcq(mcq_questions.getQuestion(i).getQuestion());
            cards.getAButton().setText(mcq_questions.getQuestion(i).getAnswerA());
            cards.getBButton().setText(mcq_questions.getQuestion(i).getAnswerB());
            cards.getCButton().setText(mcq_questions.getQuestion(i).getAnswerC());
            cards.getDButton().setText(mcq_questions.getQuestion(i).getAnswerD());

            if (cards.getChoice() == mcq_questions.getQuestion(i).getCorrectAnswerIndex()) {
                System.out.println("Correct");
            } else {
                System.out.println("Incorrect");
            }
        }


    }

    public void nextCard() {
        CardLayout cardLayout = (CardLayout) panel1.getLayout();
        cardLayout.next(panel1);
    }
    public void setQuestion(String question) {
        this.question.setText(question);
    }

    public JButton getSubmit() {
        return submitButton;
    }

    public Object getProgressBar() {
        return progressBar1;
    }
    public void setQuestionmcq(String s)
    {
        questionmcq.setText(s);
    }

    public void getQuestionmcq(String s)
    {
        questionmcq.getText();
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

