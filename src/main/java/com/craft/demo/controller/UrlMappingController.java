package com.craft.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.craft.demo.model.UrlMapping;
import com.craft.demo.model.UrlMappingRequest;
import com.craft.demo.service.UrlMappingService;

@RestController
@RequestMapping("/api/urlMappings")
public class UrlMappingController {

    @Autowired
    private UrlMappingService urlMappingService;

    @RequestMapping(method = RequestMethod.GET)
    public List<UrlMapping> getUrlMappings() {
        return urlMappingService.getAllUrlMappings();
    }

    @RequestMapping(method = RequestMethod.POST)
    public UrlMapping requestNewUrlMapping(@RequestBody UrlMappingRequest urlMappingRequest) {
        return urlMappingService.createUrlMapping(urlMappingRequest.getRedirectUrl());
    }

    @RequestMapping(value = "/{shortUrl}", method = RequestMethod.GET)
    public UrlMapping getUrlMappingByShortUrl(@PathVariable String shortUrl) {
        return urlMappingService.getUrlMapping(shortUrl);
    }

}
