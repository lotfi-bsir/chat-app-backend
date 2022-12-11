package tn.vapex.domain.code;

import lombok.NoArgsConstructor;
import org.checkerframework.checker.index.qual.Positive;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
public class ValidationCode extends VerificationCode {

    public ValidationCode(@Positive Integer code) {
        super();
        setCode(code);
    }

}
