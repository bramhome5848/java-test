package kr.com.lkj.javatest;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 실행할 테스트 메소드는 특정한 순서에 의해 실행되지만 어떻게 그 순서를 정하는지는 분명히 하지 않음. -> 테스트 인스턴스를 테스트 마다 새로 만드는 이유
 * 경우에 따라, 특정 순서대로 테스트를 실행하고 싶을 때테스트 메소드를 원하는 순서에 따라 실행하도록
 * @TestInstance(Lifecycle.PER_CLASS)와 함께 @TestMethodOrder 를 사용, 같이 사용하지 않아도 순서데로 실행
 * @TestMethodOrder
 * - MethodOrderer 구현체를 설정
 * - 기본구현체
 * --- Alphanumeric
 * --- OrderAnnoation
 * --- Random
 */
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)   // OrderAnnotation 을 통해 순서를 정해줌
class StudyTestOrder {

    int value = 1;

    @Order(3)
    @Test
    void test1() {
        System.out.println(value++);
        System.out.println(this);
    }

    @Order(1)
    @Test
    void test2() {
        System.out.println(value++);
        System.out.println(this);
    }

    @Order(2)
    @Test
    void test3() {
        System.out.println(value++);
        System.out.println(this);
    }
}