package machinecoding.TikTackToeGameDesign.service;

import machinecoding.TikTackToeGameDesign.controller.GameController;

import java.util.Timer;
import java.util.TimerTask;

public class TimerService {
    Timer timer;

    public TimerService() {
        timer = new Timer();
    }

    public void resetTimer(GameController gameController) {
        timer.cancel();
        timer.purge();
        if (gameController.isComplete()) {
            return;
        }
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                gameController.switchPlayer();
                System.out.println("Waited Too Long, Changing chance to :" + gameController.getCurrentPlayerName());
            }
        }, 50000);
    }

    public void cancelTimer() {
        timer.cancel();
    }
}
