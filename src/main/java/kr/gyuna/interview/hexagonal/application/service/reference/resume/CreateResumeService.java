package kr.gyuna.interview.hexagonal.application.service.reference.resume;

import jakarta.transaction.Transactional;
import kr.gyuna.interview.common.response.DefaultResponse;
import kr.gyuna.interview.hexagonal.application.port.in.reference.resume.CreateResumeCommand;
import kr.gyuna.interview.hexagonal.application.port.in.reference.resume.CreateResumeUseCase;
import kr.gyuna.interview.hexagonal.application.port.out.reference.resume.CreateResumePort;
import kr.gyuna.interview.hexagonal.domain.reference.resume.Resume;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class CreateResumeService implements CreateResumeUseCase {

    private final CreateResumePort createResumePort;


    @Override
    public DefaultResponse createResume(CreateResumeCommand command) {
        Resume resume =
                createResumePort.createResume(command.toEntity());

        return new DefaultResponse(
                HttpStatus.CREATED.value(),
                "이력서가 정상적으로 등록되었습니다.",
                resume.toResumeId().toString()
        );
    }
}
