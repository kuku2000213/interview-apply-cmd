package kr.gyuna.interview.hexagonal.adapter.in.event.data;

import kr.gyuna.interview.hexagonal.domain.reference.jobVacancy.JobVacancyStatus;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class JobVacancyStatusEvent {

    private String jobVacancyId;
    private JobVacancyStatus jobVacancyStatus;

//    public enum JobVacancyProgress{
//        IN_PROGRESS, END
//    }
//
//    public Boolean isInProgress(){
//
//    }

//    private enum JobVacancyStatus{
//        CREATED, DELETED
//    }

}
