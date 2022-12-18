package tn.vapex.domain.code;

import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Transactional;
import tn.vapex.core.fetcher.FetchedBean;
import tn.vapex.core.fetcher.UseFetchedBeans;
import tn.vapex.domain.code.exceptions.*;
import tn.vapex.domain.commons.Checker;
import tn.vapex.domain.exceptions.exceptions.CustomException;

import java.util.Objects;

import static tn.vapex.core.utils.CheckerUtils.returnFalseOrThrowException;


@Transactional(noRollbackFor = CustomException.class)
@UseFetchedBeans
public class VerificationCodeChecker implements Checker {

    @FetchedBean
    private static VerificationCodeRepository verificationCodeRepository;

    private final int key;
    private final VerificationCode code;
    private boolean throwExceptionOnFalse;

    public VerificationCodeChecker(int key, VerificationCode code) {
        this.key = key;
        this.code = code;
    }


    @Override
    public boolean performChecks(boolean throwExceptionOnFalse) {
        this.throwExceptionOnFalse = throwExceptionOnFalse;
        boolean keyNotNull = checkIfCodeIsNull();
        if (!keyNotNull) return false;

        boolean keyUnused = checkIfResetCodeAlreadyUsed();
        boolean attemptsNumberNotPassed = checkIfAttemptsNumberPassedMax();
        boolean codeNotExpired = checkIfCodeIsExpired();
        boolean keyIsValid = checkIfKeyIsValid();

        return keyIsValid && attemptsNumberNotPassed && codeNotExpired && keyUnused;
    }

    private boolean checkIfCodeIsNull() {
        if (Objects.nonNull(this.code) && Objects.nonNull(this.code.getCode())) return true;
        return returnFalseOrThrowException(CodeCannotBeNullException::new, this.throwExceptionOnFalse);
    }


    private boolean checkIfCodeIsExpired() {
        if (!code.isExpired()) return true;
        code.setStatus(ValidationCodeStatus.EXPIRED);
        this.saveActivationCodeAsync(code);
        return returnFalseOrThrowException(CodeExpiredException::new, this.throwExceptionOnFalse);
    }


    private boolean checkIfAttemptsNumberPassedMax() {
        if (!code.isAttemptsNumberPassedMax()) return true;
        return returnFalseOrThrowException(MaximumAttemptsForKeyReachedException::new, this.throwExceptionOnFalse);
    }

    private boolean checkIfKeyIsValid() {
        if (code.getCode() == key) return true;
        code.incrementAttemptsNumber();
        this.saveActivationCodeAsync(code);
        return returnFalseOrThrowException(InvalidKeyException::new, this.throwExceptionOnFalse);
    }

    private boolean checkIfResetCodeAlreadyUsed() {
        if (!code.isUsed()) return true;
        return returnFalseOrThrowException(KeyAlreadyUsedException::new, this.throwExceptionOnFalse);
    }

    @Async
    void saveActivationCodeAsync(VerificationCode code) {
        verificationCodeRepository.save(code);
    }


}
