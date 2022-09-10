package gr.hua.dit.ds.it219151.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ApplicationValidationStatus {
    PENDING_VALIDATION(0),
    VALIDATED(1),
    INVALIDATED(-1);

    private int validation;
}
