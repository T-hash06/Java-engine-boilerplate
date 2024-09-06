import java.awt.*;

public class Token {


    private final Point position;

    public Token(Point position) {
        this.position = position;
    }

    public Token(int x, int y) {
        this.position = new Point(x, y);
    }

    public void draw(Graphics2D graphics) {
        graphics.setColor(Color.ORANGE);

        graphics.fillRect(this.position.x * Game.TOKEN_SIZE, this.position.y * Game.TOKEN_SIZE, Game.TOKEN_SIZE, Game.TOKEN_SIZE);
    }

    public void update() {
        if (this.position.y < Game.TOKENS_Y_COUNT - 1) {
            this.position.y++;
        }
    }
}
