package tn.vapex.developmental.fakers.entities;

import tn.vapex.core.security.UserRole;
import tn.vapex.domain.entitites.DeliveryMan;
import tn.vapex.domain.entitites.User;

public class DeliveryManEntityFaker implements EntityFaker<DeliveryMan> {

    @Override
    public DeliveryMan getFakeEntity() {
        UserEntityFaker userEntityFaker = new UserEntityFaker();
        User user = userEntityFaker.getFakeEntity();
        user.setRole(UserRole.ROLE_DELIVERY_MAN);

        DeliveryMan deliveryMan = new DeliveryMan();
        user.setDeliveryMan(deliveryMan);
        deliveryMan.setUser(user);

        return deliveryMan;
    }
}
