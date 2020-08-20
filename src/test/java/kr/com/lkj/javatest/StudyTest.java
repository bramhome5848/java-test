package kr.com.lkj.javatest;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StudyTest {

    @Test
    void create() {
        Study study = new Study();
        assertNotNull(study);
        System.out.println("create");
    }

    @Test
    @Disabled   // 전체 테스트 실행시 해당 테스트를 빼고 실행
    void create1() {
        System.out.println("create1");
    }

    @BeforeAll  // 클래스 내의 모든 테스트가 실행되기 전에 반드시 한 번 호출, static 함수 + void 로 선언, default 함수로 가능 하나 경고..
    static void beforeAll() {
        System.out.println("before all");
    }

    @AfterAll   //클래스 내의 모든 테스트가 실행된 후에 반드시 한 번 호출, static 함수 + void 로 선언, default 함수로 가능 하나 경고..
    static void afterAll() {
        System.out.println("after all");
    }

    @BeforeEach //각각의 테스트 실행 이전에 호출, static 함수로 선언 하면 오류..
    void beforeEach() {
        System.out.println("before each");
    }

    @AfterEach  //각각의 테스트 실행 후에 호출, static 함수로 선언 하면 오류..
    void afterEach() {
        System.out.println("after each");
    }
}