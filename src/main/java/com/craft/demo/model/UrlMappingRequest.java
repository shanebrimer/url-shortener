package com.craft.demo.model;

public class UrlMappingRequest {

    private String redirectUrl;

    UrlMappingRequest() {
    }

    public UrlMappingRequest(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    @Override
    public String toString() {
        return "UrlMappingRequest [redirectUrl=" + redirectUrl + "]";
    }

}
