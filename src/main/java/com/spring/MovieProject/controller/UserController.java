package com.spring.MovieProject.controller;

import com.spring.MovieProject.entity.Role;
import com.spring.MovieProject.entity.User;
import com.spring.MovieProject.exception.UserNotFoundException;
import com.spring.MovieProject.service.role.roleServiceImpl;
import com.spring.MovieProject.service.user.userServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Iterator;
import java.util.List;

@Controller
public class UserController {


    private roleServiceImpl roleService;
    private userServiceImpl userService;

    public UserController(roleServiceImpl roleService, userServiceImpl userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @PostMapping("/v1/signUp")
    public String signUpUser(User user,Role role) {

        userService.signUp(user);
        System.out.println(user);
        return "redirect:/v1/popular/1";
    }

    @GetMapping("/v1/signUser")
    public String signUp(Model model, User user) {
        List<Role> roles = roleService.roleList();
        model.addAttribute("User", user);
        model.addAttribute("Role", roles);
        return "SignUp/signup";
    }


    @GetMapping("/v1/userList")
    public String getUserList(Model model, User user) {

        List<User> usersList = userService.listUsers();

        model.addAttribute("usersList", usersList);
        return "List/userList";
    }

    @GetMapping("/v1/deleteUser/{id}")
    public String deleteUserById(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) throws UserNotFoundException {

        userService.deleteUser(id);
        redirectAttributes.addFlashAttribute("result", "해당하는 유저가 삭제되었습니다. :" + id);
        return "redirect:/v1/userList";
    }



}
