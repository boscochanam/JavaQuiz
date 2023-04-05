//package not_used;
//
//import ui_package.TestUI;
//
//import javax.swing.*;
//import java.awt.*;
//
//public class notDescFrame extends JFrame {
//
//    private TestUI ui;
//
//    public notDescFrame(TestUI ui) {
//        super("Java Quiz");
//
//        this.ui = ui;
//
//        // Set up the question panel
//        JPanel questionPanel = new JPanel();
//        questionPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
//        questionPanel.setLayout(new BorderLayout());
//
//        // Set up the question label
//        JLabel questionLabel = new JLabel("What is the capital of France?");
//        questionLabel.setFont(new Font("Arial", Font.PLAIN, 20));
//        questionPanel.add(questionLabel, BorderLayout.NORTH);
//
//        // Set up the answer text box
//        JPanel answerPanel = new JPanel();
//        answerPanel.setLayout(new BorderLayout());
//        JTextField answerTextField = new JTextField();
//        answerPanel.add(answerTextField, BorderLayout.CENTER);
//        questionPanel.add(answerPanel, BorderLayout.CENTER);
//
//        // Set up the submit button
//        JButton submitButton = new JButton("Submit");
//        submitButton.addActionListener(e -> {
//            String userAns = answerTextField.getText();
//            // Check if the correct answer is entered
//            if (userAns.equalsIgnoreCase("Paris")) {
//                JOptionPane.showMessageDialog(this, "Correct!");
//            } else {
//                JOptionPane.showMessageDialog(this, "Incorrect!");
//            }
//            // Close the current frame and open the next one
//            ui.showNextFrame();
//            dispose();
//        });
//        questionPanel.add(submitButton, BorderLayout.SOUTH);
//
//        // Add the question panel to the frame
//        add(questionPanel);
//
//        setSize(500, 500);
//        setVisible(true);
//    }
//
//    public static void main(String[] args) {
//        // Instantiate the frame and show it
//        notDescFrame frame = new notDescFrame(new TestUI());
//        frame.setVisible(true);
//    }
//
//
//
//}