package com.final_year_project.Aluminium_production_management_system.controller;

import com.final_year_project.Aluminium_production_management_system.dto.UserDto;
import com.final_year_project.Aluminium_production_management_system.models.User;
import com.final_year_project.Aluminium_production_management_system.repositaries.User.UserRepository;
import com.final_year_project.Aluminium_production_management_system.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:4200") //for retrieve data from api
public class UserController {

    @Autowired
    UserServices userServices;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/insert")
    public @ResponseBody
    UserDto getInfo(@RequestBody UserDto request) {
        UserDto userdto = new UserDto();
        User response = userServices.insert(request);
        userdto.setAge(response.getAge());
        userdto.setFirstName(response.getFirst_name());
        userdto.setLastName(response.getLast_name());
        userdto.setPassword(response.getPassword());
        userdto.setEmail(response.getEmail());
        userdto.setId(response.getId());

        return userdto;
    }


    @PutMapping("/update/{id}")
    public @ResponseBody
    UserDto updateuser(@PathVariable String id, @RequestBody UserDto request) {
        UserDto userdto = new UserDto();
        User response = userServices.updateuser(id, request);
        userdto.setAge(response.getAge());
        userdto.setFirstName(response.getFirst_name());
        userdto.setLastName(response.getLast_name());
        userdto.setId(response.getId());

        return userdto;

    }

    @GetMapping("/view")
    public @ResponseBody
    List<UserDto> getAllUser() {
        List<User> userList = userServices.getAllUser();
        List<UserDto> userDtoList = new ArrayList<>();
        for (User user : userList) {
            UserDto userDto = new UserDto();
            userDto.setId(user.getId());
            userDto.setAge(user.getAge());
            userDto.setFirstName(user.getFirst_name());
            userDto.setLastName(user.getLast_name());
            userDtoList.add(userDto);
        }

        return userDtoList;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable("id") String id) {
        userServices.deleteUser(id);
    }

    /*@GetMapping("/getById/{id}")
    public Optional<User> findById(@PathVariable ("id") String id) {
        return userServices.findById(id);

    }
*/
    @GetMapping("/getById/{id}")
    public @ResponseBody
    UserDto getUser(@PathVariable("id") String id) {
        User user = userServices.getByID(id);
        UserDto userDto = new UserDto();
        userDto.setFirstName(user.getFirst_name());
        userDto.setLastName(user.getLast_name());
        userDto.setAge(user.getAge());
        userDto.setId(user.getId());
        return userDto;
    }

   
}
