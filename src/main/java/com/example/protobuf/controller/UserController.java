package com.example.protobuf.controller;

import com.example.protobuf.model.User;
import com.example.protobuf.model.UserModel;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author shrey
 */
@RestController
public class UserController {
  @PostMapping(path ="/api/user",consumes = {"application/json"},produces = {"application/x-protobuf"})
  public User.user saveUser(@RequestBody UserModel user) throws FileNotFoundException, IOException {
      User.user userSave = User.user.newBuilder().setId(user.getId()).setName(user.getName()).build();
      FileOutputStream output = new FileOutputStream("src/main/resources/user.txt");
      userSave.writeTo(output);
      return userSave;
  }

}
