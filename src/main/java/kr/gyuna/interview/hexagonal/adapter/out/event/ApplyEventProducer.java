package kr.gyuna.interview.hexagonal.adapter.out.event;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kr.gyuna.interview.hexagonal.adapter.out.event.data.ApplyStatusEvent;
import kr.gyuna.interview.hexagonal.application.port.out.PublishApplyEventPort;
import kr.gyuna.interview.hexagonal.domain.Apply;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ApplyEventProducer implements PublishApplyEventPort {

    @Value("${kafka.topics.apply-status}")
    private String topic;

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void newApplyCreated(Apply apply) throws JsonProcessingException {
        ApplyStatusEvent event = apply.toApplyStatusEvent();

        String message = objectMapper.writeValueAsString(event);

        kafkaTemplate.send(this.topic, message);
    }
}
