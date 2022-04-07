package learning.geneticalgorithm.cargohaul.infrastructure.strategy.mutation;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import learning.geneticalgorithm.cargohaul.domain.entity.Box;
import learning.geneticalgorithm.cargohaul.domain.entity.Haul;
import learning.geneticalgorithm.cargohaul.domain.repository.BoxRepository;
import learning.geneticalgorithm.cargohaul.domain.service.MutationStrategy;

public class LowRandomProbabilityMutationStrategy implements MutationStrategy {

    static final Random RANDOM = new SecureRandom();
    static final float MUTATION_PROBABILITY = 0.001f;

    final BoxRepository boxRepository;

    public LowRandomProbabilityMutationStrategy(BoxRepository boxRepository) {
        this.boxRepository = boxRepository;
    }

    @Override
    public List<Haul> process(List<Haul> population) {
        List<Haul> mutated = new ArrayList<>();
        population.parallelStream().forEach(individual -> {
            List<Box> genes = new ArrayList<>(individual.getCargo().stream().toList());
            for (int i = 0; i < boxRepository.getAmount(); i++) {
                if (RANDOM.nextFloat(1) <= MUTATION_PROBABILITY) {
                    Box gene = boxRepository.getBoxAt(i);
                    if (individual.getCargo().contains(gene)) {
                        genes.remove(gene);
                    } else {
                        genes.add(gene);
                    }
                }
            }
            Haul mutatedIndividual = new Haul();
            mutatedIndividual.addAllBoxes(genes);
            mutated.add(mutatedIndividual);
        });
        return mutated;
    }

}
