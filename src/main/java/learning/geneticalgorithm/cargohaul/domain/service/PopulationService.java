package learning.geneticalgorithm.cargohaul.domain.service;

import java.util.ArrayList;
import java.util.List;
import learning.geneticalgorithm.cargohaul.domain.entity.Haul;

public class PopulationService {

    final IndividualService individualService;
    final SelectionStrategy selectionStrategy;
    final OffspringStrategy offspringStrategy;
    final MutationStrategy mutationStrategy;

    public PopulationService(IndividualService individualService,
                             SelectionStrategy selectionStrategy,
                             OffspringStrategy offspringStrategy,
                             MutationStrategy mutationStrategy) {
        this.individualService = individualService;
        this.selectionStrategy = selectionStrategy;
        this.offspringStrategy = offspringStrategy;
        this.mutationStrategy = mutationStrategy;
    }

    public List<Haul> generateFirstPopulation(int populationSize) {
        List<Haul> population = new ArrayList<>();
        while (population.size() < populationSize) {
            population.add(individualService.generateRandomIndividual());
        }
        return population;
    }

    public List<Haul> generateNextPopulation(List<Haul> population, int populationSize) {
        population = selectionStrategy.process(population);
        population = offspringStrategy.generateOffspringFrom(populationSize - 1, population);
        population = mutationStrategy.process(population);
        return population;
    }

}
