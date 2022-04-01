package learning.geneticalgorithm.cargohaul.domain.entity;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class Haul implements Measurable {

    private final Set<Box> cargo;
    private BigDecimal weight;
    private BigDecimal volume;
    private BigDecimal cost;
    private BigDecimal fitness;

    public Haul() {
        this.cargo = new HashSet<>();
        this.weight = BigDecimal.ZERO;
        this.volume = BigDecimal.ZERO;
        this.cost = BigDecimal.ZERO;
    }

    public Set<Box> getCargo() {
        return this.cargo;
    }

    public BigDecimal getWeight() {
        return this.weight;
    }

    public BigDecimal getVolume() {
        return this.volume;
    }

    public BigDecimal getCost() {
        return this.cost;
    }

    @Override
    public BigDecimal getFitness() {
        return this.fitness;
    }

    @Override
    public void setFitness(BigDecimal value) {
        this.fitness = value;
    }

    public void addBox(Box box) {
        if (this.cargo.add(box)) {
            this.weight = this.weight.add(box.weight());
            this.volume = this.volume.add(box.getVolume());
            this.cost = this.cost.add(box.cost());
        }
    }

}
