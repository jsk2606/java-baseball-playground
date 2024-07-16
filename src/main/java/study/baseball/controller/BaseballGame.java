package study.baseball.controller;

import study.baseball.domain.BallStatus;
import study.baseball.domain.Balls;
import study.baseball.domain.Board;
import study.baseball.view.BaseballGameView;

import java.util.Random;
import java.util.Scanner;

public class BaseballGame {

    private final Balls ANSWER;
    private static final String BALL_INPUT_MESSAGE = "숫자를 입력해 주세요 : ";

    public BaseballGame(Balls balls){
        ANSWER = balls;
    }

    public Board pitching(Balls pitchingBalls) {
        Board board = new Board();

        for(int i=0; i<ANSWER.size(); i++){
            if(ANSWER.getBallNumber(i) == pitchingBalls.getBallNumber(i)){
                board.setInning(BallStatus.STRIKE);
                continue;
            }else if(ANSWER.containsBall(pitchingBalls.getBallNumber(i))){
                board.setInning(BallStatus.BALL);
                continue;
            }
            board.setInning(BallStatus.NOTHING);
        }
        return board;
    }

    public static void play(BaseballGame game) {
        boolean isWrong = true;
        while (isWrong){
            Balls pitchingBalls = inputBalls();
            Board board = game.pitching(pitchingBalls);
            BaseballGameView.printBoard(board);
            isWrong = !board.isClear();
        }
    }

    private static Balls inputBalls() {
        Balls result = null;
        while (result == null){
            System.out.print(BALL_INPUT_MESSAGE);
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine().trim();
            try {
                result = Balls.tripleRandomNumberToBalls(input);
            }catch (RuntimeException e){
                continue;
            }
            break;
        }
        return result;
    }

    public static Balls createAnswer() {
        Balls balls;
        while (true){
            try{
                balls = Balls.tripleRandomNumberToBalls(getTripleRandomNumber());
            }catch (RuntimeException e){
                continue;
            }
            break;
        }
        return balls;
    }

    public static String getTripleRandomNumber(){
        final int RESULT_MAXIMUM = 987;
        final int RESULT_MINIMUM = 12;
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        int randomNumber = random.nextInt((RESULT_MAXIMUM - RESULT_MINIMUM) + 1) + RESULT_MINIMUM;
        if(randomNumber < 100){
            sb.append(0);
        }
        sb.append(randomNumber);
        return sb.toString();
    }

    public static boolean isTry() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        if("1".equals(input)){
            return true;
        }
        return false;
    }
}
