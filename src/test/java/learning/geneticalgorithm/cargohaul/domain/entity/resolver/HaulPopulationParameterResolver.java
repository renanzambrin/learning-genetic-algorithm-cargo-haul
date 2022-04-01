package learning.geneticalgorithm.cargohaul.domain.entity.resolver;

import java.util.ArrayList;
import java.util.List;
import learning.geneticalgorithm.cargohaul.domain.entity.Haul;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.support.TypeBasedParameterResolver;

public class HaulPopulationParameterResolver extends TypeBasedParameterResolver<List<Haul>> {

    public static final int DEFAULT_SIZE = 10;

    @Override
    public List<Haul> resolveParameter(ParameterContext parameterContext,
                                       ExtensionContext extensionContext) throws ParameterResolutionException {
        return generateHaulList(DEFAULT_SIZE);
    }

    public static List<Haul> generateHaulList(int size) {
        List<Haul> list = new ArrayList<>();
        while (list.size() < size) {
            list.add(HaulParameterResolver.generateHaul());
        }
        return list;
    }

}
