package machinecoding.TikTackToeGameDesign.model;

public abstract class Player {
    public int sign;
    public PlayerState playerState;
    String name;

    public Player(int sign, PlayerState playerState, String name) {
        this.sign = sign;
        this.playerState = playerState;
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
