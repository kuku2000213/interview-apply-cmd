package kr.gyuna.interview.hexagonal.adapter.in.rest.request;

import kr.gyuna.interview.hexagonal.domain.ApplyProgress;
import lombok.Getter;

@Getter
public class UpdateApplyProgressReq {

    private ApplyProgress progress;
}
