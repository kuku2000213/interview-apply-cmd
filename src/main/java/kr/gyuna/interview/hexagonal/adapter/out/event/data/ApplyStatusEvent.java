package kr.gyuna.interview.hexagonal.adapter.out.event.data;

import kr.gyuna.interview.hexagonal.domain.ApplyId;
import lombok.*;


@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApplyStatusEvent {

    private String applyId;
    private String applyProgress;
    private String applyResult;
}
