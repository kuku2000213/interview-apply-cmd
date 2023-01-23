package kr.gyuna.interview.hexagonal.application.port.in.reference.resume;

import kr.gyuna.interview.hexagonal.domain.reference.resume.Resume;
import kr.gyuna.interview.hexagonal.domain.reference.resume.ResumeId;
import kr.gyuna.interview.hexagonal.domain.reference.resume.ResumeStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateResumeCommand {

    private ResumeId resumeId;
    private ResumeStatus resumeStatus;

    public Resume toEntity(){
        return Resume.builder()
                .resumeId(this.resumeId)
                .resumeStatus(this.resumeStatus)
                .build();
    }
}
