package com.batuhan.Java3Monolithic.controller;


import com.batuhan.Java3Monolithic.dto.request.LoginRequestDto;
import com.batuhan.Java3Monolithic.dto.request.UserSaveRequestDto;
import com.batuhan.Java3Monolithic.exception.Error;
import com.batuhan.Java3Monolithic.exception.MonolitikTekrarManagerException;
import com.batuhan.Java3Monolithic.repository.entity.EGender;
import com.batuhan.Java3Monolithic.repository.entity.User;
import com.batuhan.Java3Monolithic.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/login")
public class LoginMvcController {

    private final UserService userService;

    @GetMapping("/registerpage")
    public ModelAndView register(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("genders", EGender.values());
        modelAndView.setViewName("register");
        return modelAndView;
    }
    @PostMapping("/doregister")
    public ModelAndView doRegister(UserSaveRequestDto dto){
        userService.saveRequestDto(dto);
        return new ModelAndView("redirect:loginpage");
    }
    @GetMapping("/loginpage")
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }
    @PostMapping("/dologin")
    public ModelAndView doLogin(LoginRequestDto dto){
        ModelAndView modelAndView = new ModelAndView();
        Optional<User> user = userService.login(dto.getUsername(), dto.getPassword());

        if (user.isPresent()){
            modelAndView.addObject("user", userService.findById(user.get().getId()).get());
            // System.out.println(userService.findById(user.get().getId()).get().getGender());
            modelAndView.setViewName("home");
        }

        else{
            modelAndView.setViewName("login");
            throw new MonolitikTekrarManagerException(Error.USER_NOT_FOUND);
        }
        return modelAndView;
    }
}
