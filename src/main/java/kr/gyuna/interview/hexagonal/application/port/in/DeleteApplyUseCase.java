package kr.gyuna.interview.hexagonal.application.port.in;

import kr.gyuna.interview.common.response.DefaultResponse;

public interface DeleteApplyUseCase {
    DefaultResponse deleteApplyById(DeleteApplyCommand command);
}
