package learning.geneticalgorithm.cargohaul.domain.entity;

import java.math.BigDecimal;
import learning.geneticalgorithm.cargohaul.domain.entity.resolver.BoxParameterResolver;
import learning.geneticalgorithm.cargohaul.domain.exception.BoxHeightCanNotBeNullOrNegativeException;
import learning.geneticalgorithm.cargohaul.domain.exception.BoxLengthCanNotBeNullOrNegativeException;
import learning.geneticalgorithm.cargohaul.domain.exception.BoxPositionCanNotBeNullOrNegativeException;
import learning.geneticalgorithm.cargohaul.domain.exception.BoxValueCanNotBeNullOrNegativeException;
import learning.geneticalgorithm.cargohaul.domain.exception.BoxWeightCanNotBeNullOrNegativeException;
import learning.geneticalgorithm.cargohaul.domain.exception.BoxWidthCanNotBeNullOrNegativeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static java.math.BigDecimal.ZERO;

class BoxTest {

    static final BigDecimal MINUS_ONE = BigDecimal.valueOf(-1);
    static final int INT_ZERO = 0;
    static final int INT_MINUS_ONE = -1;

    @Test
    void givenBoxWithValidValues_WhenNew_ThenNoException() {
        Box result = Assertions.assertDoesNotThrow(() -> new Box(INT_ZERO, ZERO, ZERO, ZERO, ZERO, ZERO));
        Assertions.assertNotNull(result);
        Assertions.assertEquals(INT_ZERO, result.position());
        Assertions.assertEquals(ZERO, result.width());
        Assertions.assertEquals(ZERO, result.height());
        Assertions.assertEquals(ZERO, result.length());
        Assertions.assertEquals(ZERO, result.weight());
        Assertions.assertEquals(ZERO, result.cost());
    }

    @Test
    void givenBoxWithNegativeValue_WhenNew_ThenExceptionIsThrowForEachAttribute() {
        Assertions.assertThrows(BoxPositionCanNotBeNullOrNegativeException.class,
                () -> new Box(INT_MINUS_ONE, ZERO, ZERO, ZERO, ZERO, ZERO));
        Assertions.assertThrows(BoxPositionCanNotBeNullOrNegativeException.class,
                () -> new Box(null, ZERO, ZERO, ZERO, ZERO, ZERO));
        Assertions.assertThrows(BoxWidthCanNotBeNullOrNegativeException.class,
                () -> new Box(INT_ZERO, MINUS_ONE, ZERO, ZERO, ZERO, ZERO));
        Assertions.assertThrows(BoxWidthCanNotBeNullOrNegativeException.class,
                () -> new Box(INT_ZERO, null, ZERO, ZERO, ZERO, ZERO));
        Assertions.assertThrows(BoxHeightCanNotBeNullOrNegativeException.class,
                () -> new Box(INT_ZERO, ZERO, MINUS_ONE, ZERO, ZERO, ZERO));
        Assertions.assertThrows(BoxHeightCanNotBeNullOrNegativeException.class,
                () -> new Box(INT_ZERO, ZERO, null, ZERO, ZERO, ZERO));
        Assertions.assertThrows(BoxLengthCanNotBeNullOrNegativeException.class,
                () -> new Box(INT_ZERO, ZERO, ZERO, MINUS_ONE, ZERO, ZERO));
        Assertions.assertThrows(BoxLengthCanNotBeNullOrNegativeException.class,
                () -> new Box(INT_ZERO, ZERO, ZERO, null, ZERO, ZERO));
        Assertions.assertThrows(BoxWeightCanNotBeNullOrNegativeException.class,
                () -> new Box(INT_ZERO, ZERO, ZERO, ZERO, MINUS_ONE, ZERO));
        Assertions.assertThrows(BoxWeightCanNotBeNullOrNegativeException.class,
                () -> new Box(INT_ZERO, ZERO, ZERO, ZERO, null, ZERO));
        Assertions.assertThrows(BoxValueCanNotBeNullOrNegativeException.class,
                () -> new Box(INT_ZERO, ZERO, ZERO, ZERO, ZERO, MINUS_ONE));
        Assertions.assertThrows(BoxValueCanNotBeNullOrNegativeException.class,
                () -> new Box(INT_ZERO, ZERO, ZERO, ZERO, ZERO, null));
    }

    @Test
    @ExtendWith(BoxParameterResolver.class)
    void givenBox_WhenGetVolume_ThenReturnBoxVolume(Box box) {
        BigDecimal volume = box.width().multiply(box.height()).multiply(box.length());
        Assertions.assertEquals(volume, box.getVolume());
    }

}
