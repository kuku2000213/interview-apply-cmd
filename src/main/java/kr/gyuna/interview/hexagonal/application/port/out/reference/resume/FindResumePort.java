package kr.gyuna.interview.hexagonal.application.port.out.reference.resume;

import kr.gyuna.interview.hexagonal.domain.reference.resume.Resume;
import kr.gyuna.interview.hexagonal.domain.reference.resume.ResumeId;

public interface FindResumePort {
    Resume findResumeById(ResumeId resumeId);

    Resume findCreatedResumeById(ResumeId resumeId);
}
