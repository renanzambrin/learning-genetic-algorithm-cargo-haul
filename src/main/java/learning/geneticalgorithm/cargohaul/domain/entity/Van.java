package learning.geneticalgorithm.cargohaul.domain.entity;

import java.math.BigDecimal;
import java.util.Objects;
import learning.geneticalgorithm.cargohaul.domain.exception.VanHeightCanNotBeNullOrNegativeException;
import learning.geneticalgorithm.cargohaul.domain.exception.VanLengthCanNotBeNullOrNegativeException;
import learning.geneticalgorithm.cargohaul.domain.exception.VanMaxWeightCanNotBeNullOrNegativeException;
import learning.geneticalgorithm.cargohaul.domain.exception.VanWidthCanNotBeNullOrNegativeException;

import static java.math.BigDecimal.ZERO;

public record Van(BigDecimal width, BigDecimal height, BigDecimal length, BigDecimal maxWeight) {

    public Van {
        if (Objects.isNull(width) || Objects.requireNonNull(width).compareTo(ZERO) < 0) {
            throw new VanWidthCanNotBeNullOrNegativeException();
        } else if (Objects.isNull(height) || height.compareTo(ZERO) < 0) {
            throw new VanHeightCanNotBeNullOrNegativeException();
        } else if (Objects.isNull(length) || length.compareTo(ZERO) < 0) {
            throw new VanLengthCanNotBeNullOrNegativeException();
        } else if (Objects.isNull(maxWeight) || maxWeight.compareTo(ZERO) < 0) {
            throw new VanMaxWeightCanNotBeNullOrNegativeException();
        }
    }

}
