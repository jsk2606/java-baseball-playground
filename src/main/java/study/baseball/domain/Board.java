package study.baseball.domain;

import java.util.HashMap;
import java.util.Map;

public class Board {
    private final Map<BallStatus, Integer> matchResult = new HashMap<>();

    public void setInning(BallStatus ballStatus){
        int statusCount = getStatusCount(ballStatus);
        matchResult.put(ballStatus, ++statusCount);
    }

    public int getStatusCount(BallStatus ballStatus) {
        if(matchResult.get(ballStatus) != null){
            return matchResult.get(ballStatus);
        }
        return 0;
    }

    //이쁜방법이 있을거 같은데
    public boolean isClear(){
        return getStatusCount(BallStatus.STRIKE) == 3;
    }
}
