package learning.geneticalgorithm.cargohaul.domain.entity.resolver;

import java.math.BigDecimal;
import learning.geneticalgorithm.cargohaul.domain.entity.Van;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.support.TypeBasedParameterResolver;

public class DefaultVanParameterResolver extends TypeBasedParameterResolver<Van> {

    public static final BigDecimal WIDTH = BigDecimal.valueOf(2);
    public static final BigDecimal HEIGHT = BigDecimal.valueOf(1.76);
    public static final BigDecimal LENGTH = BigDecimal.valueOf(4);
    public static final BigDecimal MAX_WEIGHT = BigDecimal.valueOf(1350);

    @Override
    public Van resolveParameter(ParameterContext parameterContext,
                                ExtensionContext extensionContext) throws ParameterResolutionException {
        return new Van(WIDTH, HEIGHT, LENGTH, MAX_WEIGHT);
    }

}
