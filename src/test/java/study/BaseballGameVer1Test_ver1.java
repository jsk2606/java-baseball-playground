package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class BaseballGameVer1Test_ver1 {

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

    BaseballGame_ver1 baseballGameVer1;

    @BeforeEach
    void baseballGameInit(){
        baseballGameVer1 = new BaseballGame_ver1();
    }

    @RepeatedTest(1000)
    void getRandomNumberTest(){
        String randomNumber = baseballGameVer1.getBatter();
        Assertions.assertThat(randomNumber.length() == 3).isEqualTo(true);
        Assertions.assertThat(Integer.parseInt(randomNumber) > 11).isEqualTo(true);
        Assertions.assertThat(Integer.parseInt(randomNumber) < 988).isEqualTo(true);
    }

    @ParameterizedTest
    @CsvSource(value = {"838,true", "011,true", "965,false", "01A,false"})
    void isThreeDigitDuplicationTest(String input, boolean expect){
        Assertions.assertThat(baseballGameVer1.isThreeDigitDuplication(input)).isEqualTo(expect);
    }

    @ParameterizedTest
    @CsvSource(value = {"012,true", "011,false", "01,false", "01A,false"})
    void inputValueVerificationTest(String input, boolean expect){
        Assertions.assertThat(baseballGameVer1.inputValueVerification(input)).isEqualTo(expect);
        Assertions.assertThat(baseballGameVer1.inputValueVerification(input)).isEqualTo(expect);
        Assertions.assertThat(baseballGameVer1.inputValueVerification(input)).isEqualTo(expect);
        Assertions.assertThat(baseballGameVer1.inputValueVerification(input)).isEqualTo(expect);
    }

    @ParameterizedTest
    @ValueSource(strings = {"123","123","123","123","123"})
    void judgmentResultTest(String input){
        String judgmentResult = baseballGameVer1.judgmentResult(input);
        boolean testResult = false;
        testResult = "".equals(judgmentResult);

        if(!testResult){
            testResult = "낫싱".equals(judgmentResult);
        }
        if(!testResult){
            testResult = judgmentResult.contains("볼") || judgmentResult.contains("스트라이크");
        }

        Assertions.assertThat(testResult).isEqualTo(true);
    }


}
