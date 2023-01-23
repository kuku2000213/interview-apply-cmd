package kr.gyuna.interview.hexagonal.application.port.out;

import com.fasterxml.jackson.core.JsonProcessingException;
import kr.gyuna.interview.hexagonal.domain.Apply;

public interface PublishApplyEventPort {

    void newApplyCreated(Apply apply) throws JsonProcessingException;
}
