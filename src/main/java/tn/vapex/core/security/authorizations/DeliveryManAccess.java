package tn.vapex.core.security.authorizations;

import org.springframework.security.access.prepost.PreAuthorize;

@PreAuthorize("hasAuthority('DELIVERY_MAN')")
public @interface DeliveryManAccess {
}
