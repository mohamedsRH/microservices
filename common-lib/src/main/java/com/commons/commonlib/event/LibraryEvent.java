package com.commons.commonlib.event;

import com.commons.commonlib.dto.BookDTO;
import com.commons.commonlib.dto.LibraryDTO;

import java.time.LocalDateTime;

public record LibraryEvent(EventType type, LibraryDTO libraryDTO, LocalDateTime eventCreatedAt) {
}
