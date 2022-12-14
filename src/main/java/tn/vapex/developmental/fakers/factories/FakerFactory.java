package tn.vapex.developmental.fakers.factories;

import java.util.Objects;

public class FakerFactory {

    private static FakerFactory instance = null;

    private FakerFactory() {
    }

    public static FakerFactory getInstance() {
        if (Objects.isNull(instance)) {
            instance = new FakerFactory();
        }
        return instance;
    }

    public FakeEntitiesFactory fakeEntitiesFactory(){
        return FakeEntitiesFactory.getInstance();
    }
}
