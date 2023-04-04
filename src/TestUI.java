import javax.swing.*;

public class TestUI {
    private JFrame[] frames;
    private int currentFrameIndex;

    public TestUI() {
        // Create the quiz frames
        frames = new JFrame[]{new StartFrame(this), new MCQFrame(this), new DescFrame(this)};

        // Show the first frame
        currentFrameIndex = 0;
        frames[currentFrameIndex].setVisible(true);
    }

    public void showNextFrame() {
        // Close the current frame
        frames[currentFrameIndex].dispose();

        // Move to the next frame
        currentFrameIndex++;
        if (currentFrameIndex < frames.length) {
            // Show the next frame
            frames[currentFrameIndex].setVisible(true);
        } else {
            // The quiz is complete, exit the program
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new TestUI();
    }
}