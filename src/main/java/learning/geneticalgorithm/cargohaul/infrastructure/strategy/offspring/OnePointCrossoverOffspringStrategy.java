package learning.geneticalgorithm.cargohaul.infrastructure.strategy.offspring;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import learning.geneticalgorithm.cargohaul.domain.entity.Box;
import learning.geneticalgorithm.cargohaul.domain.entity.Haul;
import learning.geneticalgorithm.cargohaul.domain.service.OffspringStrategy;

public class OnePointCrossoverOffspringStrategy implements OffspringStrategy {

    static final SecureRandom RANDOM = new SecureRandom();

    @Override
    public List<Haul> generateOffspringFrom(int offspringSize, List<Haul> parents) {
        List<Haul> offspring = new ArrayList<>();
        while (offspring.size() < offspringSize) {
            Haul firstParent = parents.get(RANDOM.nextInt(parents.size()));
            Haul secondParent = parents.get(RANDOM.nextInt(parents.size()));

            List<Box> firstParentGenesFirstPart = new ArrayList<>();
            List<Box> firstParentGenesSecondPart = new ArrayList<>();
            List<Box> secondParentGenesFirstPart = new ArrayList<>();
            List<Box> secondParentGenesSecondPart = new ArrayList<>();

            splitGenesFor(firstParent, firstParentGenesFirstPart, firstParentGenesSecondPart);
            splitGenesFor(secondParent, secondParentGenesFirstPart, secondParentGenesSecondPart);

            offspring.add(generateOffspring(firstParentGenesFirstPart, secondParentGenesSecondPart));
            offspring.add(generateOffspring(secondParentGenesFirstPart, firstParentGenesSecondPart));
        }
        return offspring;
    }

    static void splitGenesFor(Haul parent, List<Box> firstPart, List<Box> secondPart) {
        List<Box> genes = parent.getCargo().stream().toList();
        for (Box gene : genes) {
            if (gene.position() < genes.size() / 2) {
                secondPart.add(gene);
            } else {
                firstPart.add(gene);
            }
        }
    }

    static Haul generateOffspring(List<Box> firstPart, List<Box> secondPart) {
        Haul offspring = new Haul();
        offspring.addAllBoxes(firstPart);
        offspring.addAllBoxes(secondPart);
        return offspring;
    }

}
