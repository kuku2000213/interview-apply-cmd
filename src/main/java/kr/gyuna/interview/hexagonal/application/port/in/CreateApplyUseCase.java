package kr.gyuna.interview.hexagonal.application.port.in;

import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.transaction.InvalidTransactionException;
import kr.gyuna.interview.common.response.DefaultResponse;

public interface CreateApplyUseCase {
    DefaultResponse createApply(CreateApplyCommand command) throws InvalidTransactionException, JsonProcessingException;
}
