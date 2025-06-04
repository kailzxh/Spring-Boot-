package com.example.journelApp.controller;

import com.example.journelApp.Services.JournalEntryService;
import com.example.journelApp.entity.JournelEntries;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController

@RequestMapping("/journal")
public class JournalEntryController {
        @Autowired
        private JournalEntryService journalEntryService;

        @GetMapping
        public List<JournelEntries> getAll(){
            return journalEntryService.getAll();
        }

        @PostMapping
        public  boolean createEntry(@RequestBody JournelEntries entry){
                entry.setDate(LocalDateTime.now());
                journalEntryService.saveEntry(entry);
                return true;
        }

        @GetMapping("/id/{myid}")
        public JournelEntries getById(@PathVariable ObjectId myid){
            return journalEntryService.getById(myid).orElse(null);
        }

        @PutMapping("/id/{myid}")
        public boolean update(@PathVariable ObjectId myid, @RequestBody JournelEntries newentry) {
                JournelEntries old = journalEntryService.getById(myid).orElse(null);
                if (old != null) {
                        if (newentry.getTitle() != null && !newentry.getTitle().isEmpty()) {
                                old.setTitle(newentry.getTitle());
                        }
                        if ((newentry.getContent() != null && !newentry.getContent().isEmpty())){
                                old.setContent(newentry.getContent());}
                        journalEntryService.saveEntry(old);
                        return true;
                }
                return false;
        }

        @DeleteMapping("/id/{myid}")
        public boolean delete(@PathVariable ObjectId myid){
                journalEntryService.deleteById(myid);
                return true;
        }
}