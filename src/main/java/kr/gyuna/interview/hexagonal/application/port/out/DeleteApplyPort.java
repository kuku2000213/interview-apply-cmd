package kr.gyuna.interview.hexagonal.application.port.out;

import kr.gyuna.interview.hexagonal.domain.ApplyId;

public interface DeleteApplyPort {

    void deleteApplyById(ApplyId applyId);
}
