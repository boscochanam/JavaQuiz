package ui_package;

import question_package.desc.DescQuestionManager;
import question_package.integer_type.IntQuestionManager;
import question_package.integer_type.IntegerType;
import question_package.mcq.McqQuestionManager;
import question_package.mcq.McqType;

import javax.swing.*;
import javax.swing.plaf.basic.BasicRadioButtonMenuItemUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static ui_package.SubmitListener.*;

public class Cards extends JFrame{
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
    JProgressBar mcqProgress;
    private JLabel finalscore;
    private JPanel intPanel;
    private JButton intSubmit;
    private JTextField intAnswerField;
    private JLabel intQuestion;
    private JLabel intScore;
    private JProgressBar intProgress;
    private JButton startAgainButton;
    private JLabel leaderboard1;
    private JLabel leaderboard2;
    private JLabel leaderboard3;
    private JLabel leaderboard1Score;
    private JLabel leaderboard2Score;
    private JLabel leaderboard3Score;
    private static int choice = -1;


    public Cards() {
        // retrieve top scores
        Leaderboard.ScoreEntry[] topScores = Leaderboard.getTopScores();

        leaderboard1.setText("1. " + topScores[0].name);
        leaderboard1Score.setText(" " + topScores[0].score);
        leaderboard2.setText("2. " + topScores[1].name);
        leaderboard2Score.setText(" " + topScores[1].score);
        leaderboard3.setText("3. " + topScores[2].name);
        leaderboard3Score.setText(" " + topScores[2].score);

        // Initialising the Progress Bars to 0
        progressBar1.setMinimum(0);
        progressBar1.setMaximum(new DescQuestionManager().getNumberOfQuestions());
        progressBar1.setValue(1);

        mcqProgress.setMinimum(0);
        mcqProgress.setMaximum(new McqQuestionManager().getNumQuestions());
        mcqProgress.setValue(1);

        intProgress.setMinimum(0);
        intProgress.setMaximum(new IntQuestionManager().getNumQuestions());
        intProgress.setValue(1);

        // Setting Up the Cards and Panels
        panel1.setLayout(new CardLayout());

        panel1.add(startPanel, "start");
        panel1.add(descPanel, "desc");
        panel1.add(mcqPanel, "mcq");
        panel1.add(intPanel, "int");
        panel1.add(endPanel,"end");

        ButtonGroup mcqButtonGroup = new ButtonGroup();
        mcqButtonGroup.add(aRadioButton);
        mcqButtonGroup.add(bRadioButton);
        mcqButtonGroup.add(cRadioButton);
        mcqButtonGroup.add(dRadioButton);

        CardLayout cardLayout = (CardLayout) panel1.getLayout();
        cardLayout.show(panel1, "start");

        this.add(panel1);
        setSize(1200, 600);


        // Adding Action Listeners to the Buttons

        // MCQ Buttons
        aRadioButton.addActionListener(e -> {
            // Handle A button click
            choice = getChoice();
        });

        bRadioButton.addActionListener(e -> {
            // Handle B button click
            choice = getChoice();
        });

        cRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle C button click
                choice = getChoice();
            }
        });

        dRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle D button click
                choice = getChoice();
            }
        });

        nameSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = NameSubmission.getText();
                if (name.length() > 0) {
                    CardLayout cardLayout = (CardLayout) panel1.getLayout();
                    JOptionPane.showMessageDialog(panel1, "Welcome " + name + "!");
                    cardLayout.show(panel1, "desc");
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
                McqType currentQuestion = mcq_questions.getQuestion(currentQuestionNumber);

                // Compare selected choice with correct answer
                int score = getScore();
                if (selectedChoice == currentQuestion.getCorrectAnswerIndex()) {
                    SubmitListener.setScore(score + 1);
                }
                mcqScore.setText("Score: " + getScore());

                // Update progress bar
                mcqProgress.setValue(currentQuestionNumber + 2);

                // Move to next question if available
                if (currentQuestionNumber < McqQuestionManager.getNumberOfQuestions()-1){
                    currentQuestionNumber++;
                    setQuestionMcq(mcq_questions.getQuestion(currentQuestionNumber).getQuestion(), currentQuestionNumber);
                    getAButton().setText(mcq_questions.getQuestion(currentQuestionNumber).getAnswerOptions()[0]);
                    getBButton().setText(mcq_questions.getQuestion(currentQuestionNumber).getAnswerOptions()[1]);
                    getCButton().setText(mcq_questions.getQuestion(currentQuestionNumber).getAnswerOptions()[2]);
                    getDButton().setText(mcq_questions.getQuestion(currentQuestionNumber).getAnswerOptions()[3]);
                    clearSelection();
                    getChoice();

                } else {
                    // All questions answered, disable radio buttons and submit button
                    // Also move onto Integer Panel

                    nextCard();
                    intQuestion.setText(new IntQuestionManager().getQuestion(0).getQuestion());
                    intScore.setText("Score: " + getScore());
                    currentQuestionNumber = 0;


                    finalscore.setText(String.valueOf(getScore()));
                    submitMcq.setEnabled(false);
                    disableRadioButtons();

                }

            }
        });

        intSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Get selected choice
                    int userAnswerInt = Integer.parseInt(intAnswerField.getText());
                    IntQuestionManager int_questions = new IntQuestionManager();

                    // Get current question
                    IntegerType currentQuestion = int_questions.getQuestion(currentQuestionNumber);

                    // Compare selected choice with correct answer
                    int score = getScore();
                    if (Integer.toString(userAnswerInt).equals(currentQuestion.getCorrectAns())) {
                        SubmitListener.setScore(score + 1);
                    }
                    intScore.setText("Score: " + getScore());

                    // Update progress bar
                    intProgress.setValue(currentQuestionNumber + 2);

                    // Move to next question if available
                    if (currentQuestionNumber < IntQuestionManager.getNumberOfQuestions()-1){
                        currentQuestionNumber++;
                        System.out.println("New Question: " + currentQuestionNumber );
                        intQuestion.setText(int_questions.getQuestion(currentQuestionNumber).getQuestion());
                        intAnswerField.setText("");
                    } else {
                        nextCard();
                        finalscore.setText(String.valueOf(getScore()));
                        intSubmit.setEnabled(false);
                        intAnswerField.setEnabled(false);
                    }
                } catch (NumberFormatException ex) {
                    // Show a dialog box to inform the user
                    JOptionPane.showMessageDialog(null, "Please enter an integer as the answer.", "Answer Format", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        startAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) panel1.getLayout();
                cardLayout.show(panel1, "start");
                SubmitListener.setScore(0);
                mcqProgress.setValue(0);
                intProgress.setValue(0);
                submitMcq.setEnabled(true);
                enableRadioButtons();
                clearSelection();
                intSubmit.setEnabled(true);
                intAnswerField.setEnabled(true);
                currentQuestionNumber = 0;

                DescQuestionManager desc_questions = new DescQuestionManager();
                setQuestion(desc_questions.getQuestion(currentQuestionNumber).getQuestion(),currentQuestionNumber);
                scoreLabel.setText("Score: 0");
                answerField.setText("");
                intAnswerField.setText("");
                setScore(0);

                progressBar1.setMinimum(0);
                progressBar1.setMaximum(new DescQuestionManager().getNumberOfQuestions());
                progressBar1.setValue(1);

                mcqProgress.setMinimum(0);
                mcqProgress.setMaximum(new McqQuestionManager().getNumQuestions());
                mcqProgress.setValue(1);

                intProgress.setMinimum(0);
                intProgress.setMaximum(new IntQuestionManager().getNumQuestions());
                intProgress.setValue(1);
            }
        });
    }

    private void enableRadioButtons() {
        aRadioButton.setEnabled(true);
        bRadioButton.setEnabled(true);
        cRadioButton.setEnabled(true);
        dRadioButton.setEnabled(true);
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

}

