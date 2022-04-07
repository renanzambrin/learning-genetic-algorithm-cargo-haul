package learning.geneticalgorithm.cargohaul.infrastructure.strategy.selection;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import learning.geneticalgorithm.cargohaul.domain.entity.Haul;
import learning.geneticalgorithm.cargohaul.domain.service.SelectionStrategy;

public class TournamentSelectionStrategy implements SelectionStrategy {

    static final SecureRandom RANDOM = new SecureRandom();

    @Override
    public List<Haul> process(List<Haul> population) {
        int winnersPoolSize = population.size() / 4;
        List<Haul> winners = new ArrayList<>();
        while (winners.size() < winnersPoolSize) {
            Haul firstContender = population.remove(RANDOM.nextInt(population.size()));
            Haul secondContender = population.remove(RANDOM.nextInt(population.size()));
            if (firstContender.getFitness().compareTo(secondContender.getFitness()) > 0) {
                winners.add(firstContender);
            } else {
                winners.add(secondContender);
            }
        }
        return winners;
    }

}
