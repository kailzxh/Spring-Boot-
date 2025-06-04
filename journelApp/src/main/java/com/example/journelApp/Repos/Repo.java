package com.example.journelApp.Repos;

import com.example.journelApp.entity.JournelEntries;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface Repo extends MongoRepository<JournelEntries,ObjectId > {
}