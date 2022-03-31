package learning.geneticalgorithm.cargohaul.domain.facade;

import learning.geneticalgorithm.cargohaul.domain.entity.Box;
import learning.geneticalgorithm.cargohaul.domain.entity.Van;
import learning.geneticalgorithm.cargohaul.domain.entity.resolver.BoxParameterResolver;
import learning.geneticalgorithm.cargohaul.domain.entity.resolver.DefaultVanParameterResolver;
import learning.geneticalgorithm.cargohaul.domain.repository.BoxRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;

class HaulPickerFacadeTest {

    HaulPickerFacade haulPickerFacade;
    BoxRepository boxRepository;

    @BeforeEach
    void setUp() {
        boxRepository = Mockito.mock(BoxRepository.class);
        haulPickerFacade = new HaulPickerFacade(boxRepository);
    }

    @Test
    @ExtendWith({DefaultVanParameterResolver.class, BoxParameterResolver.class})
    void givenOneBoxExists_WhenPickHaulForVan_ThenReturnHaulContainingOneBox(Van van, Box box) {
        haulPickerFacade.pickHaulFor(van);
    }

}
