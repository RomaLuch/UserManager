package com.luchinsky.usermanager.controller;

import com.luchinsky.usermanager.model.User;
import com.luchinsky.usermanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by RLuchinsky on 03.02.2017.
 */
@Controller
public class UserController {

    private UserService userService;
    static int page =0;

    @Autowired(required = true)
    @Qualifier(value = "userService")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "users", method = RequestMethod.GET)
    public String listUsers(Model model){

        model.addAttribute("user", new User());
        List userslist = this.userService.listUsers(page);
        model.addAttribute("listUsers", userslist);

        return "users";
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user){
        if(user.getId() == 0){
            this.userService.addUser(user);
        }else {
            this.userService.updateUser(user);
        }

        return "redirect:/users";
    }

    @RequestMapping("/remove/{id}")
    public String removeUser(@PathVariable("id") int id){
        this.userService.removeUser(id);

        return "redirect:/users";
    }

    @RequestMapping("edit/{id}")
    public String editUser(@PathVariable("id") int id, Model model){
        model.addAttribute("user", this.userService.getUserById(id));
        model.addAttribute("listUsers", this.userService.listUsers(page));

        return "users";
    }

    @RequestMapping("userdata/{id}")
    public String userData(@PathVariable("id") int id, Model model){
        model.addAttribute("user", this.userService.getUserById(id));

        return "userdata";
    }
// search by id
    @RequestMapping(value = "userdata/data")
    public String searhData(int id, Model model) {
        userData(id, model);

        return "userdata";
    }
// add 10 users
    @RequestMapping(value = "/users/add10users", method = RequestMethod.POST)
    public String fullUser(){
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setUserName("userName "+i);
            user.setUserAge(i);
            user.setUserIsAdmin(false);
            Date date = new Date();
            user.setUserCreatedData(new Timestamp(date.getTime()));
            this.userService.addUser(user);
        }

        return "redirect:/users";
    }

    //paging realization

    @RequestMapping(value = "users/{act}", method = RequestMethod.GET)
    public String paging(@PathVariable("act") int act, Model model){

        if(act==1 ) page+=5;
        if(act==-1 && page>=5) page-=5;
        model.addAttribute("user", new User());
        List userslist = this.userService.listUsers(page);
        model.addAttribute("listUsers", userslist);
        if(userslist.size()==0) page=0;
        return "redirect:/users";
    }

    //search by name

    @RequestMapping(value = "userdata/name", method = RequestMethod.GET)
    public String searhDatabyName(@RequestParam("name") String name, Model model) {
        int start = 0;
        List <User> allusers = this.userService.listUsers(start);
        List userList = this.userService.listUsers(start);
        while (userList.size()!=0)
        {
            start+=5;
            userList = this.userService.listUsers(start);
            allusers.addAll(userList);
        }

       for (User user: allusers)
       {
           if(user.getUserName().equals(name)) {
               userData(user.getId(), model);
               break;
           }
       }
        return "userdata";
    }

}