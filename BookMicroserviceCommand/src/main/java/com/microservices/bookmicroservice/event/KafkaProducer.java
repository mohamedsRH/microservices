package com.microservices.bookmicroservice.event;

import com.commons.commonlib.event.Event;
import com.commons.commonlib.event.TOPIC;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaProducer {
    private final KafkaTemplate<String, Event> kafkaTemplate;
    private final String topic = "BOOK_EVENT_TOPIC";

    public void produceEvent(Event bookEvent) {
        kafkaTemplate.send(topic, bookEvent.type().toString() , bookEvent);
    }
}
