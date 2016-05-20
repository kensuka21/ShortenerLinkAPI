package com.kensuka21.api.shortenerlink.service;

import com.kensuka21.api.shortenerlink.dto.ShortenerLinkDTO;

import java.util.Optional;

/**
 * Created by kesalcedo on 5/20/2016.
 */
public interface ShortenerLinkService extends Service<ShortenerLinkDTO, Integer> {
    Optional<ShortenerLinkDTO> shortenerlink(ShortenerLinkDTO dto, String baseUrl);
    Optional<ShortenerLinkDTO> findOneByShortUrl(String shortUrl);
    Optional<ShortenerLinkDTO> findOneByUniqueKey(String uniqueKey);


}
