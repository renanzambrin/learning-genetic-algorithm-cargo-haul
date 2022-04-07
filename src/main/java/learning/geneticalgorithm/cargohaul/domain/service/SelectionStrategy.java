package learning.geneticalgorithm.cargohaul.domain.service;

import java.util.List;
import learning.geneticalgorithm.cargohaul.domain.entity.Haul;

public interface SelectionStrategy {

    List<Haul> process(List<Haul> population);

}
