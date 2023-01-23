package kr.gyuna.interview.hexagonal.application.service.reference.jobVacancy;

import jakarta.transaction.Transactional;
import kr.gyuna.interview.common.response.DefaultResponse;
import kr.gyuna.interview.hexagonal.application.port.in.reference.jobVacancy.CreateJobVacancyCommand;
import kr.gyuna.interview.hexagonal.application.port.in.reference.jobVacancy.CreateJobVacancyUseCase;
import kr.gyuna.interview.hexagonal.application.port.out.reference.jobVacancy.CreateJobVacancyPort;
import kr.gyuna.interview.hexagonal.domain.reference.jobVacancy.JobVacancy;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class CreateJobVacancyService implements CreateJobVacancyUseCase {

    private final CreateJobVacancyPort createJobVacancyPort;


    @Override
    public DefaultResponse createJobVacancy(CreateJobVacancyCommand command) {

        JobVacancy jobVacancy = createJobVacancyPort
                .createJobVacancy(command.toEntity());

        return new DefaultResponse(
                HttpStatus.CREATED.value(),
                "회원이 정상적으로 등록되었습니다.",
                jobVacancy.toJobVacancyId().toString()
        );
    }
}
