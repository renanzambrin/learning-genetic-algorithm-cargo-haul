package learning.geneticalgorithm.cargohaul.domain.entity.resolver;

import java.math.BigDecimal;
import java.util.Random;
import learning.geneticalgorithm.cargohaul.domain.entity.Box;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

public class BoxParameterResolver implements ParameterResolver {

    private static final Random RANDOM = new Random();
    private static final int MAX_BOUND = 2;
    private static final BigDecimal MIN_BOUND = BigDecimal.valueOf(0.1);

    @Override
    public boolean supportsParameter(ParameterContext parameterContext,
                                     ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType().equals(Box.class);
    }

    @Override
    public Box resolveParameter(ParameterContext parameterContext,
                                ExtensionContext extensionContext) throws ParameterResolutionException {
        return new Box(BigDecimal.valueOf(RANDOM.nextInt(MAX_BOUND)).add(MIN_BOUND),
                BigDecimal.valueOf(RANDOM.nextInt(MAX_BOUND)).add(MIN_BOUND),
                BigDecimal.valueOf(RANDOM.nextInt(MAX_BOUND)).add(MIN_BOUND),
                BigDecimal.valueOf(RANDOM.nextInt(MAX_BOUND)).add(MIN_BOUND),
                BigDecimal.valueOf(RANDOM.nextInt(MAX_BOUND)).add(MIN_BOUND));
    }

}
