package tn.vapex.developmental.fakers;

import com.github.javafaker.Address;
import com.github.javafaker.Faker;
import com.github.javafaker.PhoneNumber;
import tn.vapex.developmental.fakers.proxies.AddressProxy;
import tn.vapex.developmental.fakers.proxies.PhoneNumberProxy;

public class BufferedFaker extends Faker {

    @Override
    public PhoneNumber phoneNumber() {
        return new PhoneNumberProxy(this);
    }

    @Override
    public Address address() {
        return new AddressProxy(this);
    }
}
