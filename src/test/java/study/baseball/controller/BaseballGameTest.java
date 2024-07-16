package study.baseball.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.baseball.domain.Ball;
import study.baseball.domain.BallStatus;
import study.baseball.domain.Balls;
import study.baseball.domain.Board;
import study.baseball.view.BaseballGameView;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BaseballGameTest {

    @Test
    void 숫자_1_9_볼생성_성공(){
        new Ball(1);
        new Ball(9);
    }
    @Test
    void 숫자_1_9_볼생성_실패(){
        assertThatThrownBy(() -> new Ball(0))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("java.lang.IllegalArgumentException");
    }

    // 예외처리 리팩토링 대상
    @Test
    @DisplayName("볼이 3개이고, 볼 값이 중복되지 않습니다")
    void 볼스_생성_성공(){
        List<Ball> ballList = new ArrayList<>();
        ballList.add(new Ball(1));
        ballList.add(new Ball(2));
        ballList.add(new Ball(9));

        new Balls(ballList);
    }

    // 예외처리 리팩토링 대상
    @Test
    void 볼스_생성_실패(){
        List<Ball> ballList = new ArrayList<>();
        ballList.add(new Ball(1));
        ballList.add(new Ball(2));
        ballList.add(new Ball(1));

        assertThatThrownBy(() -> new Balls(ballList))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("java.lang.IllegalArgumentException");
    }

    @Test
    void 게임_정답생성_성공(){
        List<Ball> ballList = new ArrayList<>();
        ballList.add(new Ball(1));
        ballList.add(new Ball(2));
        ballList.add(new Ball(3));
        BaseballGame baseballGame = new BaseballGame(new Balls(ballList));
    }

    @Test
    void 게임_피칭(){
        List<Ball> ballList = new ArrayList<>();
        ballList.add(new Ball(1));
        ballList.add(new Ball(2));
        ballList.add(new Ball(3));
        BaseballGame baseballGame = new BaseballGame(new Balls(ballList));

        List<Ball> pitchingBalls = new ArrayList<>();
        pitchingBalls.add(new Ball(1));
        pitchingBalls.add(new Ball(2));
        pitchingBalls.add(new Ball(3));

        Board board = baseballGame.pitching(new Balls(pitchingBalls));

        int strikeCount = board.getStatusCount(BallStatus.STRIKE);
        int ballCount = board.getStatusCount(BallStatus.BALL);
        int nothingCount = board.getStatusCount(BallStatus.NOTHING);
        assertThat(strikeCount + ballCount + nothingCount).isEqualTo(3);
    }

    @Test
    void 피칭결과_출력(){
        Board board = new Board();
        board.setInning(BallStatus.STRIKE);
        board.setInning(BallStatus.BALL);
        board.setInning(BallStatus.NOTHING);

        BaseballGameView.printBoard(board);
    }
}
