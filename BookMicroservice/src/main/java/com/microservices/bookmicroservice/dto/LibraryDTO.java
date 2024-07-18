package com.microservices.bookmicroservice.dto;

import lombok.Getter;

@Getter
public class LibraryDTO {
    String id;
    String name;
    String location;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
