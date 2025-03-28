package com.example.User.service;

import com.example.User.Entity.UserEntity;
import com.example.User.Repository.UserRepo;
import com.example.User.vo.ItemEntity;
import com.example.User.vo.ResponseTemplateVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

@Autowired
private RestTemplate restTemplate;
    public UserEntity saveUser(UserEntity user) {
        return userRepo.save(user);
    }

//getting customer with item id
    public ResponseTemplateVo getUserWithItem(Long userId) {
   ResponseTemplateVo responseTemplateVo=new ResponseTemplateVo();
        UserEntity user=userRepo.findByUserId(userId);
        ItemEntity item=restTemplate.getForObject("http://localhost:9001/item/"+user.getItemId(), ItemEntity.class);
        responseTemplateVo.setItemEntity(item);
        responseTemplateVo.setUser(user);
        return responseTemplateVo;

    }

    public UserEntity updateUser(Long userId, UserEntity user) {
        UserEntity existingUser = userRepo.findByUserId(userId);
        existingUser.setName(user.getName());
        existingUser.setAddress(user.getAddress());
        return userRepo.save(existingUser);
    }
}
