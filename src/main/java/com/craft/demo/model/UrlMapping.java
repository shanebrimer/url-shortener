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
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((redirectUrl == null) ? 0 : redirectUrl.hashCode());
        result = prime * result + ((shortUrl == null) ? 0 : shortUrl.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UrlMapping other = (UrlMapping) obj;
        if (redirectUrl == null) {
            if (other.redirectUrl != null)
                return false;
        } else if (!redirectUrl.equals(other.redirectUrl))
            return false;
        if (shortUrl == null) {
            if (other.shortUrl != null)
                return false;
        } else if (!shortUrl.equals(other.shortUrl))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "UrlMapping [shortUrl=" + shortUrl + ", redirectUrl=" + redirectUrl + "]";
    }

}
