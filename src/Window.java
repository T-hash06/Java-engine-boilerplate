import javax.swing.*;
import java.awt.*;

public class Window {

    private JFrame frame;
    private Canvas canvas;

    public Window(String title, int width, int height) {
        this.initCanvas(width, height);
        this.initJFrame(title, width, height);

        this.frame.setVisible(true);
    }

    public void initJFrame(String title, int width, int height) {
        this.frame = new JFrame(title);
        this.frame.setSize(width, height);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setLocationRelativeTo(null);
        this.frame.setResizable(false);

        this.frame.add(this.canvas);
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
