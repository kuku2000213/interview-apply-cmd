package kr.gyuna.interview.hexagonal.application.port.out.reference.resume;

import kr.gyuna.interview.hexagonal.domain.reference.resume.Resume;

public interface CreateResumePort {

    Resume createResume(Resume resume);
}
