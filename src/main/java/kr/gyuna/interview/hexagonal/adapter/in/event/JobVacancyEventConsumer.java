package kr.gyuna.interview.hexagonal.adapter.in.event;

import com.fasterxml.jackson.core.JsonProcessingException;
import kr.gyuna.interview.hexagonal.adapter.in.event.data.JobVacancyStatusEvent;
import kr.gyuna.interview.hexagonal.application.port.in.reference.jobVacancy.CreateJobVacancyCommand;
import kr.gyuna.interview.hexagonal.application.port.in.reference.jobVacancy.CreateJobVacancyUseCase;
import kr.gyuna.interview.hexagonal.domain.reference.jobVacancy.JobVacancyId;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import static kr.gyuna.interview.common.Statics.OBJECT_MAPPER;

@RequiredArgsConstructor
@Slf4j
@Component
public class JobVacancyEventConsumer {

    private final CreateJobVacancyUseCase createJobVacancyUseCase;

    @KafkaListener(topics = "${kafka.topics.jobVacancy-status}", groupId = "${kafka.consumer.group-id}")
    private void listen(String message) throws JsonProcessingException {

        log.info("Consumer.listen: " + message);

        JobVacancyStatusEvent event = OBJECT_MAPPER.readValue(message, JobVacancyStatusEvent.class);

        CreateJobVacancyCommand command = CreateJobVacancyCommand.builder()
                .jobVacancyId(JobVacancyId.of(event.getJobVacancyId()))
                .jobVacancyStatus(event.getJobVacancyStatus())
                .build();

        createJobVacancyUseCase.createJobVacancy(command);
    }

}
