package com.example.journelApp.controller;

import com.example.journelApp.Services.JournalEntryService;
import com.example.journelApp.entity.JournelEntries;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        public ResponseEntity<List<JournelEntries>> getAll() {
                List<JournelEntries> entries = journalEntryService.getAll();
                if (entries.isEmpty()) {
                        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204 - No content
                }
                return new ResponseEntity<>(entries, HttpStatus.OK); // 200 - OK
        }


        @PostMapping
        public ResponseEntity<?> createEntry(@RequestBody JournelEntries entry) {
                try {
                        entry.setDate(LocalDateTime.now());
                        journalEntryService.saveEntry(entry);
                        return new ResponseEntity<>("Journal entry created successfully.", HttpStatus.CREATED);
                } catch (Exception e) {
                        return new ResponseEntity<>("Failed to create journal entry.", HttpStatus.INTERNAL_SERVER_ERROR);
                }
        }


        @GetMapping("/id/{myid}")
        public ResponseEntity<JournelEntries> getById(@PathVariable ObjectId myid){
                Optional<JournelEntries> journelEntries = journalEntryService.getById(myid);
                if(journelEntries.isPresent()) {

                        return new ResponseEntity<>(journelEntries.get(), HttpStatus.OK);
                }
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        @PutMapping("/id/{myid}")

        public ResponseEntity<?> update(@PathVariable ObjectId myid, @RequestBody JournelEntries newentry) {
                JournelEntries old = journalEntryService.getById(myid).orElse(null);

                if (old != null) {
                        if (newentry.getTitle() != null && !newentry.getTitle().isEmpty()) {
                                old.setTitle(newentry.getTitle());
                        }
                        if (newentry.getContent() != null && !newentry.getContent().isEmpty()) {
                                old.setContent(newentry.getContent());
                        }
                        journalEntryService.saveEntry(old);
                        return new ResponseEntity<>(true, HttpStatus.OK);
                }

                return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }


        @DeleteMapping("/id/{myid}")
        public ResponseEntity<?> delete(@PathVariable ObjectId myid){
                 journalEntryService.deleteById(myid);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        }
}