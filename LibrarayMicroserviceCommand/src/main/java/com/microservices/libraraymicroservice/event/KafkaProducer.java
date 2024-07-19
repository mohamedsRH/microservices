package com.microservices.libraraymicroservice.event;

import com.commons.commonlib.event.Event;
import com.commons.commonlib.event.LibraryEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaProducer {
    private final KafkaTemplate<String, LibraryEvent> kafkaTemplate;
    private final String topic = "LIBRARY_EVENT_TOPIC";

    public void produceEvent(LibraryEvent libraryEvent) {
        kafkaTemplate.send(topic, libraryEvent.type().toString() , libraryEvent);
    }
}
