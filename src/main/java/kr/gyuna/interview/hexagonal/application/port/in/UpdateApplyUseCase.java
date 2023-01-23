package kr.gyuna.interview.hexagonal.application.port.in;

import kr.gyuna.interview.common.response.DefaultResponse;

public interface UpdateApplyUseCase {
    DefaultResponse updateApplyProgress(UpdateApplyProgressCommand command);

    DefaultResponse updateApplyResult(UpdateApplyResultCommand command);
}
