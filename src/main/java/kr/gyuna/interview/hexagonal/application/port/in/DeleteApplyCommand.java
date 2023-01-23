package kr.gyuna.interview.hexagonal.application.port.in;

import kr.gyuna.interview.hexagonal.domain.ApplyId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeleteApplyCommand {

    private ApplyId applyId;

    public ApplyId toApplyId(){
        return this.applyId;
    }
}
