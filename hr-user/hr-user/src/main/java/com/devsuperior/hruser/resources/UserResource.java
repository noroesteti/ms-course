package com.devsuperior.hruser.resources;

import com.devsuperior.hruser.entities.User;
import com.devsuperior.hruser.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/")
    public ResponseEntity<List<User>> findAll(){
        List<User> list = userRepository.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        User obj = userRepository.findById(id).get();
        return ResponseEntity.ok(obj);
    }

    @GetMapping(value = "/search")
    public ResponseEntity<User> findByEmail(@RequestParam String email){
        User obj = userRepository.findByEmail(email);

    }


}
