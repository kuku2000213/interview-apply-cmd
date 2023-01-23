package kr.gyuna.interview.hexagonal.adapter.in.rest.request;

import kr.gyuna.interview.hexagonal.domain.ApplyResult;
import lombok.Getter;

@Getter
public class UpdateApplyResultReq {

    private ApplyResult result;
}
