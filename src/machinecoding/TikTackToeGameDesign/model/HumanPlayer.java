package machinecoding.TikTackToeGameDesign.model;

public class HumanPlayer extends Player {
    User user;

    public HumanPlayer(User user, int sign, int n) {
        super(sign, new PlayerState(n), user.fullName);
        this.user = user;
    }
}
