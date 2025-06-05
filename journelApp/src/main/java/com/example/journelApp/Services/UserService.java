package com.example.journelApp.Services;
import com.example.journelApp.Repos.UserRepo;
import com.example.journelApp.entity.Users;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public class UserService {
    @Autowired
    public UserRepo userrepo;
   public void saveEntry(Users user){
       userrepo.save(user);
   }
   public List<Users> getAll(){
       return userrepo.findAll();
   }
   public Optional<Users> getById(ObjectId id){
       return userrepo.findById(id);
   }
   public void deleteById(ObjectId id){
       userrepo.deleteById(id);
   }
}