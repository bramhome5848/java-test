package kr.com.lkj.javatest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;
import org.springframework.test.context.junit.jupiter.EnabledIf;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

/**
 * 특정한 조건을 만족하는 경우에 테스트를 실행하는 방법.
 * assumeTrue(조건)
 * assumingThat(조건, 테스트)
 * Enabled___ 와 @Disabled___
 */
class StudyTestAssume {

    @Test
    @DisplayName("스터디 만들기1 \uD83D\uDE31")
    void test1() {
        //환경변수로 구분, 만족할 경우 아래의 테스트 수행
        String test_env = System.getenv("USER");

        assumeTrue("LeeKyungJin".equalsIgnoreCase(test_env));

        Study study = new Study(10);
        assertThat(study.getLimit()).isGreaterThan(0);
    }

    @Test
    @DisplayName("스터디 만들기2 \uD83D\uDE31")
    void test2() {

        String test_env = System.getenv("USER");

        //조건을 만족하면 함수 블록 실행
        assumingThat("LeeKyungJin".equalsIgnoreCase(test_env),() -> {
            Study actual = new Study(10);
            assertThat(actual.getLimit()).isGreaterThan(0);
        });

        assumingThat("LeeKyungJin".equalsIgnoreCase(test_env),() -> {
            Study actual = new Study(10);
            assertThat(actual.getLimit()).isGreaterThan(0);
        });
    }

    @Test
    @DisplayName("스터디 만들기3 \uD83D\uDE31")
    @EnabledOnOs({OS.MAC, OS.LINUX})    //MAC, LINUX 인 경우 실행
    @EnabledOnJre({JRE.JAVA_8, JRE.JAVA_9, JRE.JAVA_10, JRE.JAVA_11})    //java 버전
    @EnabledIfEnvironmentVariable(named = "USER", matches = "LeeKyungJin")  //환경변수
    void test3() {
        System.out.println("create3");
    }

    @Test
    @DisplayName("스터디 만들기4 \uD83D\uDE31")
    @DisabledOnOs(OS.MAC)    //MAC인 경우 실행 X
    @EnabledOnJre(JRE.OTHER)
    void test4() {
        System.out.println("create4");
    }
}