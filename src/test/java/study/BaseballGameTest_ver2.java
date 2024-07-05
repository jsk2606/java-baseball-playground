package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.domain_ver2.Ball;
import study.domain_ver2.BallStatus;
import study.domain_ver2.Computer;
import study.domain_ver2.Player;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballGameTest_ver2 {
        /*
     - 요구사항

     기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.
     같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 포볼 또는 낫싱이란 힌트를 얻고, 그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다.
     e.g. 상대방(컴퓨터)의 수가 425일 때, 123을 제시한 경우 : 1스트라이크, 456을 제시한 경우 : 1볼 1스트라이크, 789를 제시한 경우 : 낫싱
     위 숫자 야구 게임에서 상대방의 역할을 컴퓨터가 한다. 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다. 게 임 플레이어는 컴퓨터가 생각하고 있는 3개의 숫자를 입력하고, 컴퓨터는 입력한 숫자에 대한 결과를 출력한다.
     이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
     게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.

     - 실행 결과

     숫자를 입력해 주세요 : 123
     1볼 1스트라이크
     숫자를 입력해 주세요 : 145
     1볼
     숫자를 입력해 주세요 : 671
     2볼
     숫자를 입력해 주세요 : 216
     1스트라이크
     숫자를 입력해 주세요 : 713
     3스트라이크
     3개의 숫자를 모두 맞히셨습니다! 게임 종료
     게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.
     1
     숫자를 입력해 주세요 : 123
     1볼 1스트라이크
     …
     */

    /**
     * TODO :
     * 1. 유효성 검증 : 1 - 9 로 이루어진 숫자, 3자리, 동일한 숫자 불가.
     *  - 1) 1-9 확인
     *  - 2) 3자리 확인
     *  - 3) 동일한 숫자가 있는지 확인
     * 2. 숫자 비교 기능 :
     *  - 1) 같은 자리에 같은 숫자인지
     *  - 2) 다른 자리에 같은 숫자인지
     *  - 3) 모두 다른 숫자인지
     * 3. 비교 결과 출력
     *
     * DOMAIN :
     * 1. Ball - 필드:위치, 숫자
     * 2. BallStatus - 필드:strike,ball,nothing
     * 3. Player - 필드:List<Ball>, Map<BallStatus,Integer>
     * 4. Computer - 필드:List<Ball>
     * */

    @Test
    @DisplayName("1-9 확인")
    void isANumberFrom1To9(){
        assertThat(BaseballValidation_ver2.isNumberFrom1To9(1)).isTrue();
        assertThat(BaseballValidation_ver2.isNumberFrom1To9(9)).isTrue();
        assertThat(BaseballValidation_ver2.isNumberFrom1To9(0)).isFalse();
        assertThat(BaseballValidation_ver2.isNumberFrom1To9(10)).isFalse();
    }

    @Test
    @DisplayName("3자리 확인")
    void isThreeDigits(){
        assertThat(BaseballValidation_ver2.isThreeDigits(123)).isTrue();
        assertThat(BaseballValidation_ver2.isThreeDigits(999)).isTrue();
        assertThat(BaseballValidation_ver2.isThreeDigits(1111)).isFalse();
    }

    @Test
    @DisplayName("동일한 숫자가 있는지 확인")
    void isDuplicateNumber(){
        assertThat(BaseballValidation_ver2.isDuplicateNumber(129)).isFalse();
        assertThat(BaseballValidation_ver2.isDuplicateNumber(12340)).isFalse();
        assertThat(BaseballValidation_ver2.isDuplicateNumber(12321)).isTrue();
    }

    @Test
    @DisplayName("같은 자리에 같은 숫자인지")
    void isStrike(){
        List<Ball> balls = new ArrayList<>();
        balls.add(new Ball(1, 1));
        balls.add(new Ball(2, 3));
        balls.add(new Ball(3, 2));
        Computer computer = new Computer();
        computer.setBalls(balls);
        assertThat(computer.playBall(new Ball(1, 1))).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    @DisplayName("다른 자리에 같은 숫자인지")
    void isBall(){
        List<Ball> balls = new ArrayList<>();
        balls.add(new Ball(1, 1));
        balls.add(new Ball(2, 3));
        balls.add(new Ball(3, 2));
        Computer computer = new Computer();
        computer.setBalls(balls);
        assertThat(computer.playBall(new Ball(1, 2))).isEqualTo(BallStatus.BALL);
    }

    @Test
    @DisplayName("모두 다른 숫자인지")
    void isNothing(){
        List<Ball> balls = new ArrayList<>();
        balls.add(new Ball(1, 1));
        balls.add(new Ball(2, 3));
        balls.add(new Ball(3, 2));
        Computer computer = new Computer();
        computer.setBalls(balls);
        assertThat(computer.playBall(new Ball(1, 5))).isEqualTo(BallStatus.NOTHING);
    }

    @Test
    @DisplayName("비교 결과 출력 - 성공")
    void playResultClear(){
        Player player = new Player();
        player.setPlayResult(BallStatus.STRIKE);
        player.setPlayResult(BallStatus.STRIKE);
        player.setPlayResult(BallStatus.STRIKE);
        assertThat(player.isClear()).isTrue();
    }

    @Test
    @DisplayName("비교 결과 출력 - 실패")
    void playResultUnClear(){
        Player player = new Player();
        player.setPlayResult(BallStatus.STRIKE);
        player.setPlayResult(BallStatus.BALL);
        player.setPlayResult(BallStatus.NOTHING);
        assertThat(player.isClear()).isFalse();
    }

}
