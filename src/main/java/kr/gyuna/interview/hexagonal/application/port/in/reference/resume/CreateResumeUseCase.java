package kr.gyuna.interview.hexagonal.application.port.in.reference.resume;

import kr.gyuna.interview.common.response.DefaultResponse;

public interface CreateResumeUseCase {
    DefaultResponse createResume(CreateResumeCommand command);
}
