package kr.gyuna.interview.hexagonal.application.port.in;

import kr.gyuna.interview.hexagonal.domain.ApplyId;
import kr.gyuna.interview.hexagonal.domain.ApplyProgress;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateApplyProgressCommand {

    private ApplyId applyId;
    private ApplyProgress applyProgress;

    public ApplyId toApplyId(){
        return this.applyId;
    }

    public ApplyProgress toApplyProgress(){
        return this.applyProgress;
    }
}
