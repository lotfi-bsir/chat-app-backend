package tn.vapex.developmental.fakers.entities;

import tn.vapex.domain.code.ValidationCode;
import tn.vapex.domain.code.ValidationCodeStatus;
import tn.vapex.domain.code.VerificationCode;

import java.util.Date;

public class ValidationCodeEntityFaker implements EntityFaker<ValidationCode> {

    @Override
    public ValidationCode getFakeEntity() {
        final int key = VerificationCode.generateRandomKey();
        ValidationCode code = new ValidationCode();
        code.setAttemptsNumber(0);
        code.setCode(key);
        code.setStatus(ValidationCodeStatus.ACTIVE);
        code.setCreatedAt(new Date());
        code.setUpdatedAt(new Date());
        return code;
    }
}
