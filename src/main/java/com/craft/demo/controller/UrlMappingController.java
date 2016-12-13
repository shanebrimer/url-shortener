package com.craft.demo.controller;

import java.util.List;

import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.craft.demo.model.UrlMapping;
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
    public ResponseEntity<UrlMapping> requestNewUrlMapping(@RequestBody UrlMapping urlMappingRequest) {
        UrlValidator urlValidator = UrlValidator.getInstance();
        if (!urlValidator.isValid(urlMappingRequest.getRedirectUrl())) {
            return ResponseEntity.badRequest().body(null);
        }

        UrlMapping urlMappingResponse = null;
        if (urlMappingRequest.getShortUrl() == null) {
            urlMappingResponse = urlMappingService.generateUrlMapping(urlMappingRequest.getRedirectUrl());
        } else {
            urlMappingResponse = urlMappingService.createCustomUrlMapping(urlMappingRequest);
        }

        return ResponseEntity.ok(urlMappingResponse);
    }

    @RequestMapping(value = "/{shortUrl}", method = RequestMethod.GET)
    public UrlMapping getUrlMappingByShortUrl(@PathVariable String shortUrl) {
        return urlMappingService.getUrlMapping(shortUrl);
    }

}
