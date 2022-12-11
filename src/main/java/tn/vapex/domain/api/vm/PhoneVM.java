package tn.vapex.domain.api.vm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.vapex.domain.validators.phone.TunisianPhone;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PhoneVM {
    @TunisianPhone
    private String phone;
}
