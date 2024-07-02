package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void firstRequirement(){
        // 1) "1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
        String[] actualA = "1,2".split(",");
        assertThat(actualA).contains("1", "2");

        // 2) "1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
        String[] actualB = "1".split(",");
        assertThat(actualB).containsExactly("1");
    }

    @Test
    void secondRequirement(){
        // "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환하도록 구현한다.
        String actual = "(1,2)".substring(1,4);
        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    @DisplayName("index out of Exception Test")
    void thirdRequirement(){
        String actual = "(1,2)";
        assertThatThrownBy(() -> actual.charAt(9))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 9");

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> actual.charAt(9))
                .withMessageMatching("String index out of range: 9");
    }
}
