package kr.com.lkj.javatest;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 테스트 그룹을 만들고 원하는 테스트 그룹만 테스트를 실행할 수 있는 기능.
 *
 * - 테스트 메소드에 태그를 추가할 수 있다.
 * - 하나의 테스트 메소드에 여러 태그를 사용 할 수 있음
 * edit Configuration -> test kind = tag -> test expression -> tag 명
 *
 * 메이븐에서 테스트 필터링 하는 방법 -> pom.xml 확인
 */
class StudyTestTag {

    @Test
    @DisplayName("스터디 만들기 fast")
    @Tag("fast")
    void create_new_Study (){
        Study study = new Study(10);
        assertThat(study.getLimit()).isGreaterThan(0);
    }

    @Test
    @DisplayName("스터디 만들기 slow")
    @Tag("slow")
    void create_new_study_again() {
        System.out.println("create1");
    }
}