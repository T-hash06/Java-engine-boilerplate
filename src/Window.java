import javax.swing.*;
import java.awt.*;

public class Window {

    private JFrame frame;
    private Canvas canvas;

    public Window(String title, int width, int height) {
        this.initCanvas(width, height);
        this.initJFrame(title);

        this.frame.setVisible(true);
    }

    public void initJFrame(String title) {
        this.frame = new JFrame(title);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setResizable(false);

        this.frame.add(this.canvas);
        this.frame.pack();
        this.frame.setLocationRelativeTo(null);
    }

    public void initCanvas(int width, int height) {
        this.canvas = new Canvas();
        this.canvas.setSize(width, height);
    }

    public JFrame getFrame() {
        return frame;
    }

    public Canvas getCanvas() {
        return canvas;
    }
}
