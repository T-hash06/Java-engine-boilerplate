import java.awt.*;

public abstract class Helper {

    public static void drawGrid(Graphics2D graphics) {
        graphics.setColor(Color.BLACK);

        for (int x = 0; x < Game.TOKENS_X_COUNT; x++) {
            graphics.drawLine(x * Game.TOKEN_SIZE, 0, x * Game.TOKEN_SIZE, Game.HEIGHT);
        }

        for (int y = 0; y < Game.TOKENS_X_COUNT; y++) {
            graphics.drawLine(0, y * Game.TOKEN_SIZE, Game.WIDTH, y * Game.TOKEN_SIZE);
        }
    }
}
