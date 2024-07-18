package com.commons.commonlib.model;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Getter
public class BaseEntityMongoDB {
    @Id
    private String id;

    @CreatedDate
    @Field("ctime")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Field("mtime")
    private LocalDateTime updatedAt;

    public void setId(String id) {
        this.id = id;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
