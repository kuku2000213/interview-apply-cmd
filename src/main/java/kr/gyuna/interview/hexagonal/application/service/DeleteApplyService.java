package kr.gyuna.interview.hexagonal.application.service;

import jakarta.transaction.Transactional;
import kr.gyuna.interview.common.response.DefaultResponse;
import kr.gyuna.interview.hexagonal.application.port.in.DeleteApplyCommand;
import kr.gyuna.interview.hexagonal.application.port.in.DeleteApplyUseCase;
import kr.gyuna.interview.hexagonal.application.port.out.DeleteApplyPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
@Transactional
public class DeleteApplyService implements DeleteApplyUseCase {

    private final DeleteApplyPort deleteApplyPort;

    @Override
    public DefaultResponse deleteApplyById(DeleteApplyCommand command) {

        deleteApplyPort.deleteApplyById(command.toApplyId());

        return new DefaultResponse(
                HttpStatus.OK.value(),
                "입사지원이 삭제되었습니다.",
                command.toApplyId().toString()
        );
    }
}