package learning.geneticalgorithm.cargohaul.infrastructure.repository;

import learning.geneticalgorithm.cargohaul.domain.repository.BoxRepository;
import learning.geneticalgorithm.cargohaul.domain.repository.BoxRepositoryTest;
import org.junit.jupiter.api.BeforeEach;

class InMemoryBoxRepositoryTest extends BoxRepositoryTest {

    private BoxRepository boxRepository;

    @BeforeEach
    void setUp() {
        boxRepository = new InMemoryBoxRepository();
    }

    @Override
    public BoxRepository getBoxRepository() {
        return this.boxRepository;
    }

}
