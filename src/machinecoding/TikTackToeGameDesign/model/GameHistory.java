package machinecoding.TikTackToeGameDesign.model;

import machinecoding.TikTackToeGameDesign.enums.ResultEnum;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GameHistory {
    Player player1;
    Player player2;
    LocalDateTime startTime;
    LocalDateTime endTime;
    ResultEnum resultEnum;
    List<Move> moves;

    public GameHistory(Player player1, Player player2, LocalDateTime startTime) {
        this.player1 = player1;
        this.player2 = player2;
        this.startTime = startTime;
        moves = new ArrayList<>();
    }

    public void endGame() {
        endTime = LocalDateTime.now();
    }

    public void setResult(ResultEnum resultEnum) {
        this.resultEnum = resultEnum;
    }

    public void addMove(int row, int col, Player player) {
        moves.add(new Move(row, col, player));
    }
}
