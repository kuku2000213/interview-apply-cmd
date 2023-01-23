package kr.gyuna.interview.hexagonal.application.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.transaction.InvalidTransactionException;
import jakarta.transaction.Transactional;
import kr.gyuna.interview.common.response.DefaultResponse;
import kr.gyuna.interview.hexagonal.application.port.in.CreateApplyCommand;
import kr.gyuna.interview.hexagonal.application.port.in.CreateApplyUseCase;
import kr.gyuna.interview.hexagonal.application.port.out.CreateApplyPort;
import kr.gyuna.interview.hexagonal.application.port.out.FindApplyPort;
import kr.gyuna.interview.hexagonal.application.port.out.PublishApplyEventPort;
import kr.gyuna.interview.hexagonal.application.port.out.reference.jobVacancy.FindJobVacancyPort;
import kr.gyuna.interview.hexagonal.application.port.out.reference.resume.FindResumePort;
import kr.gyuna.interview.hexagonal.domain.Apply;
import kr.gyuna.interview.hexagonal.domain.ApplyId;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Transactional
@Service
public class CreateApplyService implements CreateApplyUseCase {

    private final CreateApplyPort createApplyPort;
    private final FindApplyPort findApplyPort;

    private final FindJobVacancyPort findJobVacancyPort;
    private final FindResumePort findResumePort;


    private final PublishApplyEventPort publishApplyEventPort;

    @Override
    public DefaultResponse createApply(CreateApplyCommand command) throws InvalidTransactionException, JsonProcessingException {

        findApplyPort.checkExistingApply(command.toEntity());

        findJobVacancyPort.findCreatedJobVacancyById(command.toJobVacancyId());
        findResumePort.findCreatedResumeById(command.toResumeId());


        Apply apply =
                createApplyPort.createApply(command.toEntity());

        publishApplyEventPort.newApplyCreated(apply);

        return new DefaultResponse(
                HttpStatus.CREATED.value(),
                "입사지원이 정상적으로 등록되었습니다.",
                apply.toApplyId().toString()
        );
    }
}
