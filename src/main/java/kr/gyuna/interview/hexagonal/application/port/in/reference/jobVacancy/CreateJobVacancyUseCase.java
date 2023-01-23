package kr.gyuna.interview.hexagonal.application.port.in.reference.jobVacancy;

import kr.gyuna.interview.common.response.DefaultResponse;
import kr.gyuna.interview.hexagonal.domain.reference.jobVacancy.JobVacancy;

public interface CreateJobVacancyUseCase {

    DefaultResponse createJobVacancy(CreateJobVacancyCommand command);
}
