package kr.gyuna.interview.hexagonal.application.port.in;

import kr.gyuna.interview.hexagonal.domain.ApplyId;
import kr.gyuna.interview.hexagonal.domain.ApplyResult;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateApplyResultCommand {

    private ApplyId applyId;

    private ApplyResult applyResult;

    public ApplyId toApplyId(){
        return this.applyId;
    }

    public ApplyResult toApplyResult(){
        return this.applyResult;
    }
}
