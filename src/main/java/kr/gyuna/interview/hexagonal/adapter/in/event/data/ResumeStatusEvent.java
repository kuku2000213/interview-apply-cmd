package kr.gyuna.interview.hexagonal.adapter.in.event.data;

import kr.gyuna.interview.hexagonal.domain.reference.resume.ResumeStatus;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ResumeStatusEvent {

    private String resumeId;
    private ResumeStatus resumeStatus;
}
