package gr.hua.dit.ds.it219151.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ApplicationApprovingStatus {
    PENDING_APPROVING(0),
    APPROVED(1),
    NOT_APPROVED(-1);

    private int approving;
}
