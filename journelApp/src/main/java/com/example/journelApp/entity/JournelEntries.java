package com.example.journelApp.entity;

import com.example.journelApp.JournelApplication;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.lang.classfile.instruction.StackInstruction;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Component
@Document(collation = "Journel_entries")
public class JournelEntries {
    @Id
    private ObjectId id;
    private String Title;
    private String Content;
    private LocalDateTime date;

    public ObjectId getId() {

        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }



}
