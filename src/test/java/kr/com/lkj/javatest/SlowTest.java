package kr.com.lkj.javatest;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * JUnit 5 애노테이션을 조합하여 커스텀 태그를 만들 수 있음
 */
@Target(ElementType.METHOD)   //해당 어노테이션을 어디에 쓸 수 있는가
@Retention(RetentionPolicy.RUNTIME)     //해당 어노테이션을 사용한 코드가 이 정보를 런타임까지 유지해야함
@Tag("slow")    // Tag, Test -> 새로운 어노테이션을 위한 메타 어노테이션으로 사용
@Test
public @interface SlowTest {
}
