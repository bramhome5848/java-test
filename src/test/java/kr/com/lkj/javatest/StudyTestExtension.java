package kr.com.lkj.javatest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit 4의 확장 모델은 @RunWith(Runner), TestRule, MethodRule.
 * JUnit 5의 확장 모델은 단 하나, Extension.
 * 확장팩 등록 방법
 * - 선언적인 등록 @ExtendWith
 * - 프로그래밍 등록 @RegisterExtension
 * - 자동 등록 자바 ​ServiceLoader​ 이용
 *
 * 확장팩 만드는 방법
 * - 테스트 실행 조건
 * - 테스트 인스턴스 팩토리
 * - 테스트 인스턴스 후-처리기
 * - 테스트 매개변수 리졸버
 * - 테스트 라이프사이클 콜백
 * - 예외처리
 */
//@ExtendWith(FindSlowTestExtension.class)    //선언적 등록 -> 커스텀 불가능, 생성자를 통해 정보 주입시 사용할 수 없음
class StudyTestExtension {

    int value = 1;

    //필드 주입
    @RegisterExtension
    static FindSlowTestExtension findSlowTestExtension = new FindSlowTestExtension(1000L);

    @Test
    void test_create1() throws InterruptedException {
        Thread.sleep(1005L);
        System.out.println(value++);
        System.out.println(this);
    }

    @Test
    void test_create2() {
        System.out.println(value++);
        System.out.println(this);
    }

    @Test
    void test_create3() {
        System.out.println(value++);
        System.out.println(this);
    }
}