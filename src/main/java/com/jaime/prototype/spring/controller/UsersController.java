package com.jaime.prototype.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jaime.prototype.dao.UserDao;
import com.jaime.prototype.dao.impl.UserDaoImpl;

@Controller
public class UsersController {
    
    @Autowired
    private UserDao userDao;
    
    
    @RequestMapping(value="/users", method = RequestMethod.GET)
    public ModelAndView getUsers() {
        
        List <String> list = getUserList();
        
        ModelAndView model = new ModelAndView("user_list");
        
        model.addObject("userlist",list);
        
        return model;
        
        
        
    }

    private List<String> getUserList() {
        
        
        
        
        List<String> userList = userDao.getUsersForSelection();
        
        return userList;
    }
    

}
