package kr.gyuna.interview.hexagonal.repository;

import kr.gyuna.interview.hexagonal.domain.Apply;
import kr.gyuna.interview.hexagonal.domain.ApplyId;
import org.springframework.data.repository.CrudRepository;

public interface ApplyRepository extends CrudRepository<Apply, ApplyId> {
}
