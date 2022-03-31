package learning.geneticalgorithm.cargohaul.domain.repository;

import java.util.List;
import learning.geneticalgorithm.cargohaul.domain.entity.Box;

public interface BoxRepository {

    List<Box> getBoxes();

    Box getBoxAt(int position);

    void addBox(Box box);

    int getAmount();

}
