package com.kensuka21.api.shortenerlink.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.kensuka21.api.shortenerlink.entity.ShortenerLink;

import java.util.Optional;

/**
 * Created by kesalcedo on 5/20/2016.
 */
@Repository
public interface ShortenerLinkRepository extends JpaRepository<ShortenerLink, Integer>{
    Optional<ShortenerLink> findOneByLongUrl(String longUrl);
    Optional<ShortenerLink> findOneByShortUrl(String shortUrl);
    Optional<ShortenerLink> findOneByUniqueKey(String uniqueKey);
}
