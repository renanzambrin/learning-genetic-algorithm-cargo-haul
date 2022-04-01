package learning.geneticalgorithm.cargohaul.domain.service;

import java.math.BigDecimal;
import java.util.List;
import learning.geneticalgorithm.cargohaul.domain.entity.Haul;
import learning.geneticalgorithm.cargohaul.domain.entity.Van;

public class FitnessService {

    public Haul getFittestFrom(Van van, List<Haul> population) {
        Haul fittest = population.get(0);
        for (Haul haul : population) {
            calculateFitnessFor(van, haul);
            if (fittest.getFitness().compareTo(haul.getFitness()) < 0) {
                fittest = haul;
            }
        }
        return fittest;
    }

    public void calculateFitnessFor(Van van, Haul haul) {
        if (haul.getVolume().compareTo(van.getVolume()) > 0 ||
                haul.getWeight().compareTo(van.maxWeight()) > 0) {
            haul.setFitness(BigDecimal.ZERO);
        } else {
            haul.setFitness(haul.getCost());
        }
    }

}
