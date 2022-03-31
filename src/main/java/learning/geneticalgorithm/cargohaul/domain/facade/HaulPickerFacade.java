package learning.geneticalgorithm.cargohaul.domain.facade;

import java.util.List;
import learning.geneticalgorithm.cargohaul.domain.entity.Haul;
import learning.geneticalgorithm.cargohaul.domain.entity.Van;
import learning.geneticalgorithm.cargohaul.domain.service.PopulationService;

public class HaulPickerFacade {

    static final int POPULATION_SIZE = 10000;

    final PopulationService populationService;

    public HaulPickerFacade(PopulationService populationService) {
        this.populationService = populationService;
    }

    public Haul pickHaulFor(Van van) {
        List<Haul> population = populationService.generateFirstPopulation(POPULATION_SIZE);
        return population.get(0);
    }

}
