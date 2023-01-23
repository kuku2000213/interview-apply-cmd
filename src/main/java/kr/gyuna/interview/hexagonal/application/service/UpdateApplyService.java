package kr.gyuna.interview.hexagonal.application.service;

import jakarta.transaction.Transactional;
import kr.gyuna.interview.common.response.DefaultResponse;
import kr.gyuna.interview.hexagonal.application.port.in.UpdateApplyProgressCommand;
import kr.gyuna.interview.hexagonal.application.port.in.UpdateApplyResultCommand;
import kr.gyuna.interview.hexagonal.application.port.in.UpdateApplyUseCase;
import kr.gyuna.interview.hexagonal.application.port.out.FindApplyPort;
import kr.gyuna.interview.hexagonal.domain.Apply;
import kr.gyuna.interview.hexagonal.domain.ApplyId;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Transactional
@Service
public class UpdateApplyService implements UpdateApplyUseCase {

    private final FindApplyPort findApplyPort;

    @Override
    public DefaultResponse updateApplyProgress(UpdateApplyProgressCommand command) {

        Apply apply = findApplyPort
                .findApplyById(command.toApplyId());

        apply.updateApplyProgress(command.toApplyProgress());

        return new DefaultResponse(
                HttpStatus.OK.value(),
                "채용 공고 진행도가 변경되었습니다.",
                command.toApplyId().toString()
        );
    }

    @Override
    public DefaultResponse updateApplyResult(UpdateApplyResultCommand command) {

        Apply apply = findApplyPort
                .findApplyById(command.toApplyId());

        apply.updateApplyResult(command.toApplyResult());

        return new DefaultResponse(
                HttpStatus.OK.value(),
                "채용 공고 결과가 변경되었습니다.",
                command.toApplyId().toString()
        );
    }
}