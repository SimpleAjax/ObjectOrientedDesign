package machinecoding.TikTackToeGameDesign.model;

public class PlayerState {
    public int[] rowCount, colCount;
    public int diagCount, revDiagCount;
    public int n;

    PlayerState(int n) {
        rowCount = new int[n];
        colCount = new int[n];
        diagCount = revDiagCount = 0;
        this.n = n;
    }

    public boolean isRowCompleted(int row) {
        return rowCount[row] == n;
    }

    public boolean isColCompleted(int col) {
        return colCount[col] == n;
    }

    public boolean isDigCompleted() {
        return diagCount == n || revDiagCount == n;
    }
}
