package learning.geneticalgorithm.cargohaul.scenario;

import java.util.logging.Logger;
import learning.geneticalgorithm.cargohaul.domain.entity.Haul;
import learning.geneticalgorithm.cargohaul.domain.entity.Van;
import learning.geneticalgorithm.cargohaul.domain.entity.resolver.DefaultVanParameterResolver;
import learning.geneticalgorithm.cargohaul.domain.facade.HaulPickerFacade;
import learning.geneticalgorithm.cargohaul.domain.repository.BoxRepository;
import learning.geneticalgorithm.cargohaul.domain.service.FitnessService;
import learning.geneticalgorithm.cargohaul.domain.service.IndividualService;
import learning.geneticalgorithm.cargohaul.domain.service.MutationStrategy;
import learning.geneticalgorithm.cargohaul.domain.service.OffspringStrategy;
import learning.geneticalgorithm.cargohaul.domain.service.PopulationService;
import learning.geneticalgorithm.cargohaul.domain.service.SelectionStrategy;
import learning.geneticalgorithm.cargohaul.infrastructure.repository.InMemoryBoxRepository;
import learning.geneticalgorithm.cargohaul.infrastructure.strategy.mutation.LowRandomProbabilityMutationStrategy;
import learning.geneticalgorithm.cargohaul.infrastructure.strategy.offspring.OnePointCrossoverOffspringStrategy;
import learning.geneticalgorithm.cargohaul.infrastructure.strategy.selection.TournamentSelectionStrategy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;
import org.junit.jupiter.api.extension.ExtendWith;

class ScenarioOneTest {

    static final Logger LOGGER = Logger.getLogger(ScenarioOneTest.class.getName());

    HaulPickerFacade haulPickerFacade;
    PopulationService populationService;
    FitnessService fitnessService;
    IndividualService individualService;
    BoxRepository boxRepository;
    SelectionStrategy selectionStrategy;
    OffspringStrategy offspringStrategy;
    MutationStrategy mutationStrategy;

    @BeforeEach
    void setUp() {
        LOGGER.info("--------- Loading Scenario ---------");
        LOGGER.info("--- Instantiating repository");
        boxRepository = new InMemoryBoxRepository();
        LOGGER.info("--- Loading Boxes");
        BoxFixture.generateFixture().forEach(boxRepository::addBox);
        LOGGER.info("--- Instantiating individual service");
        individualService = new IndividualService(boxRepository);
        LOGGER.info("--- Instantiating selection strategy");
        selectionStrategy = new TournamentSelectionStrategy();
        LOGGER.info("--- Instantiating offspring strategy");
        offspringStrategy = new OnePointCrossoverOffspringStrategy();
        LOGGER.info("--- Instantiating mutation strategy");
        mutationStrategy = new LowRandomProbabilityMutationStrategy(boxRepository);
        LOGGER.info("--- Instantiating population service");
        populationService = new PopulationService(individualService, selectionStrategy, offspringStrategy,
                mutationStrategy);
        LOGGER.info("--- Instantiating fitness service");
        fitnessService = new FitnessService();
        LOGGER.info("--- Instantiating haul picker facade");
        haulPickerFacade = new HaulPickerFacade(populationService, fitnessService);
        LOGGER.info("--------- Loading Scenario Completed ---------");
    }

    @EnabledIfSystemProperty(named = "runScenarios", matches = "true")
    @Test
    @ExtendWith(DefaultVanParameterResolver.class)
    void givenHaul_WhenPickHaulForVan_ThenReturnHaulContainingOneBox(Van van) {
        LOGGER.info("""
                    --------- Picking haul for Van ---------
                    Van width: %s
                    Van height: %s
                    Van length: %s
                    Van volume: %s
                    Van max weight: %s
                    """.formatted(van.width(), van.height(), van.length(), van.getVolume(), van.maxWeight()));
        Haul result = haulPickerFacade.pickHaulFor(van);
        Assertions.assertNotNull(result);
        LOGGER.info("""
                    ========= Haul =========
                    Boxes: %d
                    Weight: %s
                    Volume: %s
                    Cost: %s
                    %n""".formatted(result.getCargo().size(), result.getWeight(), result.getVolume(),
                result.getCost()));
    }

}
