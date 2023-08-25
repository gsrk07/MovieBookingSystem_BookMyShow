package com.scaler.BookMyShow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter // to automatically get all getters
@Setter // to automatically get all setters
@MappedSuperclass // this annotation indicates that it is the super model for all classes and we will not
// be creating a table for this class.
public class BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @CreatedDate
    @Temporal(value = TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Temporal(value = TemporalType.TIMESTAMP)
    private LocalDateTime updatedAt;

    /***
     *
     * In general, we will create our getters and setters here in this fashion. Now, we instead of creating
     * the getters and setters, let us use the annotations from Spring as Lombok.
     *
     * using Lombok, we can simply use 2 annotations @Getter and @Setter which will at compile time of class automatically add these getters
     * and setters to our code. and we dont need to make it visible in the code thus reducing the length of the code.
     * @return
     */
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public LocalDateTime getCreatedAt() {
//        return createdAt;
//    }
//
//    public void setCreatedAt(LocalDateTime createdAt) {
//        this.createdAt = createdAt;
//    }
//
//    public LocalDateTime getUpdatedAt() {
//        return updatedAt;
//    }
//
//    public void setUpdatedAt(LocalDateTime updatedAt) {
//        this.updatedAt = updatedAt;
//    }
}
