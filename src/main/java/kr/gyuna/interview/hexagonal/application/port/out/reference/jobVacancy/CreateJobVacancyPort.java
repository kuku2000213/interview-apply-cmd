package kr.gyuna.interview.hexagonal.application.port.out.reference.jobVacancy;

import kr.gyuna.interview.hexagonal.domain.reference.jobVacancy.JobVacancy;

public interface CreateJobVacancyPort {
    JobVacancy createJobVacancy(JobVacancy jobVacancy);
}
