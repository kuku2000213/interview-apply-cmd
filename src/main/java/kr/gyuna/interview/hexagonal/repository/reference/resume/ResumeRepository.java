package kr.gyuna.interview.hexagonal.repository.reference.resume;

import kr.gyuna.interview.hexagonal.domain.reference.resume.Resume;
import kr.gyuna.interview.hexagonal.domain.reference.resume.ResumeId;
import org.springframework.data.repository.CrudRepository;

public interface ResumeRepository extends CrudRepository<Resume, ResumeId> {
}
