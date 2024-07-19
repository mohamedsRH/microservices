package com.microservices.libraraymicroservice.model;

import com.commons.commonlib.dto.BookDTO;
import com.commons.commonlib.model.BaseEntityMongoDB;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "libraries")
@Data
public class Library extends BaseEntityMongoDB {

    String name;
    String location;
    List<BookDTO> books  = new ArrayList<>();
}
