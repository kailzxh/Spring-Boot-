package com.example.journelApp.Services;

import com.example.journelApp.Repos.Repo;
import com.example.journelApp.entity.JournelEntries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JournalEntryService {
    @Autowired
    public Repo repo;
   public void saveEntry(JournelEntries journelEntries){
       repo.save(journelEntries);
   }
}
