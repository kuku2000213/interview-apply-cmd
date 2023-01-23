package kr.gyuna.interview.hexagonal.domain;

import jakarta.persistence.*;
import kr.gyuna.interview.hexagonal.adapter.out.event.data.ApplyStatusEvent;
import kr.gyuna.interview.hexagonal.domain.reference.jobVacancy.JobVacancyId;
import kr.gyuna.interview.hexagonal.domain.reference.resume.ResumeId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Apply {

    @EmbeddedId
    private ApplyId applyId;

    @Embedded
    private JobVacancyId jobVacancyId;
    @Embedded
    private ResumeId resumeId;

    @Embedded
    private ApplyDate applyDate;
    @Enumerated(value = EnumType.STRING)
    private ApplyProgress applyProgress;
    @Enumerated(value = EnumType.STRING)
    private ApplyResult applyResult;

    public ApplyId toApplyId(){
        return this.applyId;
    }

    public JobVacancyId toJobVacancyId(){
        return this.jobVacancyId;
    }

    public ResumeId toResumeId(){
        return this.resumeId;
    }

    public void updateApplyProgress(ApplyProgress applyProgress){
        if(this.applyProgress != ApplyProgress.STANDBY){
            throw new IllegalArgumentException("승인여부를 번복할 수 없습니다.");
        }

        this.applyProgress = applyProgress;
    }

    public void updateApplyResult(ApplyResult applyResult){
        if(this.applyResult != ApplyResult.STANDBY){
            throw new IllegalArgumentException("합격여부를 번복할 수 없습니다.");
        }
        this.applyResult = applyResult;

    }

    public ApplyStatusEvent toApplyStatusEvent(){
        return ApplyStatusEvent.builder()
                .applyId(this.applyId.toString())
                .applyProgress(String.valueOf(this.applyProgress))
                .applyResult(String.valueOf(this.applyResult))
                .build();
    }
}
