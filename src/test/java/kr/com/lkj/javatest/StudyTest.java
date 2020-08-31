package kr.com.lkj.javatest;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @DisplayNameGeneration
 * Method, Class 레퍼런스를 사용해서 테스트 이름을 표기하는 방법 설정.
 * 기본 구현체로 ReplaceUnderscores 제공
 */
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)   //underScore -> 공백
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

    /**
     * @DisplayName
     * 어떤 테스트인지 테스트 이름을 보다 쉽게 표현할 수 있는 방법을 제공하는 애노테이션.
     * @DisplayNameGeneration 보다 우선 순위가 높다.
     * 각각의 테스트 이름을 정해서 실행할 수 있어서 선호도 높음
     * 함수명으로 테스트의 목적을 모두 설명하려면 함수명이 복잡해지고 길어짐...
     */
    @Test
    @DisplayName("스터디 만들기 \uD83D\uDE31")
    void create_new_study() {
        Study study = new Study();
        assertNotNull(study);
        System.out.println("create");
    }

    @Test
    @DisplayName("스터디 다시 만들기")
    void create_new_study_again() {
        System.out.println("create1");
    }
}