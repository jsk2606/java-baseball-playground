package study.domain_ver2;

import java.util.HashMap;
import java.util.Map;

public class Player {

    private final Map<BallStatus,Integer> ballStatusCount = new HashMap<>();
    final int CLEAR_COUNT_STRIKES = 3;


    public void setPlayResult(BallStatus ballStatus) {
        ballStatusCount.put(ballStatus, getStatusCount(ballStatus));
    }

    private Integer getStatusCount(BallStatus ballStatus) {
        if(ballStatusCount.get(ballStatus) == null){
            return 1;
        }
        return ballStatusCount.get(ballStatus) + 1;
    }

    public boolean isClear() {
        if(ballStatusCount.get(BallStatus.STRIKE) != null && ballStatusCount.get(BallStatus.STRIKE) == CLEAR_COUNT_STRIKES){
            clearOut();
            return true;
        }
        reTryOut();
        return false;
    }

    private void clearOut() {
        final String clearMessage = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        System.out.println(clearMessage);
    }

    private void reTryOut() {
        StringBuilder sb = new StringBuilder();
        if(ballStatusCount.get(BallStatus.BALL) != null && ballStatusCount.get(BallStatus.BALL) > 0){
            sb.append(ballStatusCount.get(BallStatus.BALL));
            sb.append(BallStatus.BALL.getName());
        }
        if(ballStatusCount.get(BallStatus.STRIKE) != null && ballStatusCount.get(BallStatus.STRIKE) > 0){
            sb.append(ballStatusCount.get(BallStatus.STRIKE));
            sb.append(BallStatus.STRIKE.getName());
        }
        if(sb.length() == 0){
            sb.append(BallStatus.NOTHING.getName());
        }
        System.out.println(sb);
    }
}
