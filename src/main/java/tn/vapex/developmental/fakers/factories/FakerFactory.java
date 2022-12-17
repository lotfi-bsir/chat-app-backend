package tn.vapex.developmental.fakers.factories;

import com.github.javafaker.Faker;
import tn.vapex.developmental.fakers.BufferedFaker;
import tn.vapex.developmental.fakers.files.FakeFileFetcher;

import java.util.Objects;
import java.util.Random;

public class FakerFactory {

    private static final Random RANDOM = new Random();
    private static FakerFactory instance = null;

    private FakerFactory() {
    }

    public static FakerFactory getInstance() {
        if (Objects.isNull(instance)) {
            instance = new FakerFactory();
        }
        return instance;
    }

    /**
     * @param enumClass Enum class
     * @return Random value from the enum class provided
     */
    public static <T extends Enum<?>> T randomEnum(Class<T> enumClass) {
        int x = RANDOM.nextInt(enumClass.getEnumConstants().length);
        return enumClass.getEnumConstants()[x];
    }

    public Faker bufferedFaker() {
        return new BufferedFaker();
    }

    public FakeEntitiesFactory fakeEntitiesFactory() {
        return FakeEntitiesFactory.getInstance();
    }

    public FakeFileFetcher fakeFileFetcher() {
        return FakeFileFetcher.getInstance();
    }
}
