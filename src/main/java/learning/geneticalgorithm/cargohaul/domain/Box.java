package learning.geneticalgorithm.cargohaul.domain;

import java.math.BigDecimal;
import java.util.Objects;
import learning.geneticalgorithm.cargohaul.domain.exception.BoxHeightCanNotBeNullOrNegativeException;
import learning.geneticalgorithm.cargohaul.domain.exception.BoxLengthCanNotBeNullOrNegativeException;
import learning.geneticalgorithm.cargohaul.domain.exception.BoxValueCanNotBeNullOrNegativeException;
import learning.geneticalgorithm.cargohaul.domain.exception.BoxWeightCanNotBeNullOrNegativeException;
import learning.geneticalgorithm.cargohaul.domain.exception.BoxWidthCanNotBeNullOrNegativeException;

import static java.math.BigDecimal.ZERO;

public record Box(BigDecimal width, BigDecimal height, BigDecimal length, BigDecimal weight, BigDecimal cost) {

    public Box {
        if (Objects.isNull(width) || Objects.requireNonNull(width).compareTo(ZERO) < 0) {
            throw new BoxWidthCanNotBeNullOrNegativeException();
        } else if (Objects.isNull(height) || height.compareTo(ZERO) < 0) {
            throw new BoxHeightCanNotBeNullOrNegativeException();
        } else if (Objects.isNull(length) || length.compareTo(ZERO) < 0) {
            throw new BoxLengthCanNotBeNullOrNegativeException();
        } else if (Objects.isNull(weight) || weight.compareTo(ZERO) < 0) {
            throw new BoxWeightCanNotBeNullOrNegativeException();
        } else if (Objects.isNull(cost) || cost.compareTo(ZERO) < 0) {
            throw new BoxValueCanNotBeNullOrNegativeException();
        }
    }

    public BigDecimal getVolume() {
        return this.width.multiply(this.height).multiply(this.length);
    }

}
