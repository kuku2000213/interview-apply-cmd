package kr.gyuna.interview.hexagonal.domain.reference.resume;

import jakarta.persistence.Embeddable;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@NoArgsConstructor
@Embeddable
public class ResumeId implements Serializable {

    private String resumeUuid;

    public ResumeId(String resumeUuid) {
        if (resumeUuid == null) {
            throw new IllegalArgumentException("resumeUuid is null");
        }

        this.resumeUuid = resumeUuid;
    }


    @Override
    public int hashCode() {
        return Objects.hash(resumeUuid);
    }

    public static ResumeId of(String resumeUuid) {
        return new ResumeId(resumeUuid);
    }

    public static ResumeId uuid(){
        return new ResumeId(UUID.randomUUID().toString());
    }

    public String toString(){
        return this.resumeUuid;
    }
}
