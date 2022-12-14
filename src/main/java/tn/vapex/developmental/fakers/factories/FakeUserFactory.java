package tn.vapex.developmental.fakers.factories;

import tn.vapex.core.security.UserRole;
import tn.vapex.developmental.fakers.entities.ClientEntityFaker;
import tn.vapex.developmental.fakers.entities.DeliveryManEntityFaker;
import tn.vapex.developmental.fakers.entities.UserEntityFaker;
import tn.vapex.domain.entitites.Client;
import tn.vapex.domain.entitites.DeliveryMan;
import tn.vapex.domain.entitites.User;

import javax.validation.constraints.Positive;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class FakeUserFactory {

    private static FakeUserFactory instance = null;

    private FakeUserFactory() {
    }

    public static FakeUserFactory getInstance() {
        if (Objects.isNull(instance)) {
            instance = new FakeUserFactory();
        }
        return instance;
    }

    public User withRole(UserRole role){
        switch (role){
            case ROLE_USER: return new UserEntityFaker().getFakeEntity();
            case ROLE_CLIENT: return new ClientEntityFaker().getFakeEntity().getUser();
            case ROLE_DELIVERY_MAN: return new DeliveryManEntityFaker().getFakeEntity().getUser();
            default: throw new UnsupportedOperationException();
        }
    }

    public List<User> withRole(UserRole role, @Positive int count){
        switch (role) {
            case ROLE_USER: return new UserEntityFaker().getFakeEntitiesList(count);
            case ROLE_CLIENT: return new ClientEntityFaker().getFakeEntitiesList(count).stream().map(Client::getUser).collect(Collectors.toList());
            case ROLE_DELIVERY_MAN: return new DeliveryManEntityFaker().getFakeEntitiesList(count).stream().map(DeliveryMan::getUser).collect(Collectors.toList());
            default: throw new UnsupportedOperationException();
        }
    }

}
