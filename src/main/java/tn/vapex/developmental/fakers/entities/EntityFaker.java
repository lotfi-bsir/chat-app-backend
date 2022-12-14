package tn.vapex.developmental.fakers.entities;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public interface EntityFaker<T> {
    T getFakeEntity();

    default List<T> getFakeEntitiesList(@NotNull int count) {
        List<T> entityList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            entityList.add(getFakeEntity());
        }
        return entityList;
    }
}