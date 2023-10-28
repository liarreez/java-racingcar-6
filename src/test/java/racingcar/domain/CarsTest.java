package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @Test
    @DisplayName("자동차 이름은 쉼표(,)로 구분하여 리스트에 저장하는지 테스트")
    public void testCarNamesAreParsedAndStore() {
        Cars cars = new Cars("tiger,eagle,bear");

        List<String> carNames = new ArrayList<>();
        for (Car car : cars) {
            carNames.add(car.getName());
        }
        List<String> expectedList = Arrays.asList("tiger", "eagle", "bear");

        Assertions.assertThat(carNames).isEqualTo(expectedList);
    }

    @Test
    @DisplayName("입력값 중 6글자 이상의 이름 포함 시 에러 발생 테스트")
    public void testInputValueContainsNameLengthOverThanOrEqualSix() {
        String inputValue = "tiger,eagle,leopard";

        assertThrows(IllegalArgumentException.class, () -> new Cars(inputValue));
    }

    @Test
    @DisplayName("가장 많이 이동한 자동차를 우승자로 반환하는지 테스트")
    public void testMostMovedCarIsWinner() {
        Cars cars = new Cars("tiger,eagle,bear");

        int drivingSkill = 3;
        for (Car car : cars) {
            car.move(drivingSkill++);
        }

        drivingSkill = 2;
        for (Car car : cars) {
            car.move(drivingSkill++);
        }

        Assertions.assertThat(cars.getWinnersName()).isEqualTo(Arrays.asList("bear"));
    }
}