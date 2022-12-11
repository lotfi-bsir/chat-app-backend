package tn.vapex.domain.api.vm;

import lombok.Data;
import tn.vapex.domain.enums.SmsType;
import tn.vapex.domain.validators.phone.TunisianPhone;


import javax.validation.constraints.NotNull;

@Data
public class ResendSmsVM {
    @TunisianPhone
    @NotNull
    private String phone;
    @NotNull
    private SmsType smsType;
}
