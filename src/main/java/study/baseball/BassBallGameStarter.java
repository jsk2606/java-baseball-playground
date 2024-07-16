package study.baseball;

import study.baseball.controller.BaseballGame;
import study.baseball.domain.Balls;
import study.baseball.view.BaseballGameView;

public class BassBallGameStarter {

    public static void main(String[] args) {
        boolean isTry = true;

        while(isTry){
            Balls answer = BaseballGame.createAnswer();
            BaseballGame game = new BaseballGame(answer);
            BaseballGame.play(game);
            BaseballGameView.printContinue();
            isTry = BaseballGame.isTry();
        }
    }
}
