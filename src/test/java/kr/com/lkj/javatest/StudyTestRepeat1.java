package kr.com.lkj.javatest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * @RepeatedTest
 * - 반복 횟수와 반복 테스트 이름을 설정 할 수 있음
 * {displayName}, {currentRepetition}, {totalRepetitions}
 * RepetitionInfo 타입의 인자를 받을 수 있음
 *
 * @ParameterizedTest
 * - 테스트에 여러 다른 매개변수를 대입해가며 반복 실행
 * {displayName}, {index}, {arguments}
 * {0}, {1}, ...
 */
class StudyTestRepeat1 {

    @RepeatedTest(10)
    void repeatTestFirst() {
        System.out.println("test");
    }

    @RepeatedTest(10)
    void repeatTestSecond(RepetitionInfo repetitionInfo) {
        System.out.println("test " + repetitionInfo.getCurrentRepetition() + "/" + repetitionInfo.getTotalRepetitions());
    }

    //반복 횟수 value, displayName -> property 조합으로 이용가능
    @DisplayName("스터디 만들기")
    @RepeatedTest(value = 10, name = "{displayName}, {currentRepetition}/{totalRepetitions}")
    void repeatTestThird(RepetitionInfo repetitionInfo) {
        System.out.println("test " + repetitionInfo.getCurrentRepetition() + "/" + repetitionInfo.getTotalRepetitions());
    }

    @DisplayName("스터디 만들기")
    @ParameterizedTest(name = "{index} {displayName} message = {0}")  //파라미터도 참조 가능
    @ValueSource(strings = {"날씨가", "많이", "추워지고", "있네요"})    //파라미터 횟수 만큼 호출
    void parameterizedTest(String message) {
        System.out.println(message);
    }
}
