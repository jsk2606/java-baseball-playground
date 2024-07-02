package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class StringCalculatorTest {

    StringCalculator calculator = new StringCalculator();
    //--요구사항
    //사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
    //문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
    //예를 들어 "2 + 3 * 4 / 2"와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.
    @DisplayName("문자열 숫자 타입 유효성 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1","9999","488839129"})
    void isNumberTypeTest(String value) {
        assertThat(calculator.isNumberType(value)).isEqualTo(true);
    }

    @DisplayName("문자열 연산자 타입 유효성 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"+","-","*","/"})
    void isOperationTypeTest(String value) {
        assertThat(calculator.isOperationType(value)).isEqualTo(true);
    }

    @DisplayName("문자열 연산자 입력 유효성 테스트")
    @ParameterizedTest
    @MethodSource("inputInit")
    void stringCalculationTest(String[] values) {
        calculator.inputValidation(values);
    }

    @DisplayName("문자열 연산 테스트")
    @ParameterizedTest
    @CsvSource(value = {"+,2,3,5", "*,5,4,20", "/,20,2,10"})
    void stringCalculationTest(String operationSymbol, int inputA, int inputB, int expectValue) {
        assertThat(calculator.stringCalculation(operationSymbol, inputA, inputB))
                .isEqualTo(expectValue);
    }

    private Stream<Arguments> inputInit(){
        return Stream.of(arguments((Object) "2 + 3 * 4 / 2".split(" ")));
    }
}
