package telran.entity.dao;

import telran.entity.interfaces.Entity;
import telran.entity.interfaces.EntityCollection;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class EntityImplA implements EntityCollection {

    private Set<Entity> entitySet;

    public EntityImplA() {
        entitySet = new HashSet<>();
    }

    //O(1)
    @Override
    public void add(Entity entity) {
        entitySet.add(entity);
    }

    //O(n)
    //Если я правильно понимаю, то теоритический, модель Entity должна иметь компаратор.
    // но так как у нас этой модели нет, я добавил компоратор в метод чтобы не было ошибок компиляции.
    @Override
    public Entity removeMaxValue() {
        Comparator<Entity> comp = (e1, e2) -> Integer.compare(e1.getValue(),e2.getValue());
        Entity toRemove = Collections.max(entitySet,comp);
        if (entitySet.remove(toRemove)) {
            return toRemove;
        }
        return null;
    }


}
