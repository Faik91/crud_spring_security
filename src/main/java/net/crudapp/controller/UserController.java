package net.crudapp.controller;

import net.crudapp.model.User;
import net.crudapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

//    @RequestMapping(value = "login", method = RequestMethod.GET)
//    public String loginPage() {
//        return "login";
//    }

    @GetMapping
    public String userPage(Model model) {

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);


        return "/userData";
    }

////    @PostMapping("/logout")
////    public String logoutPage(){
////        return "hello";
////    }
////
////    @GetMapping("/")
////    public String loginPage(){
////        return "hello";
////    }
////
//    @RequestMapping(value = "/users", method = RequestMethod.GET)
//    public String ListUsers(Model model){
//        model.addAttribute("user", new User());
//        model.addAttribute("listUsers", this.userService.allUsers());
//        return "/users";
//    }
//
//    @RequestMapping(value = "/users/add", method = RequestMethod.POST)
//    public String addUser(@ModelAttribute("user") User user){
//        if (user.getId() == 0){
//            this.userService.addUser(user);
//        }else {
//            this.userService.editUser(user);
//        }
//
//        return "redirect:/user/users";
//    }
//
//    @RequestMapping("/remove/{id}")
//    public String removeUser(@PathVariable("id") int id){
//        this.userService.deleteUser(id);
//
//        return "redirect:/user/users";
//    }
//
//    @RequestMapping("/editUser/{id}")
//    public String editUser(@PathVariable("id") int id, Model model){
//        model.addAttribute("user", this.userService.getUserById(id));
//        model.addAttribute("listUsers", this.userService.allUsers());
//
//        return "users";
//
//    }
//
//    @RequestMapping("/userData/{id}")
//    public String userData(@PathVariable("id") int id, Model model){
//        model.addAttribute("user", this.userService.getUserById(id));
//        return "/userData";
//    }
}
