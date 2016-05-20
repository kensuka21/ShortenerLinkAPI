package com.kensuka21.api.shortenerlink.entity;

import com.kensuka21.api.shortenerlink.dto.ShortenerLinkDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by kesalcedo on 5/20/2016.
 */
@Entity
public class ShortenerLink {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String longUrl;
    private String shortUrl;
    private String uniqueKey;

    public ShortenerLink() {
    }

    public ShortenerLink(ShortenerLinkDTO dto) {
        this.longUrl = dto.getLongUrl();
        this.shortUrl = dto.getShortUrl();
        this.uniqueKey = dto.getUniqueKey();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
