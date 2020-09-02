package kr.com.lkj.javatest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit은 테스트 메소드 마다 테스트 클래스의 인스턴스를 새로 만들게 됨
 * - 이것이 기본 전략.
 * - 테스트 메소드를 독립적으로 실행하여 예상치 못한 부작용을 방지하기 위함
 * - 이 전략을 JUnit 5에서 변경할 수 있음
 *
 * @TestInstance(Lifecycle.PER_CLASS)
 * - 테스트 클래스당 인스턴스를 하나만 만들어 사용
 * - 경우에 따라, 테스트 간에 공유하는 모든 상태를 @BeforeEach 또는 @AfterEach 에서 초기화 할 필요가 있음
 * - @BeforeAll, @AfterAll 을 인스턴스 메소드 또는 인터페이스에 정의한 default 메소드로 정의할 수 있음
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class StudyTestInstance {

    int value = 1;

    //클래스 instance 를 한 번만 만들기 때문에 static 선언 없이 사용 가능 -> instance method 로 선언 가능
    //Interface 로 정의된 테스트는 default 메소드로 정의할 수도 있음
    @BeforeAll
    void beforeAll() {
        System.out.println("before all");
    }

    @AfterAll
    void afterAll() {
        System.out.println("after all");
    }

    @Test
    void test1() {
        System.out.println(value++);
        System.out.println(this);
    }

    @Test
    void test2() {
        System.out.println(value++);
        System.out.println(this);
    }

    @Test
    void test3() {
        System.out.println(value++);
        System.out.println(this);
    }
}