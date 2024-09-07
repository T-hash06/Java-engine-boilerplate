public class Main {

    public static void main(String[] args) {
        char[][] tokens = {
                {'X', '.', '.', 'X', '.', '.'},
                {'X', '.', 'X', 'X', '.', '.'},
                {'X', '.', 'X', 'X', '.', '.'},
                {'X', '.', 'X', 'X', '.', '.'},
                {'X', '.', 'X', 'X', '.', '.'},
                {'.', '.', '.', 'X', '.', '.'}
        };
        Game game = new Game(tokens);
        game.start();
    }
}
