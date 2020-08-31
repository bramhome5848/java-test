package kr.com.lkj.javatest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StudyTestAssertion {

    /**
     * Assertion
     * assertEqulas(expected, actual) -> 실제 값이 기대한 값과 같은지 확인
     * assertTrue(boolean) -> 다음 조건이 참(true)인지 확인
     * assertAll(executables...) -> 모든 확인 구문 확인
     * assertThrows(expectedType, executable) -> 예외 발생 확인
     * assertTimeout(duration, executable) -> 특정 시간 안에 실행이 완료되는지 확인
     */
    @Test
    @DisplayName("스터디 만들기 \uD83D\uDE31")
    void create_new_study() {
        Study study = new Study(1);
        assertNotNull(study);

        // 파라미터 -> expected, actual, message 순으로 적는 것이 맞음
        // 테스트의 성공, 실패에 관계없이 메시지에 해당하는 문자열 연산을 수행함
        assertEquals(StudyStatus.DRAFT, study.getStatus(), "스터디를 처음 만들면 상태값이"+ StudyStatus.DRAFT + " 여야 한다.");

        // 마지막 매개변수로 Supplier<String> 타입의 인스턴스를 람다 형태로 제공
        // 복잡한 메시지 생성해야 하는 경우 사용하면 실패한 경우에만 해당 메시지를 만들게 할수 있음
        // 테스트가 실패할 경우 메시지에 해당하는 문자열 연산을 수행함
        // 문자열 연산의 비용이 걱정될 수준의 메시지인 경우 람다 표현식을 사용하는 것이 성능상 조금더 유리함
        assertEquals(StudyStatus.DRAFT, study.getStatus(), () -> "스터디를 처음 만들면 상태값이" + StudyStatus.DRAFT + " 여야 한다.");

        assertTrue(study.getLimit() > 0, "스터디 최대 참석 가능 인원은 0보다 커야 한다.");

        //exception 발생시 확인
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Study(-10));
        String message = exception.getMessage();
        assertEquals(message, "limit은 0보다 커야 한다.", exception.getMessage());

        //timeout 확인
        //코드 블럭이 모두 실행된 이후 시간 비교.. 코드가 오래 걸리면 그 만큼 오랜 시간이 걸림
        assertTimeout(Duration.ofMillis(100), () -> {
            new Study(10);
            Thread.sleep(300);
        });

        //설정된 시간이 끝나면 테스트가 종료되길 원할 경우
        //테스트가 정해놓은 시간만큼 실행
        //db transaction 관련 테스트 사용시 주의 -> rollback 이 안될 수 있음..
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            new Study(10);
            Thread.sleep(300);
        });

        //assertj 사용
        Study actual = new Study(10);
        assertThat(actual.getLimit()).isGreaterThan(0);
    }

    @Test
    @DisplayName("다시 스터디 만들기 \uD83D\uDE31")
    void create_new_study_again() {

        //앞의 테스트가 실패할 경우 뒤의 테스트를 확인할 수 없음 -> 한 번에 테스트 하는 것이 필요
        //assertAll 사용
        Study study = new Study(1);
        assertAll(
                () -> assertNotNull(study),
                () -> assertEquals(StudyStatus.DRAFT, study.getStatus(), "스터디를 처음 만들면 상태값이"+ StudyStatus.DRAFT + " 여야 한다."),
                () -> assertEquals(StudyStatus.DRAFT, study.getStatus(), () -> "스터디를 처음 만들면 상태값이" + StudyStatus.DRAFT + " 여야 한다."),
                () -> assertTrue(study.getLimit() > 0, "스터디 최대 참석 가능 인원은 0보다 커야 한다.")
        );
    }

}