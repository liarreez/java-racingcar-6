package racingcar.validator;

import racingcar.constants.ValidatorConstant;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class CarValidatorTest {
    Validator validator = new CarValidator();

    @ParameterizedTest
    @DisplayName("공백 및 널값 자동차 이름 입력 시 에러 발생 테스트")
    @NullAndEmptySource
    @ValueSource(strings = {" ", "   ", "\t", "\n"})
    void testCarNameIsNullOrEmpty(String name) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> validator.validate(name));
    }

    @Test
    @DisplayName("최대 길이 이상의 자동차 이름 입력 시 에러 발생 테스트")
    void testCarNameLengthOverThanMaxLength() {
        String name = "a".repeat(ValidatorConstant.MAX_CAR_NAME_LENGTH + 1);
        Assertions.assertThrows(IllegalArgumentException.class, () -> validator.validate(name));
    }
}
