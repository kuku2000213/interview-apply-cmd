package kr.gyuna.interview.hexagonal.adapter.out.persistence.reference;

import jakarta.transaction.Transactional;
import kr.gyuna.interview.hexagonal.application.port.out.reference.resume.CreateResumePort;
import kr.gyuna.interview.hexagonal.application.port.out.reference.resume.FindResumePort;
import kr.gyuna.interview.hexagonal.domain.reference.resume.Resume;
import kr.gyuna.interview.hexagonal.domain.reference.resume.ResumeId;
import kr.gyuna.interview.hexagonal.repository.reference.resume.ResumeDSL;
import kr.gyuna.interview.hexagonal.repository.reference.resume.ResumeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
@Transactional
public class ResumePersistenceAdapter implements
        FindResumePort,
        CreateResumePort
{

    private final ResumeRepository resumeRepository;
    private final ResumeDSL resumeDSL;

    @Override
    public Resume findResumeById(ResumeId resumeId) {

        Optional<Resume> resumeOpt =
                resumeRepository.findById(resumeId);

        return resumeOpt.orElseThrow(() ->
                new NullPointerException("해당 이력서가 존재하지 않습니다.")
        );
    }

    @Override
    public Resume findCreatedResumeById(ResumeId resumeId) {

        Optional<Resume> resumeOpt =
                resumeDSL.findCreatedResumeById(resumeId);

        return resumeOpt.orElseThrow(() ->
                new NullPointerException("해당 이력서가 등록되지 않았거나, 삭제되었습니다.")
        );
    }

    @Override
    public Resume createResume(Resume resume) {

        Resume createdResume =
                resumeRepository.save(resume);

        return createdResume;
    }
}
