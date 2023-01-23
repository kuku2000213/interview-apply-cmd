package kr.gyuna.interview.hexagonal.adapter.in.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.transaction.InvalidTransactionException;
import kr.gyuna.interview.common.response.DefaultResponse;
import kr.gyuna.interview.hexagonal.adapter.in.rest.request.CreateApplyReq;
import kr.gyuna.interview.hexagonal.application.port.in.CreateApplyCommand;
import kr.gyuna.interview.hexagonal.application.port.in.CreateApplyUseCase;
import kr.gyuna.interview.hexagonal.domain.reference.jobVacancy.JobVacancyId;
import kr.gyuna.interview.hexagonal.domain.reference.resume.ResumeId;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CreateApplyController {

    private final CreateApplyUseCase createApplyUseCase;

    @PostMapping("/v1/applies")
    public ResponseEntity<DefaultResponse> createJobVacancy(
            @RequestBody CreateApplyReq req
    ) throws InvalidTransactionException, JsonProcessingException {
        CreateApplyCommand command = CreateApplyCommand.builder()
                .jobVacancyId(JobVacancyId.of(req.getJobVacancyId()))
                .resumeId(ResumeId.of(req.getResumeId()))
                .build();

        DefaultResponse response =
                createApplyUseCase.createApply(command);

        return new ResponseEntity<>(
                response,
                HttpStatus.OK
        );
    }
}
