import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

public class Game implements Runnable {

    public static int TOKENS_X_COUNT = 20;
    public static int TOKENS_Y_COUNT = 20;
    public static int TOKEN_SIZE = 38;
    public static int WIDTH = TOKENS_X_COUNT * TOKEN_SIZE;
    public static int HEIGHT = TOKENS_Y_COUNT * TOKEN_SIZE;

    private final Window window;
    private int ups;
    private int fps;
    private Thread thread;

    private BufferStrategy bufferStrategy;
    private final TokenManager tokenManager;

    public Game(char[][] tokens) {
        this.tokenManager = new TokenManager(tokens);

        this.window = new Window("Game", WIDTH, HEIGHT);

        this.ups = 0;
        this.fps = 0;
    }

    public void update() {
        this.tokenManager.update();
        ups++;
    }

    public void draw() {
        if (this.bufferStrategy == null) {
            this.window.getCanvas().createBufferStrategy(2);
            this.bufferStrategy = this.window.getCanvas().getBufferStrategy();
        }

        Graphics2D graphics = (Graphics2D) this.bufferStrategy.getDrawGraphics();

        graphics.clearRect(0, 0, WIDTH, HEIGHT);

        // Zona de dibujado
        this.tokenManager.draw(graphics);
        Helper.drawGrid(graphics);
        // Fin zona de dibujado

        graphics.dispose();

        this.bufferStrategy.show();
        fps++;
    }

    @Override
    public void run() {
        final int UPS = 1;
        final int FPS = 30;
        final double NS_PER_SECOND = 1_000_000_000;
        final double NS_PER_UPDATE = NS_PER_SECOND / UPS;
        final double NS_PER_FRAME = NS_PER_SECOND / FPS;

        // Guarda la ultima vez que se actualizo el juego
        long updateRef = System.nanoTime();
        // Guarda la ultima vez que se actualizo el frame
        long frameRef = System.nanoTime();
        // Guarda la ultima vez que se actualizo el contador
        long counterRef = System.nanoTime();

        while (true) {
            long currentTime = System.nanoTime();
            long updateElapsedTime = currentTime - updateRef;
            long frameElapsedTime = currentTime - frameRef;

            if (updateElapsedTime > NS_PER_UPDATE) {
                this.update();
                updateRef = currentTime;
            }

            if (frameElapsedTime > NS_PER_FRAME) {
                frameRef = currentTime;
                this.draw();
            }

            if (currentTime - counterRef > NS_PER_SECOND) {
                counterRef = currentTime;
                this.window.getFrame().setTitle("Game UPS: " + ups + " | FPS: " + fps);
                ups = 0;
                fps = 0;
            }
        }
    }

    public void start() {
        this.thread = new Thread(this, "GameThread");
        this.thread.start();
    }

    public void stop() {
        try {
            this.thread.join();
        } catch (InterruptedException e) {
            // Aqui ocurre lo que pasa si el hilo no puede ser detenido
            e.printStackTrace();
        }
    }
}
