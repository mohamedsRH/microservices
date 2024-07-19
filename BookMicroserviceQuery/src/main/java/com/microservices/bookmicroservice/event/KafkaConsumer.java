package com.microservices.bookmicroservice.event;

import com.commons.commonlib.event.Event;
import com.commons.commonlib.event.EventType;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaConsumer {

    private final BookEventHandler bookEventHandler;
    private final String topic = "BOOK_EVENT_TOPIC";

    @KafkaListener(topics = topic, groupId = "book-group")
    public void consume(ConsumerRecord<String, Event> consumerRecord) {
        Event event = consumerRecord.value();

        switch (consumerRecord.key()) {
            case "CREATED_BOOK_EVENT":
                bookEventHandler.handleBookCreatedEvent(event.bookDTO());
                break;
            case "UPDATED_BOOK_EVENT":
                bookEventHandler.handleBookUpdatedEvent(event.bookDTO());
                break;
            case "DELETED_BOOK_EVENT":
                bookEventHandler.handleBookDeletedEvent(event.bookDTO().getId());
                break;
            default:
                break;
        }

    }
}