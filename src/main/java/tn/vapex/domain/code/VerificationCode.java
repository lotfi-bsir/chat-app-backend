package tn.vapex.domain.code;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.time.DateUtils;
import org.checkerframework.checker.index.qual.Positive;
import tn.vapex.core.fetcher.FetchedBean;
import tn.vapex.core.fetcher.UseFetchedBeans;
import tn.vapex.core.properties.VapexProperties;
import tn.vapex.domain.entitites.BaseEntity;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

@MappedSuperclass
@Getter
@Setter
@RequiredArgsConstructor
@UseFetchedBeans
public abstract class VerificationCode extends BaseEntity {


    @FetchedBean
    private static VapexProperties vapexProperties;
    @Column(name = "code")
    @Positive
    protected Integer code;
    @Column(name = "attempts_number")
    protected Integer attemptsNumber = 0;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    protected ValidationCodeStatus status = ValidationCodeStatus.ACTIVE;

    public static int generateRandomKey() {
        int min = Integer.parseInt("1" + "0".repeat(Math.max(0, vapexProperties.getVerificationCode().getCodeDigits() - 1)));
        return ThreadLocalRandom.current().nextInt(min, min * 10);
    }

    public boolean isUsed() {
        return this.getStatus() == ValidationCodeStatus.USED;
    }

    public boolean isAttemptsNumberPassedMax() {

        return this.attemptsNumber > vapexProperties.getVerificationCode().getMaxAttempts();
    }

    public boolean isExpired() {
        Date expirationDate = DateUtils.addMinutes(this.getCreatedAt(), vapexProperties.getVerificationCode().getExpirationDuration());
        Date now = new Date();
        return this.getStatus() == ValidationCodeStatus.EXPIRED || expirationDate.before(now);
    }

    public void incrementAttemptsNumber() {
        this.attemptsNumber++;
    }
}
