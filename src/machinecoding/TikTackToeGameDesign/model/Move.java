package machinecoding.TikTackToeGameDesign.model;

class Move {
    int row, col;
    Player player;

    Move(int row, int col, Player player) {
        this.row = row;
        this.col = col;
        this.player = player;
    }
}
