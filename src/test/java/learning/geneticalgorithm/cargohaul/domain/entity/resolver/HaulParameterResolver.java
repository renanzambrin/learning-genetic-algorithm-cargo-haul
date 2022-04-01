package learning.geneticalgorithm.cargohaul.domain.entity.resolver;

import learning.geneticalgorithm.cargohaul.domain.entity.Haul;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.support.TypeBasedParameterResolver;

public class HaulParameterResolver extends TypeBasedParameterResolver<Haul> {

    public static final int DEFAULT_HAUL_BOX_AMOUNT = 10;

    @Override
    public Haul resolveParameter(ParameterContext parameterContext,
                                 ExtensionContext extensionContext) throws ParameterResolutionException {
        return generateHaul(DEFAULT_HAUL_BOX_AMOUNT);
    }

    public static Haul generateHaul() {
        return generateHaul(DEFAULT_HAUL_BOX_AMOUNT);
    }

    public static Haul generateHaul(int haulBoxAmount) {
        Haul haul = new Haul();
        while (haul.getCargo().size() < haulBoxAmount) {
            haul.addBox(BoxParameterResolver.generateBox(haul.getCargo().size() + 1));
        }
        return haul;
    }

}
