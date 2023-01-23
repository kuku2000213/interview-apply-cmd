package kr.gyuna.interview.hexagonal.adapter.out.persistence;

import jakarta.transaction.InvalidTransactionException;
import jakarta.transaction.Transactional;
import kr.gyuna.interview.hexagonal.application.port.out.CreateApplyPort;
import kr.gyuna.interview.hexagonal.application.port.out.DeleteApplyPort;
import kr.gyuna.interview.hexagonal.application.port.out.FindApplyPort;
import kr.gyuna.interview.hexagonal.domain.Apply;
import kr.gyuna.interview.hexagonal.domain.ApplyId;
import kr.gyuna.interview.hexagonal.repository.ApplyDSL;
import kr.gyuna.interview.hexagonal.repository.ApplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Transactional
@Component
public class ApplyPersistenceAdapter implements
        CreateApplyPort,
        FindApplyPort,
        DeleteApplyPort
{

    private final ApplyRepository applyRepository;
    private final ApplyDSL applyDSL;

    @Override
    public Apply createApply(Apply apply) {

        Apply createdApply =
                applyRepository.save(apply);

        return createdApply;
    }

    @Override
    public void checkExistingApply(Apply apply) throws InvalidTransactionException {
        Optional<Apply> applyOpt =
                applyDSL.findApplyByJobVacancyIdAndResumeId(apply.toJobVacancyId(), apply.toResumeId());

        if(applyOpt.isPresent()){
            throw new InvalidTransactionException("중복 지원할 수 없습니다.");
        }
    }

    @Override
    public Apply findApplyById(ApplyId applyId) {
        Optional<Apply> applyOpt =
                applyRepository.findById(applyId);

        return applyOpt.orElseThrow(() ->
                new NullPointerException("해당 입사지원이 존재하지 않습니다.")
        );
    }

    @Override
    public void deleteApplyById(ApplyId applyId) {
        applyRepository.deleteById(applyId);
    }
}
