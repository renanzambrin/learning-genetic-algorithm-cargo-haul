package learning.geneticalgorithm.cargohaul.domain.entity;

import java.math.BigDecimal;

public interface Measurable {

    BigDecimal getFitness();

    void setFitness(BigDecimal value);

}
