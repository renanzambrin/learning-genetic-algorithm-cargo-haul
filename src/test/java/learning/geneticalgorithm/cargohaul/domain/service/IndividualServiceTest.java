package learning.geneticalgorithm.cargohaul.domain.service;

import learning.geneticalgorithm.cargohaul.domain.entity.Box;
import learning.geneticalgorithm.cargohaul.domain.entity.Haul;
import learning.geneticalgorithm.cargohaul.domain.entity.resolver.BoxParameterResolver;
import learning.geneticalgorithm.cargohaul.domain.repository.BoxRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

class IndividualServiceTest {

    IndividualService individualService;
    BoxRepository boxRepository;

    @BeforeEach
    void setUp() {
        boxRepository = Mockito.mock(BoxRepository.class);
        individualService = Mockito.spy(new IndividualService(boxRepository));
    }

    @Test
    @ExtendWith(BoxParameterResolver.class)
    void givenOneBoxExistsAndBoxesAmountIsOne_WhenGenerateRandomIndividual_ThenGetHaul(Box box) {
        Mockito.doReturn(1).when(boxRepository).getAmount();
        Mockito.doReturn(box).when(boxRepository).getBoxAt(ArgumentMatchers.anyInt());
        Mockito.doReturn(1).when(individualService).getRandomBoxAmount();
        Haul haul = individualService.generateRandomIndividual();
        Assertions.assertNotNull(haul);
        Assertions.assertNotNull(haul.getCargo());
        Assertions.assertEquals(1, haul.getCargo().size());
        Assertions.assertEquals(box.weight(), haul.getWeight());
        Assertions.assertEquals(box.getVolume(), haul.getVolume());
        Assertions.assertEquals(box.cost(), haul.getCost());
    }

    @Test
    void givenBoxRepositoryAmountIsTen_WhenGetRandomBoxAmount_ThenReturnNumberMinorThanTen() {
        Mockito.doReturn(10).when(boxRepository).getAmount();
        Assertions.assertTrue(individualService.getRandomBoxAmount() <= 10);
    }

}
