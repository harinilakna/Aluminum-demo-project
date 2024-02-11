package com.final_year_project.Aluminium_production_management_system.services;

import com.final_year_project.Aluminium_production_management_system.dto.UserDto;
import com.final_year_project.Aluminium_production_management_system.models.User;
import com.final_year_project.Aluminium_production_management_system.repositaries.User.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.UUID;
@Slf4j
@Service
public class UserServices {
 @Autowired
 UserRepository userRepository;

 public User insert(UserDto userdto) {
  User user = new User();
  UUID uuid= UUID.randomUUID();
  String str= uuid.toString();
  user.setAge(userdto.getAge());
  user.setFirst_name(userdto.getFirstName());
  user.setLast_name(userdto.getLastName());
  user.setEmail(userdto.getEmail());
  user.setPassword(userdto.getPassword());
  user.setId(str);

  return userRepository.save(user);

 }

 public User updateuser(String id, UserDto userdto) {
  //log.info("user id = {}",id);
  User user = userRepository.findById(id).get();
  user.setAge(userdto.getAge());
  user.setFirst_name(userdto.getFirstName());
  user.setLast_name(userdto.getLastName());
  return userRepository.save(user);
 }

 public List<User> getAllUser(){
  return userRepository.findAll();
 }


 public void deleteUser(String id) {
  userRepository.deleteById(id);
 }


 public User getByID(String id) {
  return userRepository.findById(id).get();
 }
}