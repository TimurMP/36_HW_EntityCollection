package telran.entity.dao;

import telran.entity.interfaces.Entity;
import telran.entity.interfaces.EntityCollection;

import java.util.*;

public class EntityImplC implements EntityCollection {
    private List<Entity> entityList;
    static Comparator<Entity> comp = (e1, e2) -> Integer.compare(e1.getValue(), e2.getValue());

    public EntityImplC() {
        entityList = new ArrayList<>();
//        Collections.sort(entityList, comp);
    }

    // O(n)
    @Override
    public void add(Entity entity) {
        for (Entity entity1 : entityList) {
            if (entityList.contains(entity)) {
                return;
            }
        }
        int index = Collections.binarySearch(entityList, entity, comp);
        index = index >= 0 ? index : -index - 1;
        entityList.add(index, entity);
    }


    // O(1)
    @Override
    public Entity removeMaxValue() {
        Entity entity = entityList.get(entityList.size() - 1);
        entityList.remove(entityList.size() - 1);
        return entity;

    }
}
