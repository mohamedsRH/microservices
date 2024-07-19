package com.microservices.bookmicroservice.model;

import com.commons.commonlib.model.BaseEntityMySQL;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Book extends BaseEntityMySQL {

    String name;
    BookCategory bookCategory;
    String libraryId;
}
