package learning.geneticalgorithm.cargohaul.domain.entity;

import java.math.BigDecimal;
import learning.geneticalgorithm.cargohaul.domain.entity.resolver.BoxParameterResolver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

class HaulTest {

    @Test
    void givenHaul_WhenNew_ThenShouldHaveAnEmptyCargoAndZeroWeightAndZeroVolumeAndZeroValue() {
        Haul haul = new Haul();
        Assertions.assertNotNull(haul.getCargo());
        Assertions.assertTrue(haul.getCargo().isEmpty());
        Assertions.assertNotNull(haul.getWeight());
        Assertions.assertEquals(BigDecimal.ZERO, haul.getWeight());
        Assertions.assertNotNull(haul.getVolume());
        Assertions.assertEquals(BigDecimal.ZERO, haul.getVolume());
        Assertions.assertNotNull(haul.getCost());
        Assertions.assertEquals(BigDecimal.ZERO, haul.getCost());
    }

    @Test
    @ExtendWith(BoxParameterResolver.class)
    void givenBox_WhenAddedToCargo_ThenHaulCargoShouldBeOneAndAllValuesMatchTheBox(Box box) {
        Haul haul = new Haul();
        haul.addBox(box);
        Assertions.assertFalse(haul.getCargo().isEmpty());
        Assertions.assertEquals(1, haul.getCargo().size());
        Assertions.assertEquals(box.getVolume(), haul.getVolume());
        Assertions.assertEquals(box.weight(), haul.getWeight());
        Assertions.assertEquals(box.cost(), haul.getCost());
    }

    @Test
    @ExtendWith(BoxParameterResolver.class)
    void givenBox_WhenAddedSameBoxTwoTimesCargo_ThenHaulCargoShouldBeOneAndAllValuesMatchTheBox(Box box) {
        Haul haul = new Haul();
        haul.addBox(box);
        haul.addBox(box);
        Assertions.assertFalse(haul.getCargo().isEmpty());
        Assertions.assertEquals(1, haul.getCargo().size());
        Assertions.assertEquals(box.getVolume(), haul.getVolume());
        Assertions.assertEquals(box.weight(), haul.getWeight());
        Assertions.assertEquals(box.cost(), haul.getCost());
    }

}
