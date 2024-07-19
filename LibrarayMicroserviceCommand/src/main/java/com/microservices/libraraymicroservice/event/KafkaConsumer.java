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

    private final BookEventHandler bookEventHandler;
    private final String topic = "BOOK_EVENT_TOPIC";

    @KafkaListener(topics = "BOOK_EVENT_TOPIC", groupId = "lbc-book-group")
    public void consume(ConsumerRecord<String, Event> consumerRecord) {
        try {
            Event event = consumerRecord.value();
            System.out.println("Received event: " + event);

            switch (consumerRecord.key()) {
                case "CREATED_BOOK_EVENT":
                    bookEventHandler.handleBookCreatedEvent(event.bookDTO());
                    break;
                case "UPDATED_BOOK_EVENT":
                    bookEventHandler.handleBookUpdatedEvent(event.bookDTO());
                    break;
                case "DELETED_BOOK_EVENT":
                    bookEventHandler.handleBookDeletedEvent(event.bookDTO().getLibrary().getId(), event.bookDTO().getId());
                    break;
                default:
                    System.out.println("Unknown event type: " + consumerRecord.key());
                    break;
            }
        } catch (Exception e) {
            System.err.println("Error processing event: " + e.getMessage());
            e.printStackTrace();
        }
    }

}