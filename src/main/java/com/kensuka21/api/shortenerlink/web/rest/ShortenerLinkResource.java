package com.kensuka21.api.shortenerlink.web.rest;

import com.kensuka21.api.shortenerlink.dto.ErrorDTO;
import com.kensuka21.api.shortenerlink.dto.ShortenerLinkDTO;
import com.kensuka21.api.shortenerlink.service.ShortenerLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Optional;

/**
 * Created by kesalcedo on 5/20/2016.
 */
@RestController
public class ShortenerLinkResource {

    @Autowired
    private ShortenerLinkService shortenerLinkService;

    @RequestMapping(value = "/api/shortenerlink", method = RequestMethod.POST)
    public ResponseEntity<?> shortenerlink(@RequestBody @Valid ShortenerLinkDTO shortenerLinkDTO, BindingResult result, HttpServletRequest request){
        String baseUrl = request.getRequestURL().substring(0, request.getRequestURL().indexOf("/api"));

        if(result.hasErrors()){
            return ResponseEntity.badRequest().body(new ErrorDTO("Invalid URL", true));
        }

        return shortenerLinkService.shortenerlink(shortenerLinkDTO, baseUrl).map(s -> {
            return ResponseEntity.ok(s);
        }).orElse(ResponseEntity.badRequest().body(null));
    }

}
