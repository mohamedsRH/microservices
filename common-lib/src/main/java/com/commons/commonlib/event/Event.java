package com.commons.commonlib.event;

import com.commons.commonlib.dto.BookDTO;

import java.time.LocalDateTime;

public record Event(EventType type, BookDTO bookDTO, LocalDateTime eventCreatedAt){}
