import java.awt.*;

public class Token {

    private final TokenManager tokenManager;
    private final Point position;

    public Token(Point position, TokenManager tokenManager) {
        this.position = position;
        this.tokenManager = tokenManager;
    }

    public Token(int x, int y, TokenManager tokenManager) {
        this.position = new Point(x, y);
        this.tokenManager = tokenManager;
    }

    public void draw(Graphics2D graphics) {
        graphics.setColor(Color.ORANGE);

        graphics.fillRect(this.position.x * Game.TOKEN_SIZE, this.position.y * Game.TOKEN_SIZE, Game.TOKEN_SIZE, Game.TOKEN_SIZE);
    }

    public void update() {
        if (this.position.y < Game.TOKENS_Y_COUNT - 1) {

            if (this.tokenManager.getToken(this.position.x, this.position.y + 1) == null){
                this.position.y++;
            }
        }
    }

    public Point getPosition() {
        return this.position;
    }
}
