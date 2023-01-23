package kr.gyuna.interview.hexagonal.application.port.in;

import kr.gyuna.interview.hexagonal.domain.*;
import kr.gyuna.interview.hexagonal.domain.reference.jobVacancy.JobVacancyId;
import kr.gyuna.interview.hexagonal.domain.reference.resume.ResumeId;
import kr.gyuna.interview.hexagonal.domain.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateApplyCommand {

    private JobVacancyId jobVacancyId;
    private ResumeId resumeId;


    public Apply toEntity() {
        Date today = new Date();

        ApplyDate applyDate = ApplyDate.builder()
                .applyCreatedDate(today)
                .applyModifiedDate(today)
                .build();

        return Apply.builder()
                .applyId(ApplyId.uuid())
                .jobVacancyId(this.jobVacancyId)
                .resumeId(this.resumeId)
                .applyProgress(ApplyProgress.STANDBY)
                .applyResult(ApplyResult.STANDBY)
                .applyDate(applyDate)
                .build();
    }

    public JobVacancyId toJobVacancyId(){
        return this.jobVacancyId;
    }

    public ResumeId toResumeId(){
        return this.resumeId;
    }
}
