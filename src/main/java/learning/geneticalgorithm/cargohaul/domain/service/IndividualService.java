package learning.geneticalgorithm.cargohaul.domain.service;

import java.security.SecureRandom;
import java.util.Random;
import learning.geneticalgorithm.cargohaul.domain.entity.Haul;
import learning.geneticalgorithm.cargohaul.domain.repository.BoxRepository;

public class IndividualService {

    static final Random RANDOM = new SecureRandom();

    final BoxRepository boxRepository;

    public IndividualService(BoxRepository boxRepository) {
        this.boxRepository = boxRepository;
    }

    public Haul generateRandomIndividual() {
        int boxesAmount = getRandomBoxAmount();
        Haul haul = new Haul();
        for (int i = 0; i < boxesAmount; i++) {
            haul.addBox(boxRepository.getBoxAt(RANDOM.nextInt(boxRepository.getAmount())));
        }
        return haul;
    }

    int getRandomBoxAmount() {
        return RANDOM.nextInt(boxRepository.getAmount());
    }

}
