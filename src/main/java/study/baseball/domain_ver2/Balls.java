package study.baseball.domain_ver2;

import study.baseball.BaseballValidation_ver2;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    List<Ball> balls;

    BaseballValidation_ver2 validation;

    public Balls(int[] input){
        balls = new ArrayList<>();
        // 사용자에게 입력 받음
        new Ball(1,1);
        new Ball(2,2);
        new Ball(3,3);


    }
}
