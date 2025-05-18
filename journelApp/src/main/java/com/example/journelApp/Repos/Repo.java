package com.example.journelApp.Repos;

import com.example.journelApp.entity.JournelEntries;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface Repo extends MongoRepository<JournelEntries,String > {

}