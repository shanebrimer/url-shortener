package com.craft.demo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UrlMapping implements Serializable {

    private static final long serialVersionUID = 409138464973073656L;

    @Id
    private String shortUrl;

    private String redirectUrl;

    UrlMapping() {
    }

    public UrlMapping(String shortUrl, String redirectUrl) {
        this.shortUrl = shortUrl;
        this.redirectUrl = redirectUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    @Override
    public String toString() {
        return "UrlMapping [shortUrl=" + shortUrl + ", redirectUrl=" + redirectUrl + "]";
    }

}
