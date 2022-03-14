package com.notes.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "notes")
public class Notes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String message;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }
}
