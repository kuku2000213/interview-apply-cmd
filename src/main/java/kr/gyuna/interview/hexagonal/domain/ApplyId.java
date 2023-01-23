package kr.gyuna.interview.hexagonal.domain;

import jakarta.persistence.Embeddable;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@NoArgsConstructor
@Embeddable
public class ApplyId implements Serializable {

    private String applyUuid;

    public ApplyId(String applyUuid) {
        if (applyUuid == null) {
            throw new IllegalArgumentException("applyUuid is null");
        }

        this.applyUuid = applyUuid;
    }


    @Override
    public int hashCode() {
        return Objects.hash(applyUuid);
    }

    public static ApplyId of(String applyUuid) {
        return new ApplyId(applyUuid);
    }

    public static ApplyId uuid(){
        return new ApplyId(UUID.randomUUID().toString());
    }

    public String toString(){
        return this.applyUuid;
    }
}
