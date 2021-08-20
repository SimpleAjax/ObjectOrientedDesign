package machinecoding.TikTackToeGameDesign;

import machinecoding.TikTackToeGameDesign.controller.GameController;
import machinecoding.TikTackToeGameDesign.exception.WrongMoveException;
import machinecoding.TikTackToeGameDesign.model.User;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // startGame(int n, player1, player2/computer)
        // makeMove(player, int row, int col)
        // List<GameHistory> fetchMyGames(player, int limit, int offset)
        // List<Move> getDetailedGameHistory(player, Game)

        GameController gameController = new GameController();
        User user1 = new User("player1");
        User user2 = new User("player2");
        gameController.initializeGame(3, user1, user2);

        System.out.println("Game Has been started and current game state is: ");
        gameController.printGameState();
        while(!gameController.isComplete()) {
            System.out.println("Please enter row/col for : " + gameController.getCurrentPlayerName());
            Scanner scanner = new Scanner(System.in);
            String nextLine = scanner.nextLine();
            String[] num = nextLine.split(" ");
            int row = Integer.parseInt(num[0]);
            int col = Integer.parseInt(num[1]);
            try {
                gameController.makeMove(row, col);
            } catch (WrongMoveException e) {
                System.out.println("Exception occurred with message: \n" + e.getMessage());
            }
            System.out.println("current stat of board is: ");
            gameController.printGameState();
        }
        System.out.println("The game is completed with result: " + gameController.getResultEnum());
    }
}
