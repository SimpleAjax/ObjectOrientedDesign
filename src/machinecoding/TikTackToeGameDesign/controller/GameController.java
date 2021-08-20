package machinecoding.TikTackToeGameDesign.controller;

import machinecoding.TikTackToeGameDesign.enums.ComputerLevelEnum;
import machinecoding.TikTackToeGameDesign.model.Game;
import machinecoding.TikTackToeGameDesign.enums.ResultEnum;
import machinecoding.TikTackToeGameDesign.exception.WrongMoveException;
import machinecoding.TikTackToeGameDesign.model.ComputerPlayer;
import machinecoding.TikTackToeGameDesign.model.GameBoard;
import machinecoding.TikTackToeGameDesign.model.HumanPlayer;
import machinecoding.TikTackToeGameDesign.model.User;
import machinecoding.TikTackToeGameDesign.service.GameService;
import machinecoding.TikTackToeGameDesign.service.TimerService;

/**
 * TODO: Clarify Questions
 * <p>
 * Which class will contain the logic to calculate winner
 * because the algorithm requires states to be saved.
 * <p>
 * If we are making 'Game' and 'GameService' both, where should the methods lie,
 * Is it okay for Some methods to lie in 'Game' and some in 'GameService'
 * <p>
 * <p>
 * is the reset timer ans player switch logic simple, or can the complexity be reduced
 */

// startGame(int n, player1, player2/computer)
// makeMove(player, int row, int col)
// List<GameHistory> fetchMyGames(player, int limit, int offset)
// List<Move> getDetailedGameHistory(player, Game)
public class GameController {
    Game game;
    GameBoard gameBoard;
    GameService gameService;
    TimerService timerService;
    boolean isComplete;

    public void initializeGame(int n, User user1, ComputerLevelEnum levelEnum) {
        game = new Game(new HumanPlayer(user1, -1, n), new ComputerPlayer(levelEnum, 1, n));
        commonInitialization(n);
    }

    private void commonInitialization(int n) {
        gameBoard = new GameBoard(n);
        isComplete = false;
        timerService = new TimerService();
        gameService = new GameService(game);
        timerService.resetTimer(this);
    }

    public void initializeGame(int n, User user1, User user2) {
        game = new Game(new HumanPlayer(user1, -1, n), new HumanPlayer(user2, 1, n));
        commonInitialization(n);
    }

    public void makeMove(int row, int col) throws WrongMoveException {
        gameBoard.markSlot(row, col, game.getCurrentPlayer().sign);
        game.gameHistory.addMove(row, col, game.getCurrentPlayer());
        gameService.updateCount(row, col);
        if (gameService.isWon(row, col)) {
            game.setWinResult(game.getCurrentPlayer());
            game.terminateGame();
            isComplete = true;
            timerService.cancelTimer();
        } else if (gameBoard.isFull()) {
            game.setDrawResult();
            game.terminateGame();
            isComplete = true;
            timerService.cancelTimer();
        }
        switchPlayer();
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void switchPlayer() {
        gameService.switchPlayer(this);
    }

    public void resetTimer() {
        timerService.resetTimer(this);
    }
    public void printGameState() {
        gameBoard.printGameState();
    }

    public String getCurrentPlayerName() {
        return game.getCurrentPlayer().getName();
    }

    public ResultEnum getResultEnum() {
        return game.getResult();
    }
}
