package kr.gyuna.interview.hexagonal.application.port.in.reference.jobVacancy;

import kr.gyuna.interview.hexagonal.domain.reference.jobVacancy.JobVacancy;
import kr.gyuna.interview.hexagonal.domain.reference.jobVacancy.JobVacancyId;
import kr.gyuna.interview.hexagonal.domain.reference.jobVacancy.JobVacancyStatus;
import kr.gyuna.interview.hexagonal.domain.reference.resume.ResumeId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateJobVacancyCommand {

    private JobVacancyId jobVacancyId;
    private JobVacancyStatus jobVacancyStatus;

    public JobVacancy toEntity(){
        return JobVacancy.builder()
                .jobVacancyId(this.jobVacancyId)
                .jobVacancyStatus(this.jobVacancyStatus)
                .build();
    }
}
