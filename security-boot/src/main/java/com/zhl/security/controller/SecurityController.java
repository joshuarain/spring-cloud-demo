package com.zhl.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author Lenovo
 * @title: SecurityController
 * @projectName cloud
 * @description: TODO
 * @date 2019/12/11 10:42
 */
@Controller
public class SecurityController {


        @RequestMapping("/index")
        public String index() {
            return "index";
        }

        @RequestMapping("/login")
        public String login() {
          return "login";
        }

        @RequestMapping("/login-error")
        public String loginError(Model model) {
            model.addAttribute( "loginError"  , true);
            return "login";
        }

        @GetMapping("/401")
        public String accessDenied() {
            return "401";
        }

        @GetMapping("/common")
        public String common() {
            return "common";
        }

        @GetMapping("/admin")
        public String admin() {
            return "admin";
        }


    }
