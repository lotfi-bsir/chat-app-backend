package tn.vapex.domain.enums;

import lombok.Getter;

@Getter
public enum Locale {
    FR(java.util.Locale.FRENCH),AR(new java.util.Locale("AR","TN"));

    private final java.util.Locale value;

    Locale(java.util.Locale locale) {
        this.value = locale;
    }
}
