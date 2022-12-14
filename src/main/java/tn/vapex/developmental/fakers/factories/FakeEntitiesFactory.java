package tn.vapex.developmental.fakers.factories;

import java.util.Objects;

public class FakeEntitiesFactory {
    private static FakeEntitiesFactory instance = null;

    private FakeEntitiesFactory() {
    }

    public static FakeEntitiesFactory getInstance() {
        if (Objects.isNull(instance)) {
            instance = new FakeEntitiesFactory();
        }
        return instance;
    }

    public FakeUserFactory getUserFactory() {
        return FakeUserFactory.getInstance();
    }
}
