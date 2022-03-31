package learning.geneticalgorithm.cargohaul.domain.facade;

import learning.geneticalgorithm.cargohaul.domain.entity.Haul;
import learning.geneticalgorithm.cargohaul.domain.entity.Van;
import learning.geneticalgorithm.cargohaul.domain.repository.BoxRepository;

public class HaulPickerFacade {

    final BoxRepository boxRepository;

    public HaulPickerFacade(BoxRepository boxRepository) {
        this.boxRepository = boxRepository;
    }

    public Haul pickHaulFor(Van van) {
        return null;
    }

}
