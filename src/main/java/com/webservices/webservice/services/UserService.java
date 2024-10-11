package com.webservices.webservice.services;

import com.webservices.webservice.entities.User;
import com.webservices.webservice.exceptions.DatabaseException;
import com.webservices.webservice.exceptions.ResourceNotFoundException;
import com.webservices.webservice.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
        return user.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User registerUser(User newUser){
        return userRepository.save(newUser);
    }

    public void deleteUser(Long id){
        try{
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }

     public User updateUser(Long id, User uptUser){
        try {
            User user = userRepository.getReferenceById(id);
            updatedData(user, uptUser);
            return userRepository.save(user);
        } catch(EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
     }

     private void updatedData(User user, User uptUser){
        user.setName(uptUser.getName());
        user.setEmail(uptUser.getEmail());
        user.setPhone(uptUser.getPhone());

     }
}
