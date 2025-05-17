package com.example.journelApp.controller;

import com.example.journelApp.entity.JournelEntries;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController

@RequestMapping("/journal")
public class JournelEntryController {
    public Map<Long, JournelEntries> journelEntries = new HashMap<>();

    @GetMapping
    public ArrayList<JournelEntries> getAll(){
        return new ArrayList<>(journelEntries.values());
    }

    @PostMapping
    public  boolean createEntry(@RequestBody JournelEntries entry){
        journelEntries.put(entry.getId(), entry);
        return true;
    }
    @GetMapping("/id/{myid}")
    public JournelEntries getid(@PathVariable long myid){
        return journelEntries.get(myid);
    }
    @PutMapping("/id/{myid}")
    public void update(@PathVariable long myid,@RequestBody JournelEntries entry){
        journelEntries.put(myid, entry);
    }
    @DeleteMapping("/id/{myid}")
    public void delete(@PathVariable long myid){
        journelEntries.remove(myid);
    }
}
