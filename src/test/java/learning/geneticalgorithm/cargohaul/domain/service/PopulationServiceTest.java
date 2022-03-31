package learning.geneticalgorithm.cargohaul.domain.service;

import java.util.List;
import java.util.Random;
import learning.geneticalgorithm.cargohaul.domain.entity.Haul;
import learning.geneticalgorithm.cargohaul.domain.entity.resolver.HaulParameterResolver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;

class PopulationServiceTest {

    static final Random RANDOM = new Random();

    PopulationService populationService;
    IndividualService individualService;

    @BeforeEach
    void setUp() {
        individualService = Mockito.mock(IndividualService.class);
        populationService = Mockito.spy(new PopulationService(individualService));
    }

    @Test
    @ExtendWith(HaulParameterResolver.class)
    void givenPopulationSize_WhenGenerateFirstPopulationIsCalled_ReturnPopulationWIthSameSize(Haul haul) {
        Mockito.doReturn(haul).when(individualService).generateRandomIndividual();
        int populationSize = RANDOM.nextInt(10);
        List<Haul> population = populationService.generateFirstPopulation(populationSize);
        Assertions.assertEquals(populationSize, population.size());
    }

}
