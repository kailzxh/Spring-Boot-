package com.example.journelApp.entity;

import com.example.journelApp.JournelApplication;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
@Component
@Document(collection = "Journel_entries")
@Getter
@Setter
public class JournelEntries {
    @Id
    private ObjectId id;
    private String title;
    private String content;
    private LocalDateTime date;


}