package com.craft.demo.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedirectController {

    @RequestMapping("/test")
    public void test(HttpServletResponse response) throws IOException {
        response.sendRedirect("https://www.google.com/");
    }

}
