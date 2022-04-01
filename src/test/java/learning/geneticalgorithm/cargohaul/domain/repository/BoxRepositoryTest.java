package learning.geneticalgorithm.cargohaul.domain.repository;

import java.util.List;
import learning.geneticalgorithm.cargohaul.domain.entity.Box;
import learning.geneticalgorithm.cargohaul.domain.entity.resolver.BoxParameterResolver;
import learning.geneticalgorithm.cargohaul.domain.exception.BoxCanNotBeNullException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

public abstract class BoxRepositoryTest {

    public abstract BoxRepository getBoxRepository();

    @Test
    void givenBoxRepository_WhenNew_ThenAmountIsZeroAndGetBoxesIsEmpty() {
        Assertions.assertNotNull(getBoxRepository().getBoxes());
        Assertions.assertEquals(0, getBoxRepository().getBoxes().size());
        Assertions.assertEquals(0, getBoxRepository().getAmount());
    }

    @Test
    @ExtendWith(BoxParameterResolver.class)
    void givenNewBoxRepository_WhenAddOneBox_ThenAmountIsOneAndGetBoxesHasBoxAndBoxIsSame(Box box) {
        Assertions.assertDoesNotThrow(() -> getBoxRepository().addBox(box));
        Assertions.assertNotNull(getBoxRepository().getBoxes());
        Assertions.assertEquals(1, getBoxRepository().getBoxes().size());
        Assertions.assertEquals(1, getBoxRepository().getAmount());
        Assertions.assertEquals(box, getBoxRepository().getBoxAt(0));
        Assertions.assertEquals(box, getBoxRepository().getBoxes().get(0));
    }

    @Test
    void givenNullParameter_WhenAddBoxIsCalled_ThenThrowException() {
        BoxRepository boxRepository = getBoxRepository();
        Assertions.assertThrows(BoxCanNotBeNullException.class, () -> boxRepository.addBox(null));
    }

    @Test
    @ExtendWith(BoxParameterResolver.class)
    void givenRepositoryWithOneBox_WhenGetBoxes_ThenRemoveFromResultShouldNotRemoveFromRepository(Box box) {
        getBoxRepository().addBox(box);

        Assertions.assertNotNull(getBoxRepository().getBoxes());
        Assertions.assertEquals(1, getBoxRepository().getBoxes().size());
        Assertions.assertEquals(1, getBoxRepository().getAmount());

        List<Box> result = getBoxRepository().getBoxes();
        Assertions.assertEquals(1, result.size());
        result.remove(0);
        Assertions.assertEquals(0, result.size());

        Assertions.assertNotNull(getBoxRepository().getBoxes());
        Assertions.assertEquals(1, getBoxRepository().getBoxes().size());
        Assertions.assertEquals(1, getBoxRepository().getAmount());
        Assertions.assertEquals(box, getBoxRepository().getBoxAt(0));
        Assertions.assertEquals(box, getBoxRepository().getBoxes().get(0));
    }

}
