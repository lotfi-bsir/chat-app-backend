package tn.vapex.core.properties;

import lombok.Data;

@Data
public class VerificationCodeProperties {
    private int maxAttempts;
    private int expirationDuration;
    private int codeDigits;
}
