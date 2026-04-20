package org.example.applestore.service;

import org.example.applestore.dto.UserDto;
import org.example.applestore.model.Result;
import org.example.applestore.model.User;
import org.example.applestore.model.entity.RoleEnum;
import org.example.applestore.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    //read all
    public List<User> getall(){
        return userRepo.findAll();
    }
    //read by id
    public User byid(Long id){
        return userRepo.findById(id).get();
    }
    //create
    public Result create(UserDto userDto){
        boolean existsed = userRepo.existsByEmailAndPassword(userDto.getEmail(), userDto.getPassword());
        if (existsed){
            return new Result("siz accountga kirdingiz",true);
        }
        User user = new User();
         user.setFirstname(userDto.getFirstname());
         user.setLastname(userDto.getLastname());
         user.setEmail(userDto.getEmail());
         user.setPassword(userDto.getPassword());
         user.setRole(RoleEnum.USER);
         userRepo.save(user);
         return new Result("saqladi",true);
    }
    //update
    public Result update(Long id , UserDto userDto){
        Optional<User> userOptional = userRepo.findById(id);
        if (userOptional.isPresent()){
            User user = userOptional.get();
            user.setFirstname(userDto.getFirstname());
            user.setLastname(userDto.getLastname());
            user.setEmail(userDto.getEmail());
            user.setPassword(userDto.getPassword());
            user.setRole(RoleEnum.USER);
            userRepo.save(user);
            return new Result("saqladi",true);
        }
        return new Result("id topiladi",false);
    }

    //delete
    public Result delete(Long id){
        Optional<User> optionalUser = userRepo.findById(id);
        if (optionalUser.isPresent()){
            User user = optionalUser.get();
            userRepo.delete(user);
            return new Result("ochirildi",true);
        }
        return new Result("ozgartirildi",false);
    }
}
