package tn.vapex.core.sms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class SmsMessage {
    /**
     * Phone number must contain country code <br/>
     * Example: <B>21650123456</B>
     */
    private final String phone;
    private final String content;
}
