package com.kensuka21.api.shortenerlink.dto;

import com.kensuka21.api.shortenerlink.entity.ShortenerLink;
import org.hibernate.validator.constraints.URL;

/**
 * Created by kesalcedo on 5/20/2016.
 */
public class ShortenerLinkDTO {
    @URL
    private String longUrl;
    private String shortUrl;
    private String uniqueKey;

    public ShortenerLinkDTO() {
    }

    public ShortenerLinkDTO(ShortenerLink entity) {
        this.longUrl = entity.getLongUrl();
        this.shortUrl = entity.getShortUrl();
        this.uniqueKey = entity.getUniqueKey();
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public String getUniqueKey() {
        return uniqueKey;
    }

    public void setUniqueKey(String uniqueKey) {
        this.uniqueKey = uniqueKey;
    }
}
