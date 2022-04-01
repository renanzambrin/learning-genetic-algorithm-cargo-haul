package learning.geneticalgorithm.cargohaul.domain.facade;

import java.util.List;
import learning.geneticalgorithm.cargohaul.domain.entity.Haul;
import learning.geneticalgorithm.cargohaul.domain.entity.Van;
import learning.geneticalgorithm.cargohaul.domain.service.FitnessService;
import learning.geneticalgorithm.cargohaul.domain.service.PopulationService;

public class HaulPickerFacade {

    static final int POPULATION_SIZE = 10000;

    final PopulationService populationService;
    final FitnessService fitnessService;

    public HaulPickerFacade(PopulationService populationService, FitnessService fitnessService) {
        this.populationService = populationService;
        this.fitnessService = fitnessService;
    }

    public Haul pickHaulFor(Van van) {
        List<Haul> population = populationService.generateFirstPopulation(POPULATION_SIZE);
        return fitnessService.getFittestFrom(van, population);
    }

}
