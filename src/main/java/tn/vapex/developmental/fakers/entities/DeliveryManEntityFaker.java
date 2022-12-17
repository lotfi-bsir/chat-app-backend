package tn.vapex.developmental.fakers.entities;

import com.github.javafaker.Faker;
import tn.vapex.core.security.UserRole;
import tn.vapex.developmental.fakers.factories.FakerFactory;
import tn.vapex.domain.entitites.DeliveryMan;
import tn.vapex.domain.entitites.User;
import tn.vapex.domain.storage.enums.FileType;

public class DeliveryManEntityFaker implements EntityFaker<DeliveryMan> {

    private final Faker faker = FakerFactory.getInstance().bufferedFaker();

    @Override
    public DeliveryMan getFakeEntity() {
        UserEntityFaker userEntityFaker = new UserEntityFaker();
        User user = userEntityFaker.getFakeEntity();
        user.setRole(UserRole.ROLE_DELIVERY_MAN);

        DeliveryMan deliveryMan = new DeliveryMan();
        user.setDeliveryMan(deliveryMan);
        deliveryMan.setUser(user);

        deliveryMan.setFirstName(faker.name().firstName());
        deliveryMan.setLastName(faker.name().lastName());
        deliveryMan.setPhoto(FakerFactory.getInstance().fakeFileFetcher().getFakeFile(FileType.DELIVERY_MAN_PHOTO));


        return deliveryMan;
    }
}
