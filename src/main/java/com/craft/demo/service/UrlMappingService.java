package com.craft.demo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.craft.demo.exception.EntityIdConflictException;
import com.craft.demo.exception.ResourceNotFoundException;
import com.craft.demo.model.UrlMapping;
import com.craft.demo.repository.UrlMappingRepository;

@Service
public class UrlMappingService {

    private static final Logger log = LoggerFactory.getLogger(UrlMappingService.class);

    @Autowired
    private EncoderService encoderService;
    @Autowired
    private UrlMappingRepository urlMappingRepository;

    @Value("${url.encoding.alphabet}")
    private String alphabet;

    @Value("${url.encoding.maxLength}")
    private int maxLength;

    @Value("${url.generator.maxRetryAttempts}")
    private int maxRetryAttempts;

    public List<UrlMapping> getAllUrlMappings() {
        return (List<UrlMapping>) urlMappingRepository.findAll();
    }

    public UrlMapping getUrlMapping(String shortUrl) {
        return urlMappingRepository.findOne(shortUrl);
    }

    public UrlMapping generateUrlMapping(String redirectUrl) {
        for (int i = 0; i < maxRetryAttempts; i++) {
            String shortUrl = encoderService.getRandomEncodedString(alphabet, maxLength);
            UrlMapping urlMapping = new UrlMapping(shortUrl, redirectUrl);

            if (saveUrlMapping(urlMapping)) {
                return urlMapping;
            }
        }

        throw new EntityIdConflictException("failed to generate a shortUrl not already in use");
    }

    public UrlMapping createCustomUrlMapping(UrlMapping customUrlMapping) {
        if (saveUrlMapping(customUrlMapping)) {
            return customUrlMapping;
        }

        throw new EntityIdConflictException("shortUrl already in use");
    }

    public void deleteUrlMapping(String shortUrl) {
        try {
            urlMappingRepository.delete(shortUrl);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException();
        }
    }

    private boolean saveUrlMapping(UrlMapping urlMapping) {
        boolean success = false;
        if (urlMappingRepository.exists(urlMapping.getShortUrl())) {
            UrlMapping existingUrlMapping = urlMappingRepository.findOne(urlMapping.getShortUrl());
            if (urlMapping.equals(existingUrlMapping)) {
                success = true;
            }
        } else {
            urlMappingRepository.save(urlMapping);
            success = true;
        }

        return success;
    }

}
