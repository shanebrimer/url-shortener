package com.craft.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.craft.demo.model.UrlMapping;
import com.craft.demo.repository.UrlMappingRepository;

@Service
public class UrlMappingService {

    @Autowired
    private EncoderService encoderService;
    @Autowired
    private UrlMappingRepository urlMappingRepository;

    public List<UrlMapping> getAllUrlMappings() {
        return (List<UrlMapping>) urlMappingRepository.findAll();
    }

    public UrlMapping getUrlMapping(String shortUrl) {
        return urlMappingRepository.findOne(shortUrl);
    }

    public UrlMapping createUrlMapping(String redirectUrl) {
        String shortUrl = encoderService.encode(redirectUrl);
        UrlMapping urlMapping = new UrlMapping(shortUrl, redirectUrl);
        urlMappingRepository.save(urlMapping);
        return urlMapping;
    }

    // int hash = redirectUrl.hashCode();
    // // byte[] hashBytes = ByteBuffer.allocate(4).putInt(hash).array();
    // byte[] hashBytes = BigInteger.valueOf(hash).toByteArray();
    // String shortUrl = Base64.getUrlEncoder().encodeToString(hashBytes);
    // return new UrlMapping(shortUrl, redirectUrl);

}
