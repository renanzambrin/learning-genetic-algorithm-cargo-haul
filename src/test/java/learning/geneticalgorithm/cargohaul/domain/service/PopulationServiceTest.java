package learning.geneticalgorithm.cargohaul.domain.service;

import java.util.List;
import java.util.Random;
import learning.geneticalgorithm.cargohaul.domain.entity.Haul;
import learning.geneticalgorithm.cargohaul.domain.entity.resolver.HaulParameterResolver;
import learning.geneticalgorithm.cargohaul.domain.entity.resolver.HaulPopulationParameterResolver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;

class PopulationServiceTest {

    static final Random RANDOM = new Random();

    PopulationService populationService;
    IndividualService individualService;
    SelectionStrategy selectionStrategy;
    OffspringStrategy offspringStrategy;
    MutationStrategy mutationStrategy;

    @BeforeEach
    void setUp() {
        individualService = Mockito.mock(IndividualService.class);
        selectionStrategy = Mockito.mock(SelectionStrategy.class);
        offspringStrategy = Mockito.mock(OffspringStrategy.class);
        mutationStrategy = Mockito.mock(MutationStrategy.class);
        populationService = Mockito.spy(new PopulationService(individualService, selectionStrategy, offspringStrategy
                , mutationStrategy));
    }

    @Test
    @ExtendWith(HaulParameterResolver.class)
    void givenPopulationSize_WhenGenerateFirstPopulationIsCalled_ReturnPopulationWithSameSize(Haul haul) {
        Mockito.doReturn(haul).when(individualService).generateRandomIndividual();
        int populationSize = RANDOM.nextInt(10);
        List<Haul> population = populationService.generateFirstPopulation(populationSize);
        Assertions.assertEquals(populationSize, population.size());
    }

    @Test
    @ExtendWith(HaulPopulationParameterResolver.class)
    void givenPopulationSize_WhenGenerateNextPopulationIsCalled_ReturnPopulationWithSameSize(List<Haul> population) {
        Mockito.doReturn(population).when(selectionStrategy).process(any());
        Mockito.doReturn(population).when(offspringStrategy).generateOffspringFrom(anyInt(), any());
        Mockito.doReturn(population).when(mutationStrategy).process(any());
        List<Haul> nextPopulation = populationService.generateNextPopulation(population, population.size());
        Assertions.assertEquals(population.size(), nextPopulation.size());
    }

}
