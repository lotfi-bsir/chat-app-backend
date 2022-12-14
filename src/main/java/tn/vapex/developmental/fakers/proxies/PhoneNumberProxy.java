package tn.vapex.developmental.fakers.proxies;

import com.github.javafaker.Faker;
import com.github.javafaker.PhoneNumber;

public class PhoneNumberProxy extends PhoneNumber {

    public static final String TUNISIAN_PHONE_CODE = "216";

    public PhoneNumberProxy(Faker faker) {
        super(faker);
    }

    /**
     * Returns a tunisian phone number <br />
     * Same result as cellPhone()
     */
    @Override
    public String phoneNumber() {
        return TUNISIAN_PHONE_CODE + super.subscriberNumber(8);
    }

    /**
     * Returns a tunisian phone number <br />
     * Same result as phoneNumber()
     */
    @Override
    public String cellPhone() {
        return this.phoneNumber();
    }
}
