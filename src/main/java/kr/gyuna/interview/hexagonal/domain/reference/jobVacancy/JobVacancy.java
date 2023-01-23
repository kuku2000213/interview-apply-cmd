package kr.gyuna.interview.hexagonal.domain.reference.jobVacancy;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobVacancy {

    @EmbeddedId
    private JobVacancyId jobVacancyId;

    @Enumerated(value = EnumType.STRING)
    private JobVacancyStatus jobVacancyStatus;

    public JobVacancyId toJobVacancyId(){

        if(jobVacancyId == null){
            throw new NullPointerException("jobVacancyId가 존재하지 않습니다.");
        }

        return this.jobVacancyId;
    }
}
