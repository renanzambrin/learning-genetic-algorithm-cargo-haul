package learning.geneticalgorithm.cargohaul.infrastructure.strategy.offspring;

import java.math.BigDecimal;
import java.util.List;
import learning.geneticalgorithm.cargohaul.domain.entity.Haul;
import learning.geneticalgorithm.cargohaul.domain.entity.resolver.HaulPopulationParameterResolver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

class OnePointCrossoverOffspringStrategyTest {

    @Test
    @ExtendWith(HaulPopulationParameterResolver.class)
    void givenPopulation_WhenProcess_ThenReturnWinnersOnly(List<Haul> parents) {
        OnePointCrossoverOffspringStrategy strategy = new OnePointCrossoverOffspringStrategy();
        parents.forEach(individual -> individual.setFitness(BigDecimal.ZERO));
        int offspringSize = 400;
        List<Haul> offspring = Assertions.assertDoesNotThrow(() -> strategy.generateOffspringFrom(offspringSize,
                parents));
        Assertions.assertNotNull(offspring);
        Assertions.assertEquals(offspringSize, offspring.size());
    }

}
