package kr.gyuna.interview.hexagonal.application.port.out;

import kr.gyuna.interview.hexagonal.domain.Apply;
import kr.gyuna.interview.hexagonal.domain.ApplyId;

public interface CreateApplyPort {

    Apply createApply(Apply apply);
}
