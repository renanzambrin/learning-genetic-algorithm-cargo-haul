package learning.geneticalgorithm.cargohaul.domain.service;

import java.util.List;
import learning.geneticalgorithm.cargohaul.domain.entity.Haul;

public interface OffspringStrategy {

    List<Haul> generateOffspringFrom(int offspringSize, List<Haul> population);

}
