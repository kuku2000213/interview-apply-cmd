package kr.gyuna.interview.hexagonal.adapter.in.event;

import com.fasterxml.jackson.core.JsonProcessingException;
import kr.gyuna.interview.hexagonal.adapter.in.event.data.ResumeStatusEvent;
import kr.gyuna.interview.hexagonal.application.port.in.reference.resume.CreateResumeCommand;
import kr.gyuna.interview.hexagonal.application.port.in.reference.resume.CreateResumeUseCase;
import kr.gyuna.interview.hexagonal.domain.reference.resume.ResumeId;
import kr.gyuna.interview.hexagonal.domain.reference.resume.ResumeStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import static kr.gyuna.interview.common.Statics.OBJECT_MAPPER;

@RequiredArgsConstructor
@Slf4j
@Component
public class ResumeEventConsumer {

    private final CreateResumeUseCase createResumeUseCase;

    @KafkaListener(topics = "${kafka.topics.resume-status}", groupId = "${kafka.consumer.group-id}")
    private void listen(String message) throws JsonProcessingException{
        log.info("ResumeEvent: " + message);

        ResumeStatusEvent event = OBJECT_MAPPER.readValue(message, ResumeStatusEvent.class);

        CreateResumeCommand command = CreateResumeCommand.builder()
                .resumeId(ResumeId.of(event.getResumeId()))
                .resumeStatus(event.getResumeStatus())
                .build();

        createResumeUseCase.createResume(command);
    }
}
