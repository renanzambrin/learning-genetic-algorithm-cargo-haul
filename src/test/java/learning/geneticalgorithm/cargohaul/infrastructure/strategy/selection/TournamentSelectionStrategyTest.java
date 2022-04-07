package learning.geneticalgorithm.cargohaul.infrastructure.strategy.selection;

import java.math.BigDecimal;
import java.util.List;
import learning.geneticalgorithm.cargohaul.domain.entity.Haul;
import learning.geneticalgorithm.cargohaul.domain.entity.resolver.HaulPopulationParameterResolver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

class TournamentSelectionStrategyTest {

    @Test
    @ExtendWith(HaulPopulationParameterResolver.class)
    void givenPopulation_WhenProcess_ThenReturnWinnersOnly(List<Haul> population) {
        int populationSize = population.size();
        TournamentSelectionStrategy strategy = new TournamentSelectionStrategy();
        population.forEach(individual -> individual.setFitness(BigDecimal.ZERO));
        List<Haul> winners = Assertions.assertDoesNotThrow(() -> strategy.process(population));
        Assertions.assertNotNull(winners);
        Assertions.assertEquals(populationSize / 4, winners.size());
    }

}

