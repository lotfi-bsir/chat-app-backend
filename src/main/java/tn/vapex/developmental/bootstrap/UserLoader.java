package tn.vapex.developmental.bootstrap;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import tn.vapex.core.security.UserRole;
import tn.vapex.developmental.fakers.factories.FakerFactory;
import tn.vapex.domain.entitites.User;
import tn.vapex.domain.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserLoader extends DataLoader {
    static final int CLIENTS_MULTIPLYING = 3;
    static final int DELIVERY_MEN_MULTIPLYING = 1;
    private final UserRepository userRepository;

    @Override
    protected void load() {
        final int factor = super.vapexProperties.getDataLoader().getFactor();

        List<User> users = new ArrayList<>();
        List<User> clients = FakerFactory.getInstance().fakeEntitiesFactory().getUserFactory().withRole(UserRole.ROLE_CLIENT, CLIENTS_MULTIPLYING * factor);
        List<User> deliveryMen = FakerFactory.getInstance().fakeEntitiesFactory().getUserFactory().withRole(UserRole.ROLE_DELIVERY_MAN, DELIVERY_MEN_MULTIPLYING * factor);
        users.addAll(clients);
        users.addAll(deliveryMen);
        this.userRepository.saveAll(users);
    }

    @Override
    protected void purge() {
        this.userRepository.deleteAll();
    }

    @Override
    protected void log() {
        final int FACTOR = super.vapexProperties.getDataLoader().getFactor();

        log.info("Loading {} clients", CLIENTS_MULTIPLYING * FACTOR);
        log.info("Loading {} delivery men ", DELIVERY_MEN_MULTIPLYING * FACTOR);
    }
}
