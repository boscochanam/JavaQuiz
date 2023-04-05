package ui_package;

import javax.swing.*;

public class TestUI {

    private JFrame currentFrame;
    private JFrame[] frames;
    private int currentFrameIndex;

    private JFrame startFrame;

    public TestUI() {
        // Initialize the frames
        frames = new JFrame[]{new MCQFrame(this), new DescFrame(this)};
        currentFrameIndex = -1;

        // Show the StartFrame
        startFrame = new StartFrame(this);
    }

    public void showNextFrame() {
        // Close the current frame if it exists
        if (currentFrame != null) {
            currentFrame.dispose();
        }

        // Move to the next frame
        currentFrameIndex++;

        // Check if there are no more frames to show
        if (currentFrameIndex >= frames.length) {
            // Show a message dialog indicating the end of the quiz
            JOptionPane.showMessageDialog(null, "End of Quiz!");
            // Exit the program
            System.exit(0);
        }

        // Show the next frame
        currentFrame = frames[currentFrameIndex];
        currentFrame.setVisible(true);
    }

    public static void main(String[] args) {
        // Create a new ui_package.TestUI instance
        TestUI testUI = new TestUI();
    }
}
