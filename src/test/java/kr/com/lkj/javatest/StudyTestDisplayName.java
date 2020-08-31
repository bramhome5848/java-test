package kr.com.lkj.javatest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @DisplayNameGeneration
 * Method, Class 레퍼런스를 사용해서 테스트 이름을 표기하는 방법 설정.
 * 기본 구현체로 ReplaceUnderscores 제공
 */
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)   //underScore -> 공백
class StudyTestDisplayName {

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