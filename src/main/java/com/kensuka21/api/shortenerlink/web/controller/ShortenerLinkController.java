package com.kensuka21.api.shortenerlink.web.controller;

import com.kensuka21.api.shortenerlink.dto.ShortenerLinkDTO;
import com.kensuka21.api.shortenerlink.service.ShortenerLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

/**
 * Created by kesalcedo on 5/20/2016.
 */
@Controller()
public class ShortenerLinkController {

    @Autowired
    private ShortenerLinkService shortenerLinkService;

    @RequestMapping(value = "/{shortUrl}", method = RequestMethod.GET)
    public void redirectTo(@PathVariable("shortUrl") String shortUrl, HttpServletResponse response) throws Exception{
        Optional<ShortenerLinkDTO> shortenerLinkDTO = shortenerLinkService.findOneByUniqueKey(shortUrl);

        if(shortenerLinkDTO.isPresent()){
            ShortenerLinkDTO dto = shortenerLinkDTO.get();
            response.sendRedirect(dto.getLongUrl());
        }else{
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            throw new Exception("This URL is not registered in this ShortenerLink Api");
        }
    }

}
