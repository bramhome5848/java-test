package kr.com.lkj.javatest;

import net.bytebuddy.implementation.bind.annotation.Empty;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 인자 값들의 소스
 * - @ValueSource
 * - @NullSource, @EmptySource, @NullAndEmptySource
 * - @EnumSource
 * - @MethodSource
 * - @CvsSource
 * - @CvsFileSource
 * - @ArgumentSource
 *
 * 인자 값 타입 변환
 * - 암묵적인 타입 변환
 * --- 레퍼런스​ 참고
 * - 명시적인 타입 변환
 * --- SimpleArgumentConverter 상속 받은 구현체 제공
 * --- @ConvertWith
 *
 * 인자 값 조합
 * - ArgumentsAccessor
 * - 커스텀 Accessor
 * --- ArgumentsAggregator 인터페이스 구현
 * --- @AggregateWith
 */
class StudyTestRepeat2 {

    @DisplayName("스터디 만들기")
    @ParameterizedTest(name = "{index} {displayName} message = {0}")  //파라미터도 참조 가능
    @ValueSource(strings = {"날씨가", "많이", "추워지고", "있네요"})    //파라미터 횟수 만큼 호출
    //@EmptySource    //비어 있는 데이터를 추가
    //@NullSource //null 데이터를 추가
    @NullAndEmptySource //empty + null
    void parameterizedTestFirst(String message) {
        System.out.println(message);
    }

    @DisplayName("스터디 만들기")
    @ParameterizedTest(name = "{index} {displayName} message = {0}")  //파라미터도 참조 가능
    @ValueSource(ints = {10, 20, 40})   //숫자를 Study type으로 변환 위해 (명시적 형변환) SimpleArgumentConverter 상속 받은 구현체
    void parameterizedTestSecond(@ConvertWith(StudyConverter.class) Study study) { //custom한 convert가 어떤 것인지 알려줘야 함
        System.out.println(study.getLimit());
    }

    @DisplayName("스터디 만들기")
    @ParameterizedTest(name = "{index} {displayName} message = {0}")
    @CsvSource({"10, '자바 스터디'", "20, 스프링"})
    void parameterizedTestThird(Integer limit, String name) {   //argument 각각 받아서 만드는 경우
        System.out.println(new Study(limit, name));
    }

    @DisplayName("스터디 만들기")
    @ParameterizedTest(name = "{index} {displayName} message = {0}")
    @CsvSource({"10, '자바 스터디'", "20, 스프링"})
    void parameterizedTestFourth(ArgumentsAccessor argumentsAccessor) { //2개의 argument 하나로 받아 오는 경우 -> ArgumentsAccessor
        Study study = new Study(argumentsAccessor.getInteger(0), argumentsAccessor.getString(1));
        System.out.println(study);
    }

    @DisplayName("스터디 만들기")
    @ParameterizedTest(name = "{index} {displayName} message = {0}")
    @CsvSource({"10, '자바 스터디'", "20, 스프링"})
    void parameterizedTestFifth(@AggregateWith(StudyAggregator.class) Study study) { //2개의 argument 하나로 받아 오는 경우 -> ArgumentsAggregator
        System.out.println(study);
    }



    //하나의 argument 에 적용됨
    static class StudyConverter extends SimpleArgumentConverter {

        @Override
        protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {
            assertEquals(Study.class, targetType, "Can only convert to Study");
            return new Study(Integer.parseInt(source.toString()));
        }
    }

    static class StudyAggregator implements ArgumentsAggregator {

        @Override
        public Object aggregateArguments(ArgumentsAccessor argumentsAccessor, ParameterContext context) throws ArgumentsAggregationException {
            return new Study(argumentsAccessor.getInteger(0), argumentsAccessor.getString(1));
        }
    }
}
