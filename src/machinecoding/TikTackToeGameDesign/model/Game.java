package machinecoding.TikTackToeGameDesign.model;

import machinecoding.TikTackToeGameDesign.enums.ResultEnum;

import java.time.LocalDateTime;

public class Game {
    public Player player1;
    public Player player2;
    LocalDateTime startTime;
    public Player currentPlayer;
    ResultEnum resultEnum;
    public GameHistory gameHistory;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.startTime = LocalDateTime.now();
        currentPlayer = player1;
        resultEnum = ResultEnum.ONGOING;
        gameHistory = new GameHistory(player1, player2, startTime);
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setWinResult(Player player) {
        resultEnum = player.equals(player1) ? ResultEnum.WIN_PLAYER1 : ResultEnum.WIN_PLAYER2;
    }

    public void setDrawResult() {
        resultEnum = ResultEnum.DRAW;
    }

    public void terminateGame() {
        if (resultEnum.equals(ResultEnum.ONGOING)) {
            resultEnum = ResultEnum.ABRUPT;
        }
        gameHistory.endGame();
        gameHistory.setResult(resultEnum);
    }

    public ResultEnum getResult() {
        return resultEnum;
    }
}
