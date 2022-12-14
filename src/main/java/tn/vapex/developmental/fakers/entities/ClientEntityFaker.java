package tn.vapex.developmental.fakers.entities;

import tn.vapex.core.security.UserRole;
import tn.vapex.domain.entitites.Client;
import tn.vapex.domain.entitites.User;

public class ClientEntityFaker implements EntityFaker<Client> {

    @Override
    public Client getFakeEntity() {
        UserEntityFaker userEntityFaker = new UserEntityFaker();
        User user = userEntityFaker.getFakeEntity();
        user.setRole(UserRole.ROLE_CLIENT);

        Client client = new Client();
        user.setClient(client);
        client.setUser(user);

        return client;
    }

}
