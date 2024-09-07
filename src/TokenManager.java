import java.awt.*;
import java.util.ArrayList;

public class TokenManager {

    private final ArrayList<Token> tokens;

    public TokenManager(char[][] tokens) {
        Game.TOKENS_X_COUNT = tokens.length;
        Game.TOKENS_Y_COUNT = tokens[0].length;
        Game.WIDTH = Game.TOKENS_X_COUNT * Game.TOKEN_SIZE;
        Game.HEIGHT = Game.TOKENS_Y_COUNT * Game.TOKEN_SIZE;

        this.tokens = new ArrayList<>();

        for (int y = 0; y < tokens.length; y++) {
            for (int x = 0; x < tokens[y].length; x++) {
                if (tokens[y][x] == 'X') {
                    this.tokens.add(new Token(x, y, this));
                }
            }
        }
    }

    public void draw(Graphics2D graphics) {
        for (Token token : this.tokens) {
            token.draw(graphics);
        }
    }

    public void update() {
        for (Token token : this.tokens) {
            token.update();
        }
    }

    public Token getToken(int x, int y) {
        for (Token token : this.tokens) {
            if (token.getPosition().x == x && token.getPosition().y == y) {
                return token;
            }
        }

        return null;
    }
}
