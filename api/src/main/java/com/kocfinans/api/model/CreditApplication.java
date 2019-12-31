package com.kocfinans.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
public class CreditApplication {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private UUID id;

    @JsonIgnore
    @ManyToOne
    private User user;

    private float creditLimit;

    private boolean status;

    private String message;

    @CreationTimestamp
    private Date created;

    @UpdateTimestamp
    private Date updated;

}
