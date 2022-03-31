package learning.geneticalgorithm.cargohaul.domain.entity;

import java.math.BigDecimal;
import learning.geneticalgorithm.cargohaul.domain.exception.VanHeightCanNotBeNullOrNegativeException;
import learning.geneticalgorithm.cargohaul.domain.exception.VanLengthCanNotBeNullOrNegativeException;
import learning.geneticalgorithm.cargohaul.domain.exception.VanMaxWeightCanNotBeNullOrNegativeException;
import learning.geneticalgorithm.cargohaul.domain.exception.VanWidthCanNotBeNullOrNegativeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static java.math.BigDecimal.ZERO;

class VanTest {

    private static final BigDecimal MINUS_ONE = BigDecimal.valueOf(-1);

    @Test
    void givenVanWithValidValues_WhenNew_ThenNoException() {
        Van result = Assertions.assertDoesNotThrow(() -> new Van(ZERO, ZERO, ZERO, ZERO));
        Assertions.assertNotNull(result);
        Assertions.assertEquals(ZERO, result.width());
        Assertions.assertEquals(ZERO, result.height());
        Assertions.assertEquals(ZERO, result.length());
        Assertions.assertEquals(ZERO, result.maxWeight());
    }

    @Test
    void givenVanWithNegativeValue_WhenNew_ThenExceptionIsThrowForEachAttribute() {
        Assertions.assertThrows(VanWidthCanNotBeNullOrNegativeException.class,
                () -> new Van(MINUS_ONE, ZERO, ZERO, ZERO));
        Assertions.assertThrows(VanWidthCanNotBeNullOrNegativeException.class,
                () -> new Van(null, ZERO, ZERO, ZERO));
        Assertions.assertThrows(VanHeightCanNotBeNullOrNegativeException.class,
                () -> new Van(ZERO, MINUS_ONE, ZERO, ZERO));
        Assertions.assertThrows(VanHeightCanNotBeNullOrNegativeException.class,
                () -> new Van(ZERO, null, ZERO, ZERO));
        Assertions.assertThrows(VanLengthCanNotBeNullOrNegativeException.class,
                () -> new Van(ZERO, ZERO, MINUS_ONE, ZERO));
        Assertions.assertThrows(VanLengthCanNotBeNullOrNegativeException.class,
                () -> new Van(ZERO, ZERO, null, ZERO));
        Assertions.assertThrows(VanMaxWeightCanNotBeNullOrNegativeException.class,
                () -> new Van(ZERO, ZERO, ZERO, MINUS_ONE));
        Assertions.assertThrows(VanMaxWeightCanNotBeNullOrNegativeException.class,
                () -> new Van(ZERO, ZERO, ZERO, null));
    }

}
