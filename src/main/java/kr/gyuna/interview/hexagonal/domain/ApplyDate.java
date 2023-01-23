package kr.gyuna.interview.hexagonal.domain;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class ApplyDate {

    private Date applyCreatedDate;
    private Date applyModifiedDate;
}
