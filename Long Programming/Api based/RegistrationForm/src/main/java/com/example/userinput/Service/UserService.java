package com.example.userinput.Service;

import com.example.userinput.Model.UserModel;
import com.example.userinput.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;
    public String addData(UserModel userModel){
        userRepo.save(userModel);
     return "data saved";
    }
}
