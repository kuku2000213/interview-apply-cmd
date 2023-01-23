package kr.gyuna.interview.hexagonal.domain.reference.resume;

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
public class Resume {

    @EmbeddedId
    private ResumeId resumeId;

    @Enumerated(EnumType.STRING)
    private ResumeStatus resumeStatus;

    public ResumeId toResumeId(){
        if(resumeId == null){
            throw new NullPointerException("ResumeId가 존재하지 않습니다.");
        }

        return this.resumeId;
    }
}
