package com.webservices.webservice.services;

import com.webservices.webservice.entities.User;
import com.webservices.webservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User findUserById(Long id){
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }

    public User registerUser(User newUser){
        return userRepository.save(newUser);
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

     public User updateUser(Long id, User uptUser){
        User user = userRepository.getReferenceById(id);
        updatedData(user, uptUser);
        return userRepository.save(user);
     }

     private void updatedData(User user, User uptUser){
        user.setName(uptUser.getName());
        user.setEmail(uptUser.getEmail());
        user.setPhone(uptUser.getPhone());

     }
}
