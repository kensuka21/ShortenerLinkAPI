package com.kensuka21.api.shortenerlink.service.impl;

import com.kensuka21.api.shortenerlink.dto.ShortenerLinkDTO;
import com.kensuka21.api.shortenerlink.entity.ShortenerLink;
import com.kensuka21.api.shortenerlink.repository.ShortenerLinkRepository;
import com.kensuka21.api.shortenerlink.service.ShortenerLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.ServletContext;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by kesalcedo on 5/20/2016.
 */
@Service("shortenerLinkService")
public class ShortenerLinkServiceImpl implements ShortenerLinkService{

    @Autowired
    private ShortenerLinkRepository shortenerLinkRepository;

    @Autowired
    private ServletContext servletContext;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Override
    public Optional<ShortenerLinkDTO> save(ShortenerLinkDTO obj) {
        shortenerLinkRepository.save(new ShortenerLink(obj));

        return Optional.of(obj);
    }

    @Override
    public Optional<ShortenerLinkDTO> update(ShortenerLinkDTO obj) {
        return null;
    }

    @Override
    public void remove(ShortenerLinkDTO obj) {

    }

    @Override
    public Optional<List<ShortenerLinkDTO>> findAll() {
        return null;
    }

    @Override
    public Optional<ShortenerLinkDTO> findOne(Integer id) {
        return null;
    }


    @Override
    public Optional<ShortenerLinkDTO> shortenerlink(ShortenerLinkDTO dto, String baseUrl) {
        String uniqueID = UUID.randomUUID().toString();
        String uniqueKey = uniqueID.substring(0, uniqueID.indexOf("-"));

        dto.setShortUrl(baseUrl + "/" + uniqueKey);
        dto.setUniqueKey(uniqueKey);
        Optional<ShortenerLink> shortenerLink = shortenerLinkRepository.findOneByLongUrl(dto.getLongUrl());

        if(shortenerLink.isPresent()){
            return shortenerLink.map(s -> {
                return Optional.of(new ShortenerLinkDTO(s));
            }).get();
        }else{
            return save(dto);
        }
    }

    @Override
    public Optional<ShortenerLinkDTO> findOneByShortUrl(String shortUrl) {
        return shortenerLinkRepository.findOneByLongUrl(shortUrl).map(s -> Optional.of(new ShortenerLinkDTO(s))).orElseGet(() -> Optional.empty());
    }

    @Override
    public Optional<ShortenerLinkDTO> findOneByUniqueKey(String uniqueKey) {
        return shortenerLinkRepository.findOneByUniqueKey(uniqueKey).map(s -> Optional.of(new ShortenerLinkDTO(s))).orElseGet(() -> Optional.empty());
    }
}
