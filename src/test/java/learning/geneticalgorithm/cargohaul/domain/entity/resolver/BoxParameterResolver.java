package learning.geneticalgorithm.cargohaul.domain.entity.resolver;

import java.math.BigDecimal;
import java.util.Random;
import learning.geneticalgorithm.cargohaul.domain.entity.Box;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.support.TypeBasedParameterResolver;

public class BoxParameterResolver extends TypeBasedParameterResolver<Box> {

    public static final Random RANDOM = new Random();
    public static final int MAX_BOUND = 2;
    public static final BigDecimal MIN_BOUND = BigDecimal.valueOf(0.1);
    public static final int DEFAULT_POSITION = 0;

    @Override
    public Box resolveParameter(ParameterContext parameterContext,
                                ExtensionContext extensionContext) throws ParameterResolutionException {
        return generateBox(DEFAULT_POSITION);
    }

    public static Box generateBox(int position) {
        return new Box(position,
                BigDecimal.valueOf(RANDOM.nextDouble(MAX_BOUND)).add(MIN_BOUND),
                BigDecimal.valueOf(RANDOM.nextDouble(MAX_BOUND)).add(MIN_BOUND),
                BigDecimal.valueOf(RANDOM.nextDouble(MAX_BOUND)).add(MIN_BOUND),
                BigDecimal.valueOf(RANDOM.nextDouble(MAX_BOUND)).add(MIN_BOUND),
                BigDecimal.valueOf(RANDOM.nextDouble(MAX_BOUND)).add(MIN_BOUND));
    }

}
