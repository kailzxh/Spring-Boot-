package com.example.journelApp.controller;

import com.example.journelApp.Services.JournalEntryService;
import com.example.journelApp.entity.JournelEntries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
@RestController

@RequestMapping("/journal")
public class JournalEntryController {
        @Autowired
        private JournalEntryService journalEntryService;

        @GetMapping
        public ArrayList<JournelEntries> getAll(){
            return null;
        }

        @PostMapping
        public  boolean createEntry(@RequestBody JournelEntries entry){
            journalEntryService.saveEntry(entry);
            return true;
        }
        @GetMapping("/id/{myid}")
        public JournelEntries getid(@PathVariable long myid){
            return null;
        }
        @PutMapping("/id/{myid}")
        public void update(@PathVariable long myid,@RequestBody JournelEntries entry){

        }
        @DeleteMapping("/id/{myid}")
        public void delete(@PathVariable long myid){

        }
}


