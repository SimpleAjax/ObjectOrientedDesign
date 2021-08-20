package machinecoding.TikTackToeGameDesign.service;

import machinecoding.TikTackToeGameDesign.model.Game;
import machinecoding.TikTackToeGameDesign.controller.GameController;
import machinecoding.TikTackToeGameDesign.model.PlayerState;

public class GameService {
    Game game;

    public GameService(Game game) {
        this.game = game;
    }

    public boolean isWon(int row, int col) {
        PlayerState playerState = game.getCurrentPlayer().playerState;
        return playerState.isRowCompleted(row) || playerState.isColCompleted(col) || playerState.isDigCompleted();
    }

    public void updateCount(int row, int col) {
        PlayerState playerState = game.getCurrentPlayer().playerState;
        if (row == col) {
            playerState.diagCount++;
        }
        if (row == playerState.n - col) {
            playerState.revDiagCount++;
        }
        playerState.rowCount[row]++;
        playerState.colCount[col]++;
    }

    public void switchPlayer(GameController gameController) {
        if (game.getCurrentPlayer().equals(game.player1)) {
            game.currentPlayer = game.player2;
        } else {
            game.currentPlayer = game.player1;
        }
        gameController.resetTimer();
    }
}
