package learning.geneticalgorithm.cargohaul.domain.service;

import java.util.ArrayList;
import java.util.List;
import learning.geneticalgorithm.cargohaul.domain.entity.Haul;

public class PopulationService {

    final IndividualService individualService;

    public PopulationService(IndividualService individualService) {
        this.individualService = individualService;
    }

    public List<Haul> generateFirstPopulation(int populationSize) {
        List<Haul> population = new ArrayList<>();
        while (population.size() < populationSize) {
            population.add(individualService.generateRandomIndividual());
        }
        return population;
    }

}
