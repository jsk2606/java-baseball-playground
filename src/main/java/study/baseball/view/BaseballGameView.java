package study.baseball.view;

import study.baseball.domain.BallStatus;
import study.baseball.domain.Board;

public class BaseballGameView {

    final static String NOTHING_MESSAGE = "낫싱";
    final static String BALL_MESSAGE = " 볼 ";
    final static String STRIKE_MESSAGE = " 스트라이크";
    final static String CLEAR_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    final static String CONTINUE_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static void printBoard(Board board) {
        if(board.getStatusCount(BallStatus.NOTHING) == 3){
            System.out.println(NOTHING_MESSAGE);
            return;
        }

        StringBuilder sb = new StringBuilder();
        if(board.getStatusCount(BallStatus.BALL) > 0){
            sb.append(board.getStatusCount(BallStatus.BALL));
            sb.append(BALL_MESSAGE);
        }
        if(board.getStatusCount(BallStatus.STRIKE) > 0){
            sb.append(board.getStatusCount(BallStatus.STRIKE));
            sb.append(STRIKE_MESSAGE);
        }
        System.out.println(sb);
    }

    public static void printContinue() {
        System.out.println(CLEAR_MESSAGE);
        System.out.println(CONTINUE_MESSAGE);
    }
}
