package learning.geneticalgorithm.cargohaul.domain.facade;

import java.util.List;
import learning.geneticalgorithm.cargohaul.domain.entity.Haul;
import learning.geneticalgorithm.cargohaul.domain.entity.Van;
import learning.geneticalgorithm.cargohaul.domain.entity.resolver.DefaultVanParameterResolver;
import learning.geneticalgorithm.cargohaul.domain.entity.resolver.HaulParameterResolver;
import learning.geneticalgorithm.cargohaul.domain.service.FitnessService;
import learning.geneticalgorithm.cargohaul.domain.service.PopulationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

class   HaulPickerFacadeTest {

    HaulPickerFacade haulPickerFacade;
    PopulationService populationService;
    FitnessService fitnessService;

    @BeforeEach
    void setUp() {
        populationService = Mockito.mock(PopulationService.class);
        fitnessService = Mockito.mock(FitnessService.class);
        haulPickerFacade = new HaulPickerFacade(populationService, fitnessService);
    }

    @Test
    @ExtendWith({DefaultVanParameterResolver.class, HaulParameterResolver.class})
    void givenHaul_WhenPickHaulForVan_ThenReturnHaulContainingOneBox(Van van, Haul haul) {
        Mockito.doReturn(List.of(haul)).when(populationService).generateFirstPopulation(ArgumentMatchers.anyInt());
        Mockito.doReturn(haul).when(fitnessService).getFittestFrom(ArgumentMatchers.any(), ArgumentMatchers.any());
        Haul result = haulPickerFacade.pickHaulFor(van);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(haul, result);
    }

}
