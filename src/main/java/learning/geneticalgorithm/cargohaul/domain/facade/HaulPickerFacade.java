package learning.geneticalgorithm.cargohaul.domain.facade;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import learning.geneticalgorithm.cargohaul.domain.entity.Haul;
import learning.geneticalgorithm.cargohaul.domain.entity.Van;
import learning.geneticalgorithm.cargohaul.domain.service.FitnessService;
import learning.geneticalgorithm.cargohaul.domain.service.PopulationService;

public class HaulPickerFacade {

    private static final Logger LOGGER = Logger.getLogger(HaulPickerFacade.class.getName());
    static final int POPULATION_SIZE = 1000;

    final PopulationService populationService;
    final FitnessService fitnessService;

    public HaulPickerFacade(PopulationService populationService, FitnessService fitnessService) {
        this.populationService = populationService;
        this.fitnessService = fitnessService;
    }

    public Haul pickHaulFor(Van van) {
        List<Haul> population = populationService.generateFirstPopulation(POPULATION_SIZE);
        Haul fittest = fitnessService.getFittestFrom(van, population);
        int generation = 0;
        int fittestForGenerations = 0;
        while (fittestForGenerations < 10) {
            LOGGER.log(Level.INFO, """
                                   --------- Generation %d ---------
                                   --- Fittest for generation
                                   Boxes: %d
                                   Weight: %s
                                   Volume: %s
                                   Cost: %s
                                   """.formatted(generation, fittest.getCargo().size(), fittest.getWeight(),
                    fittest.getVolume(), fittest.getCost()));
            population = populationService.generateNextPopulation(population, POPULATION_SIZE - 1);
            population.add(fittest);
            Haul populationFittest = fitnessService.getFittestFrom(van, population);
            if (fittest.equals(populationFittest)) {
                fittestForGenerations++;
            } else {
                fittest = populationFittest;
                fittestForGenerations = 0;
            }
            generation++;
        }
        return fittest;
    }

}
