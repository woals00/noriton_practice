package com.webcamp5.foodhandongserver.service;


import com.webcamp5.foodhandongserver.model.User;
import com.webcamp5.foodhandongserver.model.request.UserCreationRequest;
import com.webcamp5.foodhandongserver.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User readUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        }

        throw new EntityNotFoundException(
                "Cant find any user under given ID");
    }

    public List<User> readUsers(){
        return userRepository.findAll();
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User createUser (UserCreationRequest request) {
        User user = new User();
        BeanUtils.copyProperties(request, user);
        return userRepository.save(user);
    }

    public User updateUser(Long id, UserCreationRequest request){
        Optional<User> optionalUser = userRepository.findById(id);
        if(!optionalUser.isPresent()){
            throw new EntityNotFoundException("User not present in the database.");
        }
        User user = optionalUser.get();
        user.setName(request.getName());
        return userRepository.save(user);
    }
}
