package telran.entity.dao;

import telran.entity.interfaces.Entity;
import telran.entity.interfaces.EntityCollection;

import java.util.*;

public class EntityImplB implements EntityCollection {
    private TreeSet<Entity> entitySet;

    public EntityImplB() {
        Comparator<Entity> comp = (e1, e2) -> Integer.compare(e1.getValue(), e2.getValue());
        entitySet = new TreeSet<>(comp);
    }

    // O(log n)
    @Override
    public void add(Entity entity) {
        entitySet.add(entity);
    }

    // O(log n)
    @Override
    public Entity removeMaxValue() {
        return entitySet.pollLast();
    }
}
