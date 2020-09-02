package kr.com.lkj.javatest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StudyTestCustomTag {

    @FastTest
    @DisplayName("스터디 만들기 fast")
    void create_new_Study (){
        Study study = new Study(10);
        assertThat(study.getLimit()).isGreaterThan(0);
    }

    @SlowTest
    @DisplayName("스터디 만들기 slow")
    void create_new_study_again() {
        System.out.println("create1");
    }
}
