package study.baseball.domain;

public class Ball {

    private int ballNumber;
    private final int MAX_BALL_NUMBER = 9;
    private final int MIN_BALL_NUMBER = 1;

    public Ball(int input) {
        setBallNumber(input);
    }

    public int getBallNumber() {
        return ballNumber;
    }
    private void setBallNumber(int input) {
        this.ballNumber = inspectBall(input);
    }

    private int inspectBall(int input) {
        if(MIN_BALL_NUMBER <= input && MAX_BALL_NUMBER >= input){
            return input;
        }
        throw new RuntimeException(new IllegalArgumentException());
    }
}
