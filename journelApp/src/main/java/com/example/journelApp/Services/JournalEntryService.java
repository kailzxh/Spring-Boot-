package com.example.journelApp.Services;
import com.example.journelApp.Repos.Repo;
import com.example.journelApp.entity.JournelEntries;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
@Component
public class JournalEntryService {
    @Autowired
    public Repo repo;
   public void saveEntry(JournelEntries journelEntries){
       repo.save(journelEntries);
   }
   public List<JournelEntries> getAll(){
       return repo.findAll();
   }
   public Optional<JournelEntries> getById(ObjectId id){
       return repo.findById(id);
   }
   public void deleteById(ObjectId id){
       repo.deleteById(id);
   }
}