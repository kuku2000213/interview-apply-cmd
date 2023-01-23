package kr.gyuna.interview.hexagonal.adapter.in.rest;

import kr.gyuna.interview.common.response.DefaultResponse;
import kr.gyuna.interview.hexagonal.adapter.in.rest.request.UpdateApplyProgressReq;
import kr.gyuna.interview.hexagonal.adapter.in.rest.request.UpdateApplyResultReq;
import kr.gyuna.interview.hexagonal.application.port.in.UpdateApplyProgressCommand;
import kr.gyuna.interview.hexagonal.application.port.in.UpdateApplyResultCommand;
import kr.gyuna.interview.hexagonal.application.port.in.UpdateApplyUseCase;
import kr.gyuna.interview.hexagonal.domain.ApplyId;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UpdateApplyController {

    private final UpdateApplyUseCase updateApplyUseCase;

    @PutMapping("/v1/applies/{applyId}/progress")
    public ResponseEntity<DefaultResponse> updateApplyProgress(
            @PathVariable(name = "applyId") String applyId,
            @RequestBody UpdateApplyProgressReq req
    ) {
        UpdateApplyProgressCommand command = UpdateApplyProgressCommand.builder()
                        .applyId(ApplyId.of(applyId))
                        .applyProgress(req.getProgress())
                        .build();

        DefaultResponse response =
                updateApplyUseCase.updateApplyProgress(command);

        return new ResponseEntity<>(
                response,
                HttpStatus.OK
        );
    }

    @PutMapping("/v1/applies/{applyId}/result")
    public ResponseEntity<DefaultResponse> updateApplyResult(
            @PathVariable(name = "applyId") String applyId,
            @RequestBody UpdateApplyResultReq req
    ){
        UpdateApplyResultCommand command = UpdateApplyResultCommand.builder()
                .applyId(ApplyId.of(applyId))
                .applyResult(req.getResult())
                .build();

        DefaultResponse response =
                updateApplyUseCase.updateApplyResult(command);

        return new ResponseEntity<>(
                response,
                HttpStatus.OK
        );
    }
}
