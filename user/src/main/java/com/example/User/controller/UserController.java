package com.example.User.controller;
import com.example.User.Entity.UserEntity;
import com.example.User.service.UserService;
import com.example.User.vo.ResponseTemplateVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/user", produces = "application/json")
@Tag(name = "Crud Opertion of User API", description = "User API")
public class UserController {
    @Autowired
    private UserService userService;

    @Operation(summary = "Save User", description = "Save User")
    @ApiResponse(responseCode = "200", description = "Success")

    @PostMapping("/saveUser")
    public UserEntity saveUser(@RequestBody UserEntity user){
        return userService.saveUser(user);
    }
@Operation(summary = "Get User With Item by providing the user id", description = "Get User With Item")
@ApiResponse(responseCode = "200", description = "Success")

    @GetMapping("/{userId}")
    public ResponseTemplateVo getUserWithItem(@PathVariable("userId") Long userId) {
        return userService.getUserWithItem(userId);
    }


}
