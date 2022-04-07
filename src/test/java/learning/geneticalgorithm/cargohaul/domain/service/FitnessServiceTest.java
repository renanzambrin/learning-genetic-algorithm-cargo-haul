package learning.geneticalgorithm.cargohaul.domain.service;

import java.util.List;
import learning.geneticalgorithm.cargohaul.domain.entity.Box;
import learning.geneticalgorithm.cargohaul.domain.entity.Haul;
import learning.geneticalgorithm.cargohaul.domain.entity.Van;
import learning.geneticalgorithm.cargohaul.domain.entity.resolver.DefaultVanParameterResolver;
import learning.geneticalgorithm.cargohaul.domain.entity.resolver.HaulParameterResolver;
import learning.geneticalgorithm.cargohaul.domain.entity.resolver.HaulPopulationParameterResolver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;

import static java.math.BigDecimal.TEN;
import static java.math.BigDecimal.ZERO;

class FitnessServiceTest {

    FitnessService fitnessService;

    @BeforeEach
    void setUp() {
        fitnessService = Mockito.spy(new FitnessService());
    }

    @Test
    @ExtendWith({DefaultVanParameterResolver.class, HaulPopulationParameterResolver.class})
    void givenPopulation_WhenGetFittest_ThenReturnHaul(Van van, List<Haul> population) {
        Haul result = fitnessService.getFittestFrom(van, population);
        Assertions.assertNotNull(result);
    }

    @Test
    @ExtendWith({DefaultVanParameterResolver.class, HaulParameterResolver.class})
    void givenHaulAndVan_WhenCalculateFitnessFor_ThenSetFitnessInHaul(Van van, Haul haul) {
        fitnessService.calculateFitnessFor(van, haul);
        Assertions.assertNotNull(haul.getFitness());
    }

    @Test
    @ExtendWith({DefaultVanParameterResolver.class, HaulParameterResolver.class})
    void givenHaulHasBiggerVolumeThanVan_WhenCalculateFitnessFor_ThenFitnessIsZero(Van van, Haul haul) {
        Box box = new Box(haul.getCargo().size() + 1, TEN, TEN, TEN, TEN, TEN);
        haul.addBox(box);
        fitnessService.calculateFitnessFor(van, haul);
        Assertions.assertNotNull(haul.getFitness());
        Assertions.assertTrue(haul.getVolume().compareTo(van.getVolume()) > 0);
        Assertions.assertEquals(ZERO, haul.getFitness());
    }

}
