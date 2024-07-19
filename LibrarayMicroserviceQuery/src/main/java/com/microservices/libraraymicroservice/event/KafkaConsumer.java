package com.microservices.libraraymicroservice.event;

import com.commons.commonlib.event.Event;
import com.commons.commonlib.event.LibraryEvent;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaConsumer {

    private final LibraryEventHandler bookEventHandler;
    private final String topic = "LIBRARY_EVENT_TOPIC";

    @KafkaListener(topics = topic, groupId = "book-group")
    public void consume(ConsumerRecord<String, LibraryEvent> consumerRecord) {
        LibraryEvent event = consumerRecord.value();

        switch (consumerRecord.key()) {
            case "CREATED_LIBRARY_EVENT":
                bookEventHandler.handleBookCreatedEvent(event.libraryDTO());
                break;
            case "UPDATED_LIBRARY_EVENT":
                bookEventHandler.handleBookUpdatedEvent(event.libraryDTO());
                break;
            case "DELETED_LIBRARY_EVENT":
                bookEventHandler.handleBookDeletedEvent(event.libraryDTO().getId());
                break;
            default:
                break;
        }

    }
}