package tn.vapex.developmental.fakers.entities;

import com.github.javafaker.Faker;
import com.google.common.collect.Lists;
import tn.vapex.core.security.UserRole;
import tn.vapex.developmental.fakers.BufferedFaker;
import tn.vapex.domain.entitites.User;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserEntityFaker implements EntityFaker<User> {

    private final Faker faker = new BufferedFaker();

    @Override
    public User getFakeEntity() {
        User user = new User();
        user.setPhone(faker.phoneNumber().cellPhone());
        user.setRole(UserRole.ROLE_USER);
        user.setValidationCode(new ValidationCodeEntityFaker().getFakeEntity());

        return user;
    }


    @Override
    public List<User> getFakeEntitiesList(int count) {
        Set<User> users = new HashSet<>();
        // PS: Logic added to guarantee email and phone uniqueness
        while (users.size() < count) {
            boolean isUserAdded = false;
            User user = this.getFakeEntity();
            while (!isUserAdded) {
                isUserAdded = users.add(user);
                if (!isUserAdded) {
                    this.changePhone(user);
                }
            }
        }
        return Lists.newArrayList(users);
    }

    private void changePhone(User user) {
        user.setPhone(faker.phoneNumber().cellPhone());
    }

}
