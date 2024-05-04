package com.operation.CRUD.Controller;

import com.operation.CRUD.Entity.User;
import com.operation.CRUD.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    @Autowired
    UserService userService;

    @GetMapping("/home")
    public String getUser(Model model){
        model.addAttribute("User", userService.getAllUser());
        return "User";
    }

    @GetMapping("/home/addUser")
    public String addUser(User user){
        return "addUser";
    }

    @PostMapping("/home/addUser")
    public String addUserData(User user){
        userService.addUser(user);
        return "redirect:/home";
    }

    @GetMapping("/home/delete/{id}")
    public String deleteUser(@PathVariable long id){
        userService.removeById(id);
        return "redirect:/home";
    }

    @GetMapping("/home/update/{id}")
    public String updateUser(@PathVariable long id, Model model){
        User user = userService.getUserById(id).get();
        user.setId(user.getId());
        user.setAge(user.getAge());
        user.setName(user.getName());
        user.setPhoneNo(user.getPhoneNo());

        model.addAttribute("user", user);
        return "addUser";
    }
}
