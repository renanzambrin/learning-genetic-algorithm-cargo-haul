package learning.geneticalgorithm.cargohaul.infrastructure.strategy.mutation;

import java.math.BigDecimal;
import java.util.List;
import learning.geneticalgorithm.cargohaul.domain.entity.Haul;
import learning.geneticalgorithm.cargohaul.domain.entity.resolver.HaulPopulationParameterResolver;
import learning.geneticalgorithm.cargohaul.domain.repository.BoxRepository;
import learning.geneticalgorithm.cargohaul.infrastructure.repository.InMemoryBoxRepository;
import learning.geneticalgorithm.cargohaul.scenario.BoxFixture;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

class LowRandomProbabilityMutationStrategyTest {

    LowRandomProbabilityMutationStrategy strategy;
    BoxRepository boxRepository;

    @BeforeEach
    void setUp() {
        boxRepository = new InMemoryBoxRepository();
        BoxFixture.generateFixture().forEach(boxRepository::addBox);
        strategy = new LowRandomProbabilityMutationStrategy(boxRepository);
    }

    @Test
    @ExtendWith(HaulPopulationParameterResolver.class)
    void givenPopulation_WhenProcess_ThenReturnWinnersOnly(List<Haul> population) {
        population.forEach(individual -> individual.setFitness(BigDecimal.ZERO));
        List<Haul> mutatedPopulation = Assertions.assertDoesNotThrow(() -> strategy.process(population));
        Assertions.assertNotNull(mutatedPopulation);
        Assertions.assertEquals(population.size(), mutatedPopulation.size());
    }

}
