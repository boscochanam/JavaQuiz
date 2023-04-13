package ui_package;

import javax.swing.*;
import java.awt.*;

public class Cards extends JFrame{
    private JPanel panel1;
    private JPanel panelName;
    private JTextField answerField;
    private JProgressBar progressBar1;
    private JLabel question;
    private JLabel scoreLabel;
    private JButton submitButton;
    private JPanel mcqPanel;
    private JButton dButton;
    private JButton cButton;
    private JButton bButton;
    private JButton aButton;

    public Cards() {
        progressBar1.setMinimum(0);
        progressBar1.setMaximum(5);
        progressBar1.setValue(0);

        panel1.setLayout(new CardLayout());

        panel1.add(panelName, "card1");
        panel1.add(mcqPanel, "card2");

        CardLayout cardLayout = (CardLayout) panel1.getLayout();
        cardLayout.show(panel1, "card1");

        this.add(panel1);
    }

    public static void main(String[] args) {
        Cards cards = new Cards();
        cards.setVisible(true);

        // Show option dialog for card selection
        String[] options = {"Card 1", "Card 2"};
        int choice = JOptionPane.showOptionDialog(cards, "Choose a card to show", "Card Selection",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        // Update CardLayout based on user's choice
        CardLayout cardLayout = (CardLayout) cards.panel1.getLayout();
        if (choice == 0) {
            cardLayout.show(cards.panel1, "card1");
        } else if (choice == 1) {
            cardLayout.show(cards.panel1, "card2");
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

    public String getUserAnswer() {
        return answerField.getText();
    }

    public void updateScore(int score) {
        scoreLabel.setText("Score: " + score);
    }

    public void clearAnswer() {
        answerField.setText("");
    }
}

