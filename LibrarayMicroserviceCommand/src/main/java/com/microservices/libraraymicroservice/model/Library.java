package com.microservices.libraraymicroservice.model;

import com.commons.commonlib.model.BaseEntityMongoDB;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "libraries")
@Data
public class Library extends BaseEntityMongoDB {

    String name;
    String location;
}
