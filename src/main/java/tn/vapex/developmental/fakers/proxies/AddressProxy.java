package tn.vapex.developmental.fakers.proxies;

import com.github.javafaker.Address;
import com.github.javafaker.Faker;

public class AddressProxy extends Address {

    public AddressProxy(Faker faker) {
        super(faker);
    }

    @Override
    public String latitude() {
        return super.latitude().replace(',','.');
    }

    @Override
    public String longitude() {
        return super.longitude().replace(',','.');
    }
}
