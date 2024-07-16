package study.baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Balls {

    private List<Ball> balls;
    private final int MAX_BALLS_SIZE = 3;

    public Balls(List<Ball> ballList) {
        setBalls(ballList);
    }

    private void setBalls(List<Ball> ballList) {
        this.balls = inspectBalls(ballList);
    }

    private List<Ball> inspectBalls(List<Ball> ballList) {
        if(ballList == null){
            throw new RuntimeException(new IllegalArgumentException());
        }
        if(ballList.size() != MAX_BALLS_SIZE){
            throw new RuntimeException(new IllegalArgumentException());
        }
        Set<Integer> set = new HashSet<>();
        ballList.forEach(ball -> set.add(ball.getBallNumber()));
        if(set.size() != MAX_BALLS_SIZE){
            throw new RuntimeException(new IllegalArgumentException());
        }
        return ballList;
    }

    public int getBallNumber(int index){
        return balls.get(index).getBallNumber();
    }

    public int size(){
        return balls.size();
    }

    public boolean containsBall(int ballNumber){
        for(Ball b : balls){
            if(b.getBallNumber() == ballNumber){
                return true;
            }
        }
        return false;
    }

    public static Balls tripleRandomNumberToBalls(String numbsers) {
        List<Ball> ballList = new ArrayList<>();
        for(int i=0; i<numbsers.length(); i++){
            ballList.add(new Ball(Character.getNumericValue(numbsers.charAt(i))));
        }
        return new Balls(ballList);
    }
}
