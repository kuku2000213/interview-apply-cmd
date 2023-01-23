package kr.gyuna.interview.hexagonal.application.port.out;

import jakarta.transaction.InvalidTransactionException;
import kr.gyuna.interview.hexagonal.domain.Apply;
import kr.gyuna.interview.hexagonal.domain.ApplyId;

public interface FindApplyPort {

    void checkExistingApply(Apply apply) throws InvalidTransactionException;

    Apply findApplyById(ApplyId applyId);

//    Apply findStandbyProgressApplyById(ApplyId applyId);
//
//    Apply findStandbyResultApplyById(ApplyId applyId);
}
