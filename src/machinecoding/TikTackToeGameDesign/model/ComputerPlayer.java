package machinecoding.TikTackToeGameDesign.model;

import machinecoding.TikTackToeGameDesign.enums.ComputerLevelEnum;

public class ComputerPlayer extends Player {
    ComputerLevelEnum levelEnum;

    public ComputerPlayer(ComputerLevelEnum levelEnum, int sign, int n) {
        super(sign, new PlayerState(n), "Computer");
        this.levelEnum = levelEnum;
    }
}
