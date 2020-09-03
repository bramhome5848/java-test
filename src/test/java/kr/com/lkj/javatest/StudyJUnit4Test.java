package kr.com.lkj.javatest;

import org.junit.Before;
import org.junit.Test;

/**
 * junit4 test -> pom.xml exclusion 삭제
 * JUnit 5: JUnit 4 마이그레이션
 * junit-vintage-engine을 의존성으로 추가하면, JUnit 5의 junit-platform으로 JUnit 3과 4로 작성된 테스트를 실행 가능
 * @Rule은 기본적으로 지원하지 않지만, junit-jupiter-migrationsupport 모듈이 제공하는 @EnableRuleMigrationSupport를 사용하면
 * 다음 타입의 Rule을 지원
 * - ExternalResource
 * - Verifier
 * - ExpectedException
 */

//전체 테스트 수행시 junit4 -> Junit Vintage, junit5 -> Junit Jupiter 실행
public class StudyJUnit4Test {

    @Before
    public void before() {
        System.out.println("before");
    }

    @Test
    public void createTest1() {
        System.out.println("test1");
    }

    @Test
    public void createTest2() {
        System.out.println("test2");
    }

}
