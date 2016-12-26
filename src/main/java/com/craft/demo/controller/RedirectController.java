package com.craft.demo.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.craft.demo.exception.ResourceNotFoundException;
import com.craft.demo.model.UrlMapping;
import com.craft.demo.service.UrlMappingService;

@RestController
public class RedirectController {

    @Autowired
    private UrlMappingService urlMappingService;

    @RequestMapping("/a/{shortUrl}")
    public void redirect(@PathVariable String shortUrl, HttpServletResponse response) throws IOException {
        UrlMapping urlMapping = urlMappingService.getUrlMapping(shortUrl);
        if (urlMapping == null || urlMapping.getRedirectUrl() == null) {
            throw new ResourceNotFoundException();
        }

        response.sendRedirect(urlMapping.getRedirectUrl());
    }

}
