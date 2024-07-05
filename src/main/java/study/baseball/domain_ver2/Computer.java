package study.baseball.domain_ver2;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Ball> balls = new ArrayList<>();

    public Computer(){

    }

    public void setBalls(List<Ball> balls) {
        // TODO : random Ball 추출
        this.balls = balls;
    }


    public BallStatus playBall(Ball ball) {
        if(isStrike(ball)){
            return BallStatus.STRIKE;
        }
        if(isBall(ball)){
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }

    private boolean isBall(Ball ball) {
        return balls.stream()
                .anyMatch(b -> b.getInput() == ball.getInput());
    }

    private boolean isStrike(Ball ball) {
        return balls.stream()
                .anyMatch(b -> b.getPosition() == ball.getPosition() && b.getInput() == ball.getInput());
    }
}
