package kr.gyuna.interview.hexagonal.adapter.in.rest;

import kr.gyuna.interview.common.response.DefaultResponse;
import kr.gyuna.interview.hexagonal.application.port.in.DeleteApplyCommand;
import kr.gyuna.interview.hexagonal.application.port.in.DeleteApplyUseCase;
import kr.gyuna.interview.hexagonal.domain.ApplyId;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DeleteApplyController {

    private final DeleteApplyUseCase deleteApplyUseCase;

    @DeleteMapping("/v1/applies/{applyId}")
    public ResponseEntity<DefaultResponse> deleteApply(
            @PathVariable(name = "applyId") String applyId
    ){
        DeleteApplyCommand command = DeleteApplyCommand.builder()
                .applyId(ApplyId.of(applyId))
                .build();

        DefaultResponse response =
                deleteApplyUseCase.deleteApplyById(command);

        return new ResponseEntity<>(
                response,
                HttpStatus.OK
        );
    }
}
