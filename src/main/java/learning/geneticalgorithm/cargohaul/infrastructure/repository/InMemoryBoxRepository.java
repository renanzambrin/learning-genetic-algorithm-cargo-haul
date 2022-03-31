package learning.geneticalgorithm.cargohaul.infrastructure.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import learning.geneticalgorithm.cargohaul.domain.entity.Box;
import learning.geneticalgorithm.cargohaul.domain.exception.BoxCanNotBeNullException;
import learning.geneticalgorithm.cargohaul.domain.repository.BoxRepository;

public class InMemoryBoxRepository implements BoxRepository {

    final ArrayList<Box> boxes;

    public InMemoryBoxRepository() {
        boxes = new ArrayList<>();
    }

    @Override
    public List<Box> getBoxes() {
        return (ArrayList<Box>) this.boxes.clone();
    }

    @Override
    public Box getBoxAt(int index) {
        return this.boxes.get(index);
    }

    @Override
    public void addBox(Box box) {
        if (Objects.isNull(box)) {
            throw new BoxCanNotBeNullException();
        }
        this.boxes.add(box);
    }

    @Override
    public int getAmount() {
        return this.boxes.size();
    }

}
